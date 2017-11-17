<%-- 
    Document   : loginFailed
    Created on : Nov 14, 2017, 10:14:40 AM
    Author     : emont
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="micafeteria.web.controller.CafeOrderServlet"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1> Error</h1>

        <h2><%= CafeOrderServlet.errormsg%></h2>
    </body>
</html>


