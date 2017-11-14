<%-- 
    Document   : login.jsp
    Created on : Nov 14, 2017, 10:24:26 AM
    Author     : emont
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Bienvenido</h1>
        <p>Introduzca usuario y contraseña de acceso</p>
        <form action="LoginController" method="post">
            <p>
                <label for="txtUser">Usuario</label>
                <input type="text" id="txtUser" name="txtUser"/>
            </p>
            <p>
                <label for="txtPassword">Contraseña</label>
                <input type="password" id="txtPassword" name="txtPassword"/>
            </p>
            <p>
                <input type="submit" value="enviar"/>
                <input type="reset" value="limpiar"/>
            </p>
        </form>
    </body>
</html>