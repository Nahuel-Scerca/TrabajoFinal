package com.example.trabajofinal.modelo;

import java.io.Serializable;

public class Inquilino implements Serializable {

    private int id;
    private String Dni;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String nombreGarante;
    private String telefonoGarante;
    private String DniGarante;

    public Inquilino() {}

    public Inquilino(String dni, String nombre, String apellido, String telefono) {
        Dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public Inquilino(String dni, String nombre, String apellido, String email, String telefono, String nombreGarante, String telefonoGarante, String dniGarante) {
        Dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.nombreGarante = nombreGarante;
        this.telefonoGarante = telefonoGarante;
        DniGarante = dniGarante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreGarante() {
        return nombreGarante;
    }

    public void setNombreGarante(String nombreGarante) {
        this.nombreGarante = nombreGarante;
    }

    public String getTelefonoGarante() {
        return telefonoGarante;
    }

    public void setTelefonoGarante(String telefonoGarante) {
        this.telefonoGarante = telefonoGarante;
    }

    public String getDniGarante() {
        return DniGarante;
    }

    public void setDniGarante(String dniGarante) {
        DniGarante = dniGarante;
    }
}
