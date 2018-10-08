<%-- 
    Document   : edadPersona
    Created on : 03-oct-2018, 17:16:13
    Author     : USUARIO
--%>

<%@page import="java.time.Period"%>
<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalTime" %>
<!DOCTYPE html PUBLIC "‐//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edad Persona</title>
    </head>
    <body>
        <% String fechaNacS = request.getParameter("fecha");
            int diaNac = Integer.parseInt(fechaNacS.substring(8, 10));
            int mesNac = Integer.parseInt(fechaNacS.substring(5, 7));
            int anioNac = Integer.parseInt(fechaNacS.substring(0, 4));
            LocalDate fechaNac = LocalDate.of(anioNac, mesNac, diaNac);
            Period diferencia = Period.between(fechaNac, LocalDate.now());
            String cadenaAnios=null, cadenaMeses=null, cadenaDias=null;
            if (!diferencia.isNegative()) {
                StringBuilder cadena = new StringBuilder(request.getParameter("nombre") + " tienes ");
                if (diferencia.getYears() == 1) {
                    cadena.append("1 año, ");
                } else if (diferencia.getYears() > 1) {
                    cadena.append(diferencia.getYears());
                }
            } else {
        %><h1><%= request.getParameter("nombre")%> todavía no has nacido. </h1>  <%
            }
        %>

    </body>
</html>
