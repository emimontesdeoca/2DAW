/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package micafeteria.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author emont
 */
public class CafeOrderServlet extends HttpServlet {

    public static String errormsg = "";

    @Override
    public void init() throws ServletException {
        try {
            super.init();
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CafeOrderServlet.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /// Variables para uso
        Double total = 0.0;
        Integer tipoCafe = 0;
        Double valorCafe = 0.0;
        Integer numeroExtras = 0;
        /// Tipo cafe viene un valor 1/2 dependiendo del tipo
        tipoCafe = Integer.parseInt(request.getParameter("tipo"));

        /// Si es tipo 1 es solo, si es tipo 2 es descafeinado
        switch (tipoCafe) {
            case 1:
                valorCafe = 1.0;
                break;
            case 2:
                valorCafe = 1.2;
                break;
        }

        /// Todos los extras, ncesario para pasar por insert
        String[] extras = request.getParameterValues("extra");

        if (extras == null) {
            extras = new String[0];
        }

        /// total en numeros de extras, para el calculo
        numeroExtras = extras.length;
        /// Suma total
        total = valorCafe + (numeroExtras * 0.5);

        if (insertOrder(tipoCafe, extras, total)) {
            /// Como todo funciona, creamos una orden con los valores que pasamos la insert y la pasmos por bean
            Order o = new Order();
            o.setOrderID(0);
            o.setTipoCafe(tipoCafe.toString());
            o.setNumeroExtras(numeroExtras);
            o.setTotal(total);

            String builder = "";
            for (String extra : extras) {
                builder += extra + ",";
            }
            o.setExtras(builder);
            /// A la request le ponemos el objeto
            request.setAttribute("order", o);
            getServletContext().getRequestDispatcher("/success.jsp").forward(request, response);
        } else {
            errormsg = "Error al realizar el pedido";

            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }

    }

    public static Boolean insertOrder(Integer tipoCafe, String[] extras, Double total) {

        String builder = "";

        for (String extra : extras) {
            builder += extra + ", ";
        }

        try (Connection conn
                = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafeteria", "2daw", "2daw")) {
            String query = "INSERT INTO `pedidos`(`id_cafe`, `extras`, `precio`) VALUES (?,?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, tipoCafe);
                pstmt.setString(2, builder);
                pstmt.setDouble(3, total);

                try {
                    pstmt.execute();
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CafeOrderServlet.class.getName()).log(Level.SEVERE, null,
                    ex);

            return false;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
