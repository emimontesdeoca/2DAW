/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.imagenes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author emont
 */
public class ImagenServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ImagenServlet</title>");
            /*out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + request.getContextPath() + "/css/style.css\">");*/
            out.println("</head>");
            out.println("<body>");
            /// Conseguir el valor del formulario, me devuelve le mes de 1 a 12
            Integer mes = Integer.parseInt(request.getParameter("mes"));

            /// Creamos el string para buscar la imagen
            String imgpath = request.getContextPath() + "/img/";
            /// Instanciamos un string para el estacion
            String estacion = "";

            /// Switch para asignar la imagen y la estacion
            switch (mes) {
                case 11:
                case 12:
                case 1:
                case 2:
                    imgpath += "invierno.jpg";
                    estacion = "Invierno";
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    imgpath += "primavera.jpg";
                    estacion = "Primavera";
                    break;
                case 7:
                case 8:
                    imgpath += "verano.jpg";
                    estacion = "Verano";
                    break;
                case 9:
                case 10:
                    imgpath += "otoño.jpg";
                    estacion = "Otoño";
                    break;
            }

            out.println("<h1>" + estacion + "<h1>");
            out.println("<img src=\"" + imgpath + "\">");

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
