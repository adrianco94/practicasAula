/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "Registro", urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {

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
            out.println("<title>Servlet Registro</title>");
            out.println("<style>#errores{color:red;font-weight:bold;border:solid;border-width:medium}</style>");
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
               
                out.println(" <header>\n"
                        + "        <h1>Registro</h1>\n"
                        + "    </header>\n"
                        + "    <form action=\"Registro\" method=\"post\">\n"
                        + "        <fieldset>\n"
                        + "            <legend>Datos personales:</legend>\n"
                        + "            <label for=\"Nombre\">Nombre:</label>");
                out.println("<input type=\"text\" id=\"Nombre\" name=\"Nombre\" value=\"" + request.getParameter("Nombre") + "\">");
                out.println("<br>\n"
                        + "            <label for=\"Apellidos\">Apellidos:</label>\n"
                        + "            <input type=\"text\" id=\"Apellidos\" name=\"Apellidos\" value=\"" + request.getParameter("Apellidos") + "\" >\n"
                        + "            <br>\n"
                        + "            <label>Sexo: </label>\n");

                if (request.getParameter("Sexo").equals("Hombre")) {
                    out.println(" <input type=\"radio\" name=\"Sexo\" value=\"Hombre\" checked=\"checked\"> Hombre");
                    out.println(" <input type=\"radio\" name=\"Sexo\" value=\"Mujer\"> Mujer<br>");
                } else {
                    out.println(" <input type=\"radio\" name=\"Sexo\" value=\"Hombre\"> Hombre");
                    out.println(" <input type=\"radio\" name=\"Sexo\" value=\"Mujer\" checked=\"checked\"> Mujer<br>");

                }
                out.println("            <label>Fecha de nacimientos</label>\n"
                        + "            <select name=\"dia\" id=\"dia\">\n"
                        + "                <option value=\"" + request.getParameter("dia") + "\" selected=\"selected\">" + request.getParameter("dia") + "</option>\n"
                        + "                <option value=\"1\">1</option>\n"
                        + "                <option value=\"2\">2</option>\n"
                        + "                <option value=\"3\">3</option>\n"
                        + "                <option value=\"4\">4</option>\n"
                        + "                <option value=\"5\">5</option>\n"
                        + "                <option value=\"6\">6</option>\n"
                        + "                <option value=\"7\">7</option>\n"
                        + "                <option value=\"8\">8</option>\n"
                        + "                <option value=\"9\">9</option>\n"
                        + "                <option value=\"10\">10</option>\n"
                        + "                <option value=\"11\">11</option>\n"
                        + "                <option value=\"12\">12</option>\n"
                        + "                <option value=\"13\">13</option>\n"
                        + "                <option value=\"14\">14</option>\n"
                        + "                <option value=\"15\">15</option>\n"
                        + "                <option value=\"16\">16</option>\n"
                        + "                <option value=\"17\">17</option>\n"
                        + "                <option value=\"18\">18</option>\n"
                        + "                <option value=\"19\">19</option>\n"
                        + "                <option value=\"20\">20</option>\n"
                        + "                <option value=\"21\">21</option>\n"
                        + "                <option value=\"22\">22</option>\n"
                        + "                <option value=\"23\">23</option>\n"
                        + "                <option value=\"24\">24</option>\n"
                        + "                <option value=\"25\">25</option>\n"
                        + "                <option value=\"26\">26</option>\n"
                        + "                <option value=\"27\">27</option>\n"
                        + "                <option value=\"28\">28</option>\n"
                        + "                <option value=\"29\">29</option>\n"
                        + "                <option value=\"30\">30</option>\n"
                        + "                <option value=\"31\">31</option>\n"
                        + "            </select>/\n"
                        + "            <select name=\"mes\" id=\"mes\">\n"
                        + "                <option value=\"" + request.getParameter("mes") + "\" selected=\"selected\">" + request.getParameter("mes") + "</option>\n"
                        + "                <option value=\"1\">1</option>\n"
                        + "                <option value=\"2\">2</option>\n"
                        + "                <option value=\"3\">3</option>\n"
                        + "                <option value=\"4\">4</option>\n"
                        + "                <option value=\"5\">5</option>\n"
                        + "                <option value=\"6\">6</option>\n"
                        + "                <option value=\"7\">7</option>\n"
                        + "                <option value=\"8\">8</option>\n"
                        + "                <option value=\"9\">9</option>\n"
                        + "                <option value=\"10\">10</option>\n"
                        + "                <option value=\"11\">11</option>\n"
                        + "                <option value=\"12\">12</option>\n"
                        + "            </select>/\n"
                        + "            <select name=\"anio\" id=\"anio\">\n"
                        + "                <option value=\"" + request.getParameter("anio") + "\" selected=\"selected\">" + request.getParameter("anio") + "</option>\n"
                        + "                <option value=\"1920\">1920</option>\n"
                        + "                <option value=\"1921\">1921</option>\n"
                        + "                <option value=\"1922\">1922</option>\n"
                        + "                <option value=\"1923\">1923</option>\n"
                        + "                <option value=\"1924\">1924</option>\n"
                        + "                <option value=\"1925\">1925</option>\n"
                        + "                <option value=\"1926\">1926</option>\n"
                        + "                <option value=\"1927\">1927</option>\n"
                        + "                <option value=\"1928\">1928</option>\n"
                        + "                <option value=\"1929\">1929</option>\n"
                        + "                <option value=\"1930\">1930</option>\n"
                        + "                <option value=\"1931\">1931</option>\n"
                        + "                <option value=\"1932\">1932</option>\n"
                        + "                <option value=\"1933\">1933</option>\n"
                        + "                <option value=\"1934\">1934</option>\n"
                        + "                <option value=\"1935\">1935</option>\n"
                        + "                <option value=\"1936\">1936</option>\n"
                        + "                <option value=\"1937\">1937</option>\n"
                        + "                <option value=\"1938\">1938</option>\n"
                        + "                <option value=\"1939\">1939</option>\n"
                        + "                <option value=\"1940\">1940</option>\n"
                        + "                <option value=\"1941\">1941</option>\n"
                        + "                <option value=\"1942\">1942</option>\n"
                        + "                <option value=\"1943\">1943</option>\n"
                        + "                <option value=\"1944\">1944</option>\n"
                        + "                <option value=\"1945\">1945</option>\n"
                        + "                <option value=\"1946\">1946</option>\n"
                        + "                <option value=\"1947\">1947</option>\n"
                        + "                <option value=\"1948\">1948</option>\n"
                        + "                <option value=\"1949\">1949</option>\n"
                        + "                <option value=\"1950\">1950</option>\n"
                        + "                <option value=\"1951\">1951</option>\n"
                        + "                <option value=\"1952\">1952</option>\n"
                        + "                <option value=\"1953\">1953</option>\n"
                        + "                <option value=\"1954\">1954</option>\n"
                        + "                <option value=\"1955\">1955</option>\n"
                        + "                <option value=\"1956\">1956</option>\n"
                        + "                <option value=\"1957\">1957</option>\n"
                        + "                <option value=\"1958\">1958</option>\n"
                        + "                <option value=\"1959\">1959</option>\n"
                        + "                <option value=\"1960\">1960</option>\n"
                        + "                <option value=\"1961\">1961</option>\n"
                        + "                <option value=\"1962\">1962</option>\n"
                        + "                <option value=\"1963\">1963</option>\n"
                        + "                <option value=\"1964\">1964</option>\n"
                        + "                <option value=\"1965\">1965</option>\n"
                        + "                <option value=\"1966\">1966</option>\n"
                        + "                <option value=\"1967\">1967</option>\n"
                        + "                <option value=\"1968\">1968</option>\n"
                        + "                <option value=\"1969\">1969</option>\n"
                        + "                <option value=\"1970\">1970</option>\n"
                        + "                <option value=\"1971\">1971</option>\n"
                        + "                <option value=\"1972\">1972</option>\n"
                        + "                <option value=\"1973\">1973</option>\n"
                        + "                <option value=\"1974\">1974</option>\n"
                        + "                <option value=\"1975\">1975</option>\n"
                        + "                <option value=\"1976\">1976</option>\n"
                        + "                <option value=\"1977\">1977</option>\n"
                        + "                <option value=\"1978\">1978</option>\n"
                        + "                <option value=\"1979\">1979</option>\n"
                        + "                <option value=\"1980\">1980</option>\n"
                        + "                <option value=\"1981\">1981</option>\n"
                        + "                <option value=\"1982\">1982</option>\n"
                        + "                <option value=\"1983\">1983</option>\n"
                        + "                <option value=\"1984\">1984</option>\n"
                        + "                <option value=\"1985\">1985</option>\n"
                        + "                <option value=\"1986\">1986</option>\n"
                        + "                <option value=\"1987\">1987</option>\n"
                        + "                <option value=\"1988\">1988</option>\n"
                        + "                <option value=\"1989\">1989</option>\n"
                        + "                <option value=\"1990\">1990</option>\n"
                        + "                <option value=\"1991\">1991</option>\n"
                        + "                <option value=\"1992\">1992</option>\n"
                        + "                <option value=\"1993\">1993</option>\n"
                        + "                <option value=\"1994\">1994</option>\n"
                        + "                <option value=\"1995\">1995</option>\n"
                        + "                <option value=\"1996\">1996</option>\n"
                        + "                <option value=\"1997\">1997</option>\n"
                        + "                <option value=\"1998\">1998</option>\n"
                        + "                <option value=\"1999\">1999</option>\n"
                        + "                <option value=\"2000\">2000</option>\n"
                        + "                <option value=\"2001\">2001</option>\n"
                        + "                <option value=\"2002\">2002</option>\n"
                        + "                <option value=\"2003\">2003</option>\n"
                        + "                <option value=\"2004\">2004</option>\n"
                        + "                <option value=\"2005\">2005</option>\n"
                        + "                <option value=\"2006\">2006</option>\n"
                        + "                <option value=\"2007\">2007</option>\n"
                        + "                <option value=\"2008\">2008</option>\n"
                        + "                <option value=\"2009\">2009</option>\n"
                        + "                <option value=\"2010\">2010</option>\n"
                        + "                <option value=\"2011\">2011</option>\n"
                        + "                <option value=\"2012\">2012</option>\n"
                        + "                <option value=\"2013\">2013</option>\n"
                        + "                <option value=\"2014\">2014</option>\n"
                        + "                <option value=\"2015\">2015</option>\n"
                        + "                <option value=\"2016\">2016</option>\n"
                        + "                <option value=\"2017\">2017</option>\n"
                        + "                <option value=\"2018\">2018</option>\n"
                        + "            </select>\n"
                        + "\n"
                        + "        </fieldset>\n"
                        + "        <fieldset>\n"
                        + "            <legend>Datos usuario:</legend>\n"
                        + "            <label for=\"Usuario\">Usuario:</label>\n"
                        + "            <input type=\"text\" id=\"Usuario\" name=\"Usuario\" value=\"" + request.getParameter("Usuario") + "\"><br>\n"
                        + "            <label for=\"Password\">Password:</label>\n"
                        + "            <input type=\"password\" id=\"Password\" name=\"Password\" value=\"" + request.getParameter("Password") + "\">\n"
                        + "        </fieldset>\n"
                        + "        <fieldset>\n"
                        + "            <legend>Aficiones:</legend>\n"
                        + "             Viajes <input type=\"checkbox\" name=\"Aficiones\" value=\"Viajes\"><br>\n"
                        + "             Deporte <input type=\"checkbox\" name=\"Aficiones\" value=\"Deporte\"><br>\n"
                        + "             Lectura <input type=\"checkbox\" name=\"Aficiones\" value=\"Lectura\"><br>\n"
                        + "             Cine <input type=\"checkbox\" name=\"Aficiones\" value=\"Cine\">\n"
                        + "        </fieldset>\n"
                        + "        <input type=\"submit\" name=\"boton\" id=\"boton\" value=\"Enviar\">\n"
                        + "    </form>");

            } else {
                //out.println("No hay error");
                //para la fecha guardarla con el selected="selected" si no selected=""
                //checked ="checked" para marcar las aficiones
                Enumeration<String> enume = request.getParameterNames();
                String elemento;
                String fecha = "";
                String[] meses = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
                while (enume.hasMoreElements()) {
                    elemento = enume.nextElement();
                    if (!elemento.equals("boton")) {
                        if (elemento.equals("dia")) {
                            fecha = request.getParameter(elemento);
                        } else if (elemento.equals("mes")) {
                            fecha = fecha + " de " + meses[Integer.parseInt(request.getParameter(elemento))];
                        } else if (elemento.equals("anio")) {
                            fecha = fecha + " de " + request.getParameter(elemento);
                            out.println("Fecha: " + fecha);
                            out.println("<br>");

                        } else if (elemento.equals("Aficiones")) {
                            String aficiones = "";
                            for (String aficion : request.getParameterValues(elemento)) {
                                aficiones = aficiones + " " + aficion;
                            }
                            out.println(elemento + ": " + aficiones);
                            out.println("<br>");
                        } else {
                            out.println(elemento + ": " + request.getParameter(elemento));
                            out.println("<br>");
                        }
                    }
                }
            }
            
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
