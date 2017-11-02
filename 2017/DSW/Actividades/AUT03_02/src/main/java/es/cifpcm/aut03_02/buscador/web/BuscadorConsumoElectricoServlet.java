/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.aut03_02.buscador.web;

import es.cifpcm.aut03_02.cliente;
import es.cifpcm.aut03_02.medicion;
import es.cifpcm.aut03_02.utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ResourceBundle;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author emont
 */
public class BuscadorConsumoElectricoServlet extends HttpServlet {

    public static String dbUrl;
    public static String dbUser;
    public static String dbPassword;
    public static Integer dbPageSize;
    public static Integer DEFAULT_PAGESIZE = 10;
    public static String driverClassName;
    public static String classForName;

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
            out.println("<title>Servlet BuscadorConsumoElectricoServlet</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + request.getContextPath() + "/css/style.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Clientes de consumo electrico</h1>");

            List<cliente> listaClientes = utils.getAllClientes();

            out.println("<table id=\"table-clients\">");
            out.println("<tr>");
            out.println("<th>Nombre</th>");
            out.println("<th>Apellido</th>");
            out.println("<th>Nombre calle</th>");
            out.println("<th>Numero</th>");
            out.println("<th>Codigo Postal</th>");
            out.println("<th>Poblacion</th>");
            out.println("<th>Provincia</th>");
            out.println("</tr>");

            for (cliente c : listaClientes) {
                out.println("<tr>");
                out.println("<td>" + c.getNombre() + "</td>");
                out.println("<td>" + c.getApellido() + "</td>");
                out.println("<td>" + c.getNombreCalle() + "</td>");
                out.println("<td>" + c.getNumero() + "</td>");
                out.println("<td>" + c.getCodPostal() + "</td>");
                out.println("<td>" + c.getPoblacion() + "</td>");
                out.println("<td>" + c.getProvincia() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

            out.println("<br>");
            out.println("<br>");
            out.println("<h2>Consumo para cliente</h2>");

            String name = request.getParameter("nombre");

            if (name != null && !name.isEmpty()) {
                cliente c = utils.getClienteByNombre(name);
                String builder = "<h4>El consumo total de " + c.getNombre() + " " + c.getApellido() + " es: " + Math.round(utils.getTotalMedicionCliente(c.getId()) * 100) / 100 + " KW</h4>";
                out.println(builder);

                List<medicion> listaMediciones = utils.getMedicionesById(c.getId());

                out.println("<table id=\"table-clients\">");
                out.println("<tr>");
                out.println("<th>idMedicion</th>");
                out.println("<th>FechaHora</th>");
                out.println("<th>KW</th>");
                out.println("</tr>");

                for (medicion m : listaMediciones) {
                    out.println("<tr>");
                    out.println("<td>" + m.getId() + "</td>");
                    out.println("<td>" + m.getFechaMedicion() + "</td>");
                    out.println("<td><button onclick=\"alert('La cantidad consumida es: " + Math.round(m.getKilow() * 100) / 100 + " KW')\">Ver KW</button></td>");
                    out.println("</tr>");
                }

                out.println("</table>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            String configBundleName = config.getInitParameter("app.config");
            ResourceBundle rb = ResourceBundle.getBundle(configBundleName);
            this.dbUrl = rb.getString("database.url");
            this.dbUser = rb.getString("database.user");
            this.dbPassword = rb.getString("database.password");
            this.dbPageSize = rb.getString("database.pageSize") == null ? DEFAULT_PAGESIZE : Integer.parseInt(rb.getString("database.pageSize"));
            this.driverClassName = rb.getString("database.driver");
            Class.forName(driverClassName);
        } catch (ClassNotFoundException ex) {

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
