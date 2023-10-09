package com.umariana.tareas;

/**
 *
 * @author Juan Goyes
 */
public class Usuario {

    private String nomUsuario;
    private String cedula;
    private String contrasenia;

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
     * @param contrasenia
     */
    public Usuario(String nomUsuario, String cedula, String contrasenia) {
        this.cedula = cedula;
        this.nomUsuario = nomUsuario;
        this.contrasenia = contrasenia;
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
