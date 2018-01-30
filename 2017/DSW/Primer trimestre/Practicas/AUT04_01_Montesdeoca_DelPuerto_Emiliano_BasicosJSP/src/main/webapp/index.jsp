<%-- 
    Document   : welcome
    Created on : Nov 7, 2017, 11:35:32 AM
    Author     : emont
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Date a = new Date();

            Integer hora = a.getHours();
            Integer min = a.getMinutes();
            Integer day = a.getDate();
            Integer month = a.getMonth() + 1;
            Integer year = a.getYear() + 1900;

            String build = "Son las " + hora + ":" + min + " horas del día " + day + " del " + month + " de " + year;

            out.println("<h1>" + build + "!</h1>");

        %>
    </body>
</html>
