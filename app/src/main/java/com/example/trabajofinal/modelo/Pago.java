package com.example.trabajofinal.modelo;

import java.io.Serializable;
import java.util.Date;

public class Pago implements Serializable {

    private int id;
    private int numero;
    private int idContrato;
    private Contrato contrato;
    private double importe;
    private String fechaDePago;

    private Pago() {}

    public Pago(int id, int numero, Contrato contrato,  String fechaDePago) {
        this.id = id;
        this.numero = numero;
        this.contrato = contrato;
        this.fechaDePago = fechaDePago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(String fechaDePago) {
        this.fechaDePago = fechaDePago;
    }
}
