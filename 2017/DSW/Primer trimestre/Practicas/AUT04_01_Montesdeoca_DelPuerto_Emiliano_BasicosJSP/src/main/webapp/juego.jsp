<%-- 
    Document   : juego
    Created on : Nov 7, 2017, 11:22:06 AM
    Author     : emont
--%>

<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1>Resultado!</h1>
        <%
            Boolean a = Boolean.parseBoolean(request.getParameter("valor"));
            Integer b = Integer.parseInt(request.getParameter("dinero"));
            Boolean res = new Random().nextBoolean();
            if (a == res) {
                out.println("Ha ganado!");
                out.println("Su dinero es: " + b * 2);
                out.println("<br><img src=\"img/dinero.jpg\" style=\"width:20%;\">");
            } else {
                out.println("Ha perdido!");
                out.println("<br><img src=\"img/arruinado-en-inversiones.jpg\">");
            }
        %>
    </body>
</html>
