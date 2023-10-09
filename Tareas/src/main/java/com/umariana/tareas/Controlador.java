package com.umariana.tareas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Juan Goyes , German Andrade
 *
 * clase que contiene los metodos para las funcionalidades de la pagina web
 */
public class Controlador {

    /**
     * Metodo para la verificacion de usuarios
     *
     * @param usuarioR
     * @param contraseniaR
     * @param misUsuario
     * @return
     */
    public boolean verificacionUsuarioRegistrado(String usuarioR, String contraseniaR, ArrayList<Usuario> misUsuario) {
        boolean comprobacion = false;

        for (Usuario usuarioC : misUsuario) {
            if (usuarioC.getNomUsuario().equals(usuarioR)) {
                if (usuarioC.getContrasenia().equals(contraseniaR)) {
                    comprobacion = true;
                    // System.out.println("El usuario ingresó al sistema");
                } else {
                    //System.out.println("Contraseña incorrecta");
                }
            } else {
                //System.out.println("El usuario no esta registrado");
                break;
            }
        }

        return comprobacion;
    }

    /**
     * Metodo para guradar los usurios registrados en una hoja de texto
     *
     * @param misUsuarios
     * @throws FileNotFoundException
     */
    public void guardarRegistroUsuarios(ArrayList<Usuario> misUsuarios) throws FileNotFoundException {
        // Obtiene el directorio actual del proyecto
        String basePath = System.getProperty("user.dir");
        //concatenamos el directorio base con la ubicacion del archivo a crear 
        String filePath = basePath + File.separator + "usuariosRegistrados.txt";
        //creacion de la hoja de texto 
        File usuariosRegistrados = new File(filePath);

        try ( //pluma para ecribir en el archivo
                PrintWriter pluma = new PrintWriter(usuariosRegistrados)) {
            for (Usuario usuariosR : misUsuarios) {
                pluma.println(usuariosR.getNomUsuario() + "," + usuariosR.getCedula() + "," + usuariosR.getContrasenia());
            }
            pluma.close();

        }

        //Mirar la ubicacion de el registro de los usuarios
        String ubicacionArchivo = usuariosRegistrados.getAbsolutePath();
        System.out.println("=================================================");
        System.out.println("la ubicacion del archivo es " + ubicacionArchivo);
        System.out.println("=================================================");
        //System.out.println("==========================");
        //System.out.println(basePath);
        //System.out.println("==========================");
    }

    public void cargarUsuarios(ArrayList<Usuario> misUsuarios) throws FileNotFoundException, IOException {

    //Obtener el directorio actual del proyecto
    String basePath = System.getProperty("user.dir");
    //conectamos el directorio base con el archivo que vamos a crear
    String filePath = basePath + File.separator + "usuariosRegistrados.txt";
    //creacion de la hoja de texto
    File usuariosRegistrados = new File(filePath);
    
    FileReader fr = new FileReader(usuariosRegistrados);
    BufferedReader lector = new BufferedReader(fr); 
    
    String linea = lector.readLine();
    
    while(linea!=null){
    
        String[] datos =linea.split(",");
        String usuarioR = datos[0];
        String cedulaR = datos[1];
        String contraseniaR = datos[2];
        
        //llamado al metodo constructor para crear un nuevo usuario
        Usuario usuarioRegistrado = new Usuario();
        
        //añadimos los atributos del usuario registrado 
        usuarioRegistrado.setNomUsuario(usuarioR);
        usuarioRegistrado.setCedula(cedulaR);
        usuarioRegistrado.setContrasenia(contraseniaR);
        
        //añadimos usuario al arraylist
        misUsuarios.add(usuarioRegistrado);
        
        linea =lector.readLine();
        
    }
    fr.close();
    lector.close();
    

    }

}
