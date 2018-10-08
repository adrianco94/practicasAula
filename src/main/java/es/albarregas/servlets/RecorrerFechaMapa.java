/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "RecorrerFechaMapa", urlPatterns = {"/RecorrerFechaMapa"})
public class RecorrerFechaMapa extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RecorrerFechaMapa</title>");
            out.println("</head>");
            out.println("<body>");
            String[] errores = new String[4];
            int[] diasMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (request.getParameter("Nombre").length() == 0) {
                errores[0] = "No se ha introducido el Nombre";
            }
            if (request.getParameter("Usuario").length() == 0) {
                errores[1] = "No se ha introducido el Usuario";
            }
            if (request.getParameter("Password").length() == 0) {
                errores[2] = "No se ha introducido el Password";
            }

            if (esBisiesto(Integer.parseInt(request.getParameter("anio")))) {
                diasMes[2] = 29;
            }

            if (Integer.parseInt(request.getParameter("dia")) > diasMes[Integer.parseInt(request.getParameter("mes"))]) {
                errores[3] = "La fecha es incorrecta";
            }
            boolean hayErrores = false;
            for (int i = 0; i < errores.length; i++) {
                if (errores[i] != null) {
                    hayErrores = true;

                }
            }

            if (hayErrores) {
                out.println("<div id=\"errores\">");
                out.println("HAY ERROR(ES)");
                out.println("<br>");
                for (int i = 0; i < errores.length; i++) {
                    if (errores[i] != null) {
                        out.println(errores[i]);
                        out.println("<br>");
                    }
                }
                out.println("</div>");
                out.println("<a href=\"html/registro.html\">Volver al formulario</a>");
            } else {
                //out.println("No hay error");
                Map mapa = request.getParameterMap();
                String elemento;
                String fecha = "";
                String[] meses = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
                Iterator it=mapa.entrySet().iterator();
                
                while (it.hasNext()) {
                    Map.Entry<String,String[]> entry= (Map.Entry<String,String[]>) it.next();
                   
                    
                    
        /*
                    
                    if (entry.getKey().equals("dia")) {
                        fecha = request.getParameter(elemento);
                    } else if (elemento.equals("mes")) {
                        fecha = fecha + " de " + meses[Integer.parseInt(request.getParameter(elemento))];
                    } else if (elemento.equals("anio")) {
                        fecha = fecha + " de " + request.getParameter(elemento);
                        out.println("Fecha: " + fecha);
                        out.println("<br>");

                    } else if (elemento.equals("boton")) {
                    } else {
                        out.println(elemento + ": " + request.getParameter(elemento));
                        out.println("<br>");
                    }
*/
                }
            }
            //Para las aficiones getParameterValues
            out.println("<a href=\"index.html\">Menú principal</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected boolean esBisiesto(int anio) {
        return anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
