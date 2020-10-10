package com.example.trabajofinal.modelo;

import java.io.Serializable;
import java.util.Date;

public class Contrato implements Serializable {

    private int id;
    private String fechaDesde;
    private String fechaHasta;
    private double montoAlquiler;
    private int idInquilino;
    private int idInmueble;
    private Inquilino inquilino;
    private Inmueble inmueble;




    public Contrato(int id, String fechaDesde, String fechaHasta, double montoAlquiler,Inquilino inquilino,Inmueble inmueble) {
        this.id = id;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.montoAlquiler = montoAlquiler;
        this.inquilino = inquilino;
        this.inmueble = inmueble;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public double getMontoAlquiler() {
        return montoAlquiler;
    }

    public void setMontoAlquiler(double montoAlquiler) {
        this.montoAlquiler = montoAlquiler;
    }

    public int getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }
}
