package com.example.trabajofinal.modelo;

import java.io.Serializable;

public class Inmueble implements Serializable {

    private int id;
    private String direccion;
    private int ambientes;
    private String tipo;
    private String uso;
    private double superficie;
    private String latitud;
    private String longitud;
    private double precio;
    private int estado;
    private int propietarioId;
    private int foto;
    private String archivos;

    public Inmueble() {
    }

    public Inmueble(String direccion, int ambientes, String tipo, String uso, double superficie, String latitud, String longitud, double precio, int estado, int propietarioId, int foto, String archivos) {
        this.direccion = direccion;
        this.ambientes = ambientes;
        this.tipo = tipo;
        this.uso = uso;
        this.superficie = superficie;
        this.latitud = latitud;
        this.longitud = longitud;
        this.precio = precio;
        this.estado = estado;
        this.propietarioId = propietarioId;
        this.foto = foto;
        this.archivos = archivos;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getArchivos() {
        return archivos;
    }

    public void setArchivos(String archivos) {
        this.archivos = archivos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(int ambientes) {
        this.ambientes = ambientes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(int propietarioId) {
        this.propietarioId = propietarioId;
    }
}
