<%@page import="java.util.*"%>
<%@page import="web.controllers.clienteController"%>
<%@page import="web.utils.servletUtils"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>Consumo eléctrico JSP MVC</title>
    </head>
    <body>
        <%!
            /// Variables globales
            Integer take;
            Integer skip;
            String name;
            Integer totalclientes;
        %>

        <%
            /// Conseguir el total de clientes, solo lo hace una vez ya que luego nunca dejara de ser nulo
            try {
                if (totalclientes == null) {
                    totalclientes = servletUtils.getAllClientes(0, 0).size();
                }
            } catch (Exception e) {
            }
            /// Conseguir el nombre, se guarda uan vez en variable gloabal para cuando se hace POST sobre si mismo no se pierde
            try {
                String getname = request.getParameter("nameToSearch");
                if (getname != null) {
                    name = getname;
                } else if (getname == null && name != null) {

                } else {
                    name = "ninguno";
                }
            } catch (Exception e) {
            }

        %>
        <h3>El usuario introducido en el formulario es <%= name%></h3>

        <h1>Clientes de consumo eléctrico!</h1>

        <%
            /// Variable con la que sabemos cuantros clientes se piden
            try {
                if (take == null && request.getParameter("pag") == null) {
                    /// Si no hay nada usar default 
                    take = 10;
                } else {
                    /// Si no leer el parametro
                    take = Integer.parseInt(request.getParameter("pag"));
                }
            } catch (Exception e) {
            }

            /// Buscar la cookie para el skip
            Cookie pageSizeCookie = servletUtils.getCookie(request, "cookieps");
            /// Si la cookie no es nula y no se ha pedido unn parametro
            if (pageSizeCookie != null && request.getParameter("npag") == null) {
                /// Usar la cookie
                skip = Integer.parseInt(pageSizeCookie.getValue());
            } else {
                /// Si la cookie es nula o no, no importa ya que se utiliza el parametro pasado,
                /// Si no se mostraria siempre lo que tiene la cookie
                String newPag = request.getParameter("npag");
                if (newPag != null) {
                    /// Primero seria skip 0 y pillar lo que envie el usario
                    if (newPag.equals("pri")) {
                        skip = 0;
                        /// Anterior hay estart al skip
                    } else if (newPag.equals("ant")) {
                        skip -= take;
                        /// Siguiente hay que sumar al skip
                    } else if (newPag.equals("sig")) {
                        skip += take;
                        /// Ultimo seria el total menos lo que pdia el usaurio
                    } else if (newPag.equals("ult")) {
                        skip = totalclientes - take;
                    }

                    /// Para que no pueda ser negativo
                    if (skip < 0) {
                        skip = 0;
                    }
                    /// Por si te pases del total
                    if (skip > totalclientes) {
                        skip = totalclientes - take;

                    }

                    /// Reactualizar la cookie o crearla
                    Cookie savePageSizeCookie = new Cookie("cookieps", skip.toString());
                    // 1 año de vida
                    savePageSizeCookie.setMaxAge(24 * 60 * 60 * 365);
                    savePageSizeCookie.setPath(request.getContextPath());
                    response.addCookie(savePageSizeCookie);

                } else {
                    skip = 0;
                }
            }
        %>

        <table id="table-clients">
            <tr>
                <th>Nombre</th>
                <th>Población</th>
                <th>Provincia</th>
            </tr>

            <% for (clienteController c : servletUtils.getAllClientes(skip, take)) {%>
            <tr>
                <td><%= c.getNombre()%> <%= c.getApellido()%></td>
                <td><%= c.getPoblacion()%></td>
                <td><%= c.getProvincia()%></td>  
            </tr>
            <%}%>

            <div class="contenedorBotones">
                <form action="busquedaClientes.jsp" method="POST">
                    <button type="submit" name="npag" value="pri">|<</button>
                    <button type="submit" name="npag" value="ant"><</button>
                    <button type="submit" name="npag" value="sig">></button>
                    <button type="submit" name="npag" value="ult">>|</button>
                </form>
            </div>
        </table>
    </body>
</html>
