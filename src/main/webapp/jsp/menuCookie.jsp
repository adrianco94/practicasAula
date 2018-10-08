<%-- 
    Document   : menuCookie
    Created on : 08-oct-2018, 4:15:31
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú Cookie</title>
        <style>body{text-align: center} </style>
    </head>
    <body>
        <h1>Menú Cookie</h1>
        <form action="controlCookie.jsp" method="post">
            <fieldset>
                <legend><h3>Datos Cookie:</h3></legend>
                <label for="nombre">Nombre: </label>
                <input type="text" name="nombre" id="nombre" required="required"><br>
                <label for="valor">Valor: </label>
                <input type="text" name="valor" id="valor"><br>
                <input type="submit" name="enviar" value="Crear">
                <input type="submit" name="enviar" value="Visualizar">
                <input type="submit" name="enviar" value="Modificar">
                <input type="submit" name="enviar" value="Eliminar"><br>
                <% if (request.getParameter("mensaje") != null) {
                %><h2><%= request.getParameter("mensaje")%> </h2>     <%
                    }%>
            </fieldset>
        </form>
    </body>
</html>
