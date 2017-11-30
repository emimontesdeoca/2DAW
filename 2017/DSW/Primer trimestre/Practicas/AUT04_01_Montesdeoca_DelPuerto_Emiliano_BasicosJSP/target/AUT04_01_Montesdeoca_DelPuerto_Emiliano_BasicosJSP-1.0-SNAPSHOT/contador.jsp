<%-- 
    Document   : contador
    Created on : Nov 7, 2017, 11:44:25 AM
    Author     : emont
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contador</title>
    </head>
    <body>
        <h2>Contador!</h2>
        <%! static public int i = 0;%>
        <%
            i++;
            if (i >= 10) {
                out.println("Exito! El contador es ha llegado a " + i);
            } else {
                out.println("Contador: " + i);
            }
        %>
    </body>
</html>
