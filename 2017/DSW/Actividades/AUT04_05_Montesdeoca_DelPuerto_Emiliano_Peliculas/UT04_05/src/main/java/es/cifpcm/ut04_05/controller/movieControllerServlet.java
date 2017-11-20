/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.ut04_05.controller;

import es.cifpcm.ut04_05.movie;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class movieControllerServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            super.init();
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String title = request.getParameter("title");
        Integer idCategory = Integer.parseInt(request.getParameter("category"));

        if (title == null) {
            getServletContext().getRequestDispatcher("/newMovie.jsp").forward(request, response);
        }

        es.cifpcm.ut04_05.movie m = new movie(0, idCategory, title);

        if (insertMovie(m)) {
            getServletContext().getRequestDispatcher("/success.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);

        }

    }

    public static Boolean insertMovie(es.cifpcm.ut04_05.movie m) {

        try (Connection conn
                = DriverManager.getConnection("jdbc:mysql://localhost:3306/peliculas", "2daw", "2daw")) {
            String query = "INSERT INTO `movies`(`IdCategory`, `Title`) VALUES (?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, m.getIdCategory());
                pstmt.setString(2, m.getTitle());

                try {
                    pstmt.execute();
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        } catch (SQLException ex) {
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
