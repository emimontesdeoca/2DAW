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
        try (PrintWriter out = response.getWriter()) {
            /// Combinacion ganadora
            TreeSet<Integer> COMBINACION_GANADORA = new TreeSet<>();
            Random rnd = new Random();
            while (COMBINACION_GANADORA.size() < 6) {
                int num = rnd.nextInt(45) + 1;

                if (!COMBINACION_GANADORA.contains(num)) {
                    COMBINACION_GANADORA.add(num);
                }
            }
            /// Combinacion de jugador
            String[] szNumeros = request.getParameterValues("numero");
            TreeSet<Integer> COMBINACION_JUGADOR = new TreeSet<>();

            while (COMBINACION_JUGADOR.size() < 6) {
                for (String s : szNumeros) {
                    COMBINACION_JUGADOR.add(Integer.parseInt(s));
                }
            }

            Integer aciertos = 0;
            for (Integer integer : COMBINACION_JUGADOR) {
                if (COMBINACION_GANADORA.contains(integer)) {
                    aciertos++;
                }
            }

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResultadosServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Has acertado " + aciertos + " de 6</h1>");
            out.println("<h2>Combinacion ganadora: " + COMBINACION_GANADORA.toString() + "</h2>");
            out.println("<h4>Tus números: " + COMBINACION_JUGADOR.toString() + "</h4>");

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
