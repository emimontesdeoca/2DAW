/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.calendario.welcome.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormatSymbols;
import java.time.YearMonth;
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
                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + request.getContextPath() + "/css/style.css\">");
                out.println("</head>");
                out.println("<body>");

                int mes = Integer.parseInt(request.getParameter("mes"));
                

                /// Nombre mes actual
                String header = "<p class=\"header\">" + new DateFormatSymbols().getMonths()[mes] + "</p>";
                out.println(header);
                Calendar calendar = new GregorianCalendar(2017, mes, 0);
                int a = calendar.get(Calendar.DAY_OF_WEEK);

                /// Mes anterior
                //int mesAnterior = mes;
                //Calendar newc = new GregorianCalendar(2017, mesAnterior, 0);
                YearMonth yearMonthObject ;
                int b = 0;
                 int daysInMonth = 0;
                 
                if (mes == 0) {
                     daysInMonth = 31;
                }else{
                 yearMonthObject = YearMonth.of(2017, mes);
                 daysInMonth = yearMonthObject.lengthOfMonth(); //28  
                }
                
                b = daysInMonth;

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
                int e = a;
                for (int i = 0, d = 1; i < 6; i++) {
                    out.println("<tr>");
                    for (int j = 1; j <= 7; j++) {

                        if (j == a && i == 0) {
                            out.println("<td> " + d + " </td>");
                            d++;
                        } else if (i > 0 || d > 1) {
                            if ((d == b && b == 31) || (mes == 2 && d == 32) || (mes == 1 && d == 29) || (d == b + 2 && b == 30)) {
                                d = 1;
                            }

                            out.println("<td> " + d + " </td>");
                            d++;
                        } else {
                            int x = 0;
                            if ((mes == 0)) {
                                x = (j - (e - j)) + 31;
                            }else{
                                x = (j - (e - j)) + b;
                            }                           
                            e++;
                            out.println("<td> " + x + " </td>");
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
