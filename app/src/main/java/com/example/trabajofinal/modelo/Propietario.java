package com.example.trabajofinal.modelo;

public class Propietario {

    private int idPropietario;
    private String nombre;
    private String apellido;
    private String mail;
    private String password;
    private String dni;
    private String telefono;

    public Propietario(String nombre, String apellido, String mail, String password, String dni, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.password = password;
        this.dni = dni;
        this.telefono = telefono;
    }

    public Propietario() {
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int id) {
        this.idPropietario = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
