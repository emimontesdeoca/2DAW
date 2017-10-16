/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.calendario.welcome.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 *
 * @author emont
 */
@WebServlet(name = "IndexServlet", urlPatterns = {"/Index"})
public class IndexServlet extends HttpServlet {

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
            try {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet IndexServlet</title>");
                out.println("</head>");
                out.println("<body>");
                /*out.println("<h1>Servlet IndexServlet at " + request.getContextPath() + "</h1>");

                String name = request.getParameter("name");
                name = name == null ? "<Anonimo/a>" : name;
                out.println("<p>Bienvenido/a: " + StringEscapeUtils.escapeHtml4(name) + "</p>");*/

                int mes = 2;
                out.println(new DateFormatSymbols().getMonths()[mes]);
                Calendar calendar = new GregorianCalendar(2017, mes, 0);
                int a = calendar.get(Calendar.DAY_OF_WEEK);
                Calendar newc = new GregorianCalendar(2017, mes - 1, 0);
                int b = newc.getActualMaximum(Calendar.DAY_OF_MONTH);

                out.println("<table style=\"border:1px solid black\"");
                out.println("<tr>");
                out.println("<td>");
                out.println("L");
                out.println("</td>");
                out.println("<td>");
                out.println("M");
                out.println("</td>");
                out.println("<td>");
                out.println("X");
                out.println("</td>");
                out.println("<td>");
                out.println("J");
                out.println("</td>");
                out.println("<td>");
                out.println("V");
                out.println("</td>");
                out.println("<td>");
                out.println("S");
                out.println("</td>");
                out.println("<td>");
                out.println("D");
                out.println("</td>");
                out.println("</tr>");

                for (int i = 0, d = 1; i < 6; i++) {
                    out.println("<tr>");
                    for (int j = 1; j <= 7; j++) {

                        if (j == a && i == 0) {
                            out.println("<td> " + d + " </td>");
                            d++;
                        } else if (i > 0 || d > 1) {
                            if (d == b + 1 || (mes == 1 && d == 29)) {
                                d = 1;
                            }
                            out.println("<td> " + d + " </td>");

                            d++;
                        } else {
                            out.println("<td> " + (b - (7-j) ) + " </td>");
                        }

                    }
                    out.println("</tr>");
                }
                out.println("<table>");
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
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
