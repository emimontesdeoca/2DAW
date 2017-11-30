/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.euromillon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.TreeSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author emont
 */
public class ResultadosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String errorMessage = "";
        String value = "";

        try (PrintWriter out = response.getWriter()) {
            /// Objetos


            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResultadosServlet</title>");
            out.println("</head>");
            out.println("<body>");
            try {
                TreeSet<Integer> COMBINACION_GANADORA = new TreeSet<>();
                TreeSet<Integer> COMBINACION_JUGADOR = new TreeSet<>();
                String[] szNumeros = request.getParameterValues("numero");
                Integer aciertos = 0;

                Random rnd = new Random();
                while (COMBINACION_GANADORA.size() < 6) {
                    int num = rnd.nextInt(45) + 1;

                    if (!COMBINACION_GANADORA.contains(num)) {
                        COMBINACION_GANADORA.add(num);
                    }
                }
                /// Combinacion de jugador

                try {
                    while (true) {
                        for (String s : szNumeros) {
                            value = s;
                            COMBINACION_JUGADOR.add(Integer.parseInt(s));
                        }
                        break;

                    }

                } catch (Exception e) {
                    if (value.equals("")) {
                        errorMessage = "Ha introducido algun campo vacio!";
                    } else {
                        errorMessage = "Ha introducido algun numero con decimal!";
                    }
                    throw new Exception();
                }

                if (COMBINACION_JUGADOR.size() < 6) {
                    if (szNumeros.length == 6) {
                        errorMessage = "Ha introducido numeros duplicados!";
                    } else {
                        errorMessage = "Ha introducido menos de 6 numeros!!";
                    }
                    throw new Exception();
                }

                for (Integer integer : COMBINACION_JUGADOR) {
                    if (COMBINACION_GANADORA.contains(integer)) {
                        aciertos++;
                    }
                }
                out.println("<h1>Has acertado " + aciertos + " de 6</h1>");
                out.println("<h2>Combinacion ganadora: " + COMBINACION_GANADORA.toString() + "</h2>");
                out.println("<h4>Tus números: " + COMBINACION_JUGADOR.toString() + "</h4>");
            } catch (Exception e) {
                out.println("<h1>Error!</h1>");
                out.println("<h3>" + errorMessage + "</h3>");

            }

            out.println("</body>");
            out.println("</html>");
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
