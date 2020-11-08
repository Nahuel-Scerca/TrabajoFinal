package com.example.trabajofinal.modelo;

import java.io.Serializable;
import java.util.Date;

public class Contrato implements Serializable {

    private int id;
    private Date fechaDesde;
    private Date fechaHasta;
    private double precioMensual;
    private int inquilinoId;
    private int inmuebleId;
    private Inquilino inquilino;
    private Inmueble inmueble;

    public Contrato(int id, Date fechaDesde, Date fechaHasta, double precioMensual, int inquilinoId, int inmuebleId, Inquilino inquilino, Inmueble inmueble) {
        this.id = id;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.precioMensual = precioMensual;
        this.inquilinoId = inquilinoId;
        this.inmuebleId = inmuebleId;
        this.inquilino = inquilino;
        this.inmueble = inmueble;
    }

    public Contrato(int id, Date fechaDesde, Date fechaHasta, double precioMensual, Inquilino inquilino, Inmueble inmueble) {
        this.id = id;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.precioMensual = precioMensual;
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

    public double getPrecioMensual() {
        return precioMensual;
    }

    public void setPrecioMensual(double precioMensual) {
        this.precioMensual = precioMensual;
    }

    public int getInquilinoId() {
        return inquilinoId;
    }

    public void setInquilinoId(int inquilinoId) {
        this.inquilinoId = inquilinoId;
    }

    public int getInmuebleId() {
        return inmuebleId;
    }

    public void setInmuebleId(int inmuebleId) {
        this.inmuebleId = inmuebleId;
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
