<%-- 
    Document   : calculadora
    Created on : 04-oct-2018, 21:14:16
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.lang.NumberFormatException" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style> body{text-align: center;} </style>
    </head>
    <body>
        <%
            String resultado="";
            if (request.getParameter("enviar") != null) {
                
                if (request.getParameter("ope1").equals("") || request.getParameter("ope2").equals("")) {
                    resultado = "Campo(s)  vacío(s)";
                } else {
                    boolean fallo = false;
                    double num1 = 0;
                    double num2 = 0;
                    try {
                        num1 = Float.parseFloat(request.getParameter("ope1"));
                        num2 = Float.parseFloat(request.getParameter("ope2"));
                    } catch (NumberFormatException e) {
                        resultado = "Caracteres incorrectos. Debe introducir números reales(punto como separación)";
                        fallo = true;
                    }
                    if (fallo == false) {
                        if (request.getParameter("operacion").equals("Sumar")) {
                            resultado = "El resultado es " + num1 + " + " + num2 + " = " + (num1 + num2);
                        } else if (request.getParameter("operacion").equals("Restar")) {
                            resultado = "El resultado es " + num1 + " - " + num2 + " = " + (num1 - num2);
                        } else if (request.getParameter("operacion").equals("Multiplicar")) {
                            resultado = "El resultado es " + num1 + " x " + num2 + " = " + (num1 * num2);
                        } else if (request.getParameter("operacion").equals("Dividir")) {
                            if (num2 == 0) {
                                resultado = "No se puede realizar la división entre 0";
                            } else {
                                resultado = "El resultado es " + num1 + " / " + num2 + " = " + (num1 / num2);
                            }
                        }
                    }
                }
            }
        %>
        <h1>Calculadora Básica</h1>
        <h2><%=resultado%></h2>
        <form action="calculadora.jsp" method="post">
            <label for="ope1">Operando 1:</label>
            <input type="text" name="ope1" id="ope1">
            <label for="ope2">Operando 2:</label>
            <input type="text" name="ope2" id="ope2"><br>
            <label for="operacion1">Sumar:</label>
            <input type="radio" name="operacion" value="Sumar" checked="checked" id="operacion1">
            <label for="operacion2">Restar:</label>
            <input type="radio" name="operacion" value="Restar" id="operacion2">
            <label for="operacion3">Multiplicar:</label>
            <input type="radio" name="operacion" value="Multiplicar"id="operacion3">
            <label for="operacion4">Dividir:</label>
            <input type="radio" name="operacion" value="Dividir"id="operacion4"> <br>
            <input type="submit" value="Enviar" name="enviar">
            <input type="reset" value="Limpiar">
            <a href="../index.html"><input type="button" value="Menú Principal"></a>
        </form>
    </body>
</html>
<%-- 
    dos cuadros de reales para sumar restar multiplicar o dividir (marcar sumar por defecto el 
radio button)

numeros reales
mensaje "El resultado es 23 + 32 = resultado" y con la fecha encima
si se divide entre 0 sale el mensaje pertinente
un vacío debe avisar que está vacío
tres botones enviar limpiar menu principal(getContexPath), dentro del <a href pones el input 
del tipo button
--%>