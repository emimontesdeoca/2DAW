<%-- 
    Document   : newMovie
    Created on : Nov 20, 2017, 12:44:23 PM
    Author     : emont
--%>

<%@page import="es.cifpcm.ut04_05.controller.categoryController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Nueva pelicula</h2>

        <form action="movieController" method="post">

            Titulo <input type="text" name="title" required> 

            Genero <select name="category">
                <% for (es.cifpcm.ut04_05.category c : categoryController.getAllCategories()) {%>
                <option value="<%= c.getIdCategory()%>"> <%= c.getDescription()%></option>
                <%  }%>
            </select><br> <br>

            <button type="submit">Enviar</button>
        </form>
    </body>
</html>
