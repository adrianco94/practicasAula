<%-- 
    Document   : controlSesion
    Created on : 08-oct-2018, 17:06:42
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% StringBuilder mensaje = new StringBuilder();
    StringBuilder url = new StringBuilder("menuSession.jsp");
    String nombre = request.getParameter("nombre");
    HttpSession sesion = request.getSession();

    if (request.getParameter("enviar").equals("Inicio")) {
        url.replace(0, url.length(), request.getContextPath());
    } else {
        if (nombre.length() != 0) {
            String string = (String) sesion.getAttribute(nombre);
            switch (request.getParameter("enviar")) {
                case "Crear":
                    if (string == null) {

                    } else {

                    }
                    break;
                    case "Visualizar":
                    if (string == null) {

                    } else {

                    }
                    break;
                    case "Modificar":
                    if (string == null) {

                    } else {

                    }
                    break;
                    case "Eliminar":
                    if (string == null) {

                    } else {

                    }
                    break;
            }
        }
    }
    response.sendRedirect(url.toString());
%>