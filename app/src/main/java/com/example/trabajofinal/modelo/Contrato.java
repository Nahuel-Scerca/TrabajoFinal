package com.example.trabajofinal.modelo;

import java.io.Serializable;
import java.util.Date;

public class Contrato implements Serializable {

    private int id;
    private Date fechaDesde;
    private Date fechaHasta;
    private double montoAlquiler;
    private int idInquilino;
    private int idInmueble;
    private Inquilino inquilino;
    private Inmueble inmueble;

    public Contrato(int i, Date date, Date date1, int i1, Inquilino inquilino, Inmueble inmueble) {}

    public Contrato(int id, Date fechaDesde, Date fechaHasta, double montoAlquiler,Inquilino inquilino,Inmueble inmueble) {
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

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
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
