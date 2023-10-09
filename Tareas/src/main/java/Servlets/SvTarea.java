package Servlets;

import com.umariana.tareas.Controlador;
import com.umariana.tareas.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

    //arraylist donde se guradara a todos los usuarios
    ArrayList<Usuario> misUsuarios = new ArrayList<>();
  
    //llamdo al controlado
    Controlador controlador = new Controlador();
    
     
  
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
        
        //cargar los usuarios
        controlador.cargarUsuarios(misUsuarios);
        //=============================================================================================
        //mostrar los usuairos
        for(Usuario a : misUsuarios){
            System.out.println("USUARIO: "+ a.getNomUsuario()+ " Cedula: " + a.getCedula() + " Contraseña: " + a.getContrasenia());
        }
        //=============================================================================================

        //obtener los daros para inicio de sesion de un usuario registrado
        String usuarioR = request.getParameter("usuarioR");
        String contraseniaR = request.getParameter("contraseniaR");

        //comprobacion de conexion de datos del usuario registrado
        System.out.println("el usuario: " + usuarioR + " contraseña: " + contraseniaR + " USUARIO REGISTRADO");

        //llamado al metodo verifiacionUsuarioRegistrado para la verifiacion del usuario
        boolean verifiacionUsuarioR = false;
        verifiacionUsuarioR = controlador.verificacionUsuarioRegistrado(usuarioR, contraseniaR, misUsuarios);
        if (verifiacionUsuarioR == true) {
            request.setAttribute("misUsuarios", misUsuarios);
            request.getRequestDispatcher("TareasApp.jsp").forward(request, response);
            System.out.println("el usuario ingreso a la app");

        } else {
            System.out.println("no entroooo");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        System.out.println("al comparacion esssss: " + verifiacionUsuarioR);

        //obtener los parametros para el registro de un nuevo usuario
        String usuario = request.getParameter("usuario");
        String cedula = request.getParameter("cedula");
        String contrasenia = request.getParameter("contrasenia");

        //prueba de conexion de datos
        System.out.println("Nombre: " + usuario);
        System.out.println("Cedula: " + cedula);
        System.out.println("Contraseña: " + contrasenia);

        //llamado al metodo cosntructor de usuario
        Usuario nuevoUsuario = new Usuario(usuario, cedula, contrasenia);
        System.out.println("se creo un nuevo usuario: " + usuario + " cc:" + cedula + " contraseña: "
                + contrasenia);

        //insertar el nuevo usuario al ArrayList
        misUsuarios.add(nuevoUsuario);

        //escribir el contenido del ArrayList de los usuarios en una hoja de texto
        controlador.guardarRegistroUsuarios(misUsuarios);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
