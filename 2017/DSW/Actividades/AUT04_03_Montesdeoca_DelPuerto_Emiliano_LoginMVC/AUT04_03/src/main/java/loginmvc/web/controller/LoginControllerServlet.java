/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginmvc.web.controller;

import java.io.IOException;
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
import es.cifpcm.loginmvc.web.model.Login;

/**
 *
 * @author emont
 */
public class LoginControllerServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            super.init();
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginControllerServlet.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conn
                = DriverManager.getConnection("jdbc:mysql://localhost:3306/consumoelectrico", "2daw", "2daw")) {
            String query = "SELECT login, id FROM consumoelectrico.login WHERE login=? AND password =  ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                String user = request.getParameter("txtUser");
                String password = request.getParameter("txtPassword");
                pstmt.setString(1, user);
                pstmt.setString(2, password);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) { 
                        // Hay registro luego login ok
                        Login l = new Login();
                        l.setUsername(user);
                        l.setPassword(password);
                        request.setAttribute("loginBean", l);
                            getServletContext().getRequestDispatcher("/loginSuccess.jsp").forward(request, response);
                    } else {

                        getServletContext().getRequestDispatcher("/loginFailed.jsp").forward(request, response);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginControllerServlet.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
