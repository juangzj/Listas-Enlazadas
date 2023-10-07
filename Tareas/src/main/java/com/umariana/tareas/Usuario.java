package com.umariana.tareas;

/**
 *
 * @author Juan Goyes
 */
public class Usuario {

    private String nomUsuario;
    private String cedula;
    private String contraseña;

    /**
     * constructor vacio
     */
    public Usuario() {
    }

    /**
     * constructor con atributos
     *
     * @param nomUsuario
     * @param cedula
     * @param contraseña
     */
    public Usuario(String nomUsuario, String cedula, String contraseña) {
        this.cedula = cedula;
        this.nomUsuario = nomUsuario;
        this.contraseña = contraseña;
    }

    /**
     * metodos getters y setters
     *
     * @return
     */
    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
