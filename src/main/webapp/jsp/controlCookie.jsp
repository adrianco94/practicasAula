<%-- 
    Document   : controlCookie
    Created on : 04-oct-2018, 20:49:57
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensaje = null;
    String nombre = request.getParameter("nombre");
    Cookie cookie = null;
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals(nombre)) {
                cookie = cookies[i];
                break;
            }
        }
    }
    //Los espacios son %20
    if (request.getParameter("enviar").equals("Crear")) {
        if (cookie == null) {
            cookie = new Cookie(nombre, request.getParameter("valor"));
            cookie.setMaxAge(60);//tiempo de vida 1 minuto
            response.addCookie(cookie);
            mensaje = "Cookie creada con nombre: " + nombre + " y valor: " + request.getParameter("valor");

        } else {
            mensaje = "La cookie " + nombre + " ya existe y no se puede crear";
        }
    } else if (request.getParameter("enviar").equals("Visualizar")) {
        if (cookie != null) {
            mensaje = "La cookie " + nombre + " tiene el valor " + cookie.getValue();
        } else {
            mensaje = "La cookie " + nombre + " no existe";
        }

    } else if (request.getParameter("enviar").equals("Modificar")) {
        if (cookie != null) {
            cookie.setValue(request.getParameter("valor"));
            response.addCookie(cookie);
            mensaje = "La cookie " + nombre + " ha sido modificada con el valor: " + cookie.getValue();
        } else {
            mensaje = "La cookie " + nombre + " no existe";
        }
    } else {
        if (cookie != null) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            mensaje = "La cookie " + nombre + " ha sido eliminada";
        } else {
            mensaje = "La cookie " + nombre + " no existe";
        }

    }
    response.sendRedirect("menuCookie.jsp?mensaje=" + mensaje);
%>
