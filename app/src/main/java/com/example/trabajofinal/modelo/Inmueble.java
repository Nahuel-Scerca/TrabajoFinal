package com.example.trabajofinal.modelo;

import java.io.Serializable;

public class Inmueble implements Serializable {

    private int id;
    private String direccion;
    private int ambientes;
    private String tipo;
    private String uso;
    private int superficie;
    private double latitud;
    private double longitud;
    private double precio;
    private int estado;
    private int propietarioId;
    private Propietario duenio;
    private String foto;
    private String estadoNombre;
//    private String archivos;

    public Inmueble() {
    }

    public Inmueble(String direccion , int id) {
        this.direccion = direccion;
        this.id=id;
    }

    public Inmueble(int id, String direccion, int ambientes, String tipo, String uso, int superficie, double latitud, double longitud, double precio, int estado, int propietarioId, Propietario duenio, String foto, String estadoNombre) {
        this.id = id;
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
        this.duenio = duenio;
        this.foto = foto;
        this.estadoNombre = estadoNombre;
    }

    public Inmueble(int id, String direccion, int ambientes, String tipo, String uso, int superficie, double latitud, double longitud, double precio, int estado, int propietarioId, String foto) {
        this.id = id;
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
    }

    public Inmueble(String direccion, int ambientes, String tipo, String uso, int superficie, double latitud, double longitud, double precio, int estado, int propietarioId, String foto) {
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

    }

    public Propietario getDuenio() {
        return duenio;
    }

    public void setDuenio(Propietario duenio) {
        this.duenio = duenio;
    }

    public String getEstadoNombre() {
        return estadoNombre;
    }

    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

/*    public String getArchivos() {
        return archivos;
    }

    public void setArchivos(String archivos) {
        this.archivos = archivos;
    }*/

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

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
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
