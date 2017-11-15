<%@page import="java.util.*"%>
<%@page import="web.controllers.clienteController"%>
<%@page import="web.utils.servletUtils"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>Consumo eléctrico JSP</title>
    </head>
    <body>
        <%!
            Integer take;
            Integer skip;
            String name;
        %>

        <%
            try {
                name = request.getParameter("nameToSearch");
            } catch (Exception e) {
            }

        %>
        <h3>El usuario introducido en el formulario es <%= name%></h3>

        <h1>Clientes de consumo eléctrico!</h1>

        <table id="table-clients">
            <tr>
                <th>Nombre</th>
                <th>Poblacion</th>
                <th>Provincia</th>
            </tr>


            <%
                try {
                    take = Integer.parseInt(request.getParameter("pag"));
                } catch (Exception e) {
                }

                String newPag = request.getParameter("npag");
                if (newPag != null) {
                    if (newPag.equals("pri")) {
                        skip = 0;
                    } else if (newPag.equals("ant")) {
                        skip -= 10;

                    } else if (newPag.equals("sig")) {
                        skip += 10;
                    } else if (newPag.equals("ult")) {
                    }
                } else {
                    skip = 0;
                }
                /*
                switch (newPag) {
                    case "pri":
                        skip = 0;
                        break;
                    case "ant":
                        skip -= 10;
                        break;
                    case "sig":
                        skip += 10;
                        break;
                    case "ult":
                        break;
                    default:
                        skip = 0;
                }*/
            %>

            <h1> muestra: <%= take%></h1>
            <h1> salta: <%= skip%></h1>


            <% for (clienteController c : servletUtils.getAllClientes(skip, take)) {%>
            <tr>
                <td><%= c.getNombre()%> <%= c.getApellido()%></td>
                <td><%= c.getPoblacion()%></td>
                <td><%= c.getProvincia()%></td>  
            </tr>
            <%}%>

            <form action="busquedaClientes.jsp" method="POST">
                <button type="submit" name="npag" value="pri">|<</button>
                <button type="submit" name="npag" value="ant"><</button>
                <button type="submit" name="npag" value="sig">></button>
                <button type="submit" name="npag" value="ult">>|</button>


            </form>
        </table>
    </body>
</html>
