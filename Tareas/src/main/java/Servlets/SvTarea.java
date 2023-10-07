package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Goyes
 */

@WebServlet(name = "SvTarea", urlPatterns = {"/SvTarea"})
public class SvTarea extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //obtener los parametros para el registro de un nuevo usuario
        String usuario = request.getParameter("usuario");
        String cedula = request.getParameter("cedula");
        String contrasenia = request.getParameter("contrasenia");
        
        System.out.println("Nombre: " + usuario);
        System.out.println("Cedula: " + cedula);
        System.out.println("Contraseña: " + contrasenia);
        
        request.getRequestDispatcher("TareasApp.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
