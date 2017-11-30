<%-- 
    Document   : LoginSuccess
    Created on : Nov 14, 2017, 10:11:27 AM
    Author     : emont
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="order" class="micafeteria.web.controller.Order" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido confirmado</title>
    </head>
    <body>
        <h1>Pedido correcto:  <jsp:getProperty name="order" property="total"/> €</h1>
    </body>
</html>