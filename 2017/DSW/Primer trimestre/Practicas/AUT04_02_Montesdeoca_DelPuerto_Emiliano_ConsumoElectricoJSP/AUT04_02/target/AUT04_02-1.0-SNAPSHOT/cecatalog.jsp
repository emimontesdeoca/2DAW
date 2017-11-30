<%-- 
    Document   : cecatalog
    Created on : Nov 9, 2017, 8:34:40 AM
    Author     : emont
--%>

<%@page import="java.util.*"%>
<%@page import="es.cifpcm.aut04_02.cliente"%>
<%@page import="es.cifpcm.aut04_02.utils"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>Consumo eléctrico JSP</title>
    </head>
    <body>
        <h3>El usuario introducido en el formulario es <%= request.getParameter("nameToSearch")%></h3>

        <h1>Clientes de consumo eléctrico!</h1>

        <table id="table-clients">
            <tr>
                <th>Nombre</th>
                <th>Poblacion</th>
                <th>Provincia</th>
            </tr>
            <% for (cliente c : utils.getAllClientes()) {%>
            <tr>
                <td><%= c.getNombre()%> <%= c.getApellido()%></td>
                <td><%= c.getPoblacion()%></td>
                <td><%= c.getProvincia()%></td>  
            </tr>
            <%}%>
        </table>
    </body>
</html>
