package com.umariana.tareas;

import java.util.ArrayList;

/**
 *
 * @author Juan Goyes , German Andrade
 *
 * clase que contiene los metodos para las funcionalidades de la pagina web
 */
public class Controlador {

    public boolean verificacionUsuarioRegistrado(String usuarioR, String contraseniaR, ArrayList<Usuario> misUsuario) {
        boolean comprobacion = false;
        if (usuarioR != null && contraseniaR != null) {

            for (Usuario usuarioC : misUsuario) {
                if (usuarioC.getNomUsuario().equals(usuarioR)) {
                    if (usuarioC.getContraseña().equals(contraseniaR)) {
                        comprobacion = true;
                        System.out.println("El usuario ingresó al sistema");
                    } else {
                        System.out.println("Contraseña incorrecta");
                    }
                } else {
                    System.out.println("El usuario no esta registrado");
                    break;
                }
            }

        }

        return comprobacion;
    }
}
