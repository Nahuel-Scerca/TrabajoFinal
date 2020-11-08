package com.example.trabajofinal.ui.pagoUnico;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.trabajofinal.R;
import com.example.trabajofinal.modelo.Pago;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Pago> {

    private Context context;
    private List<Pago> lista;
    private LayoutInflater li;

    public ListAdapter(@NonNull Context context, int resource, @NonNull List<Pago> objects , LayoutInflater li) {

        super(context, resource, objects);
        this.context = context;
        this.lista= objects;
        this.li=li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView= convertView;
        if(itemView==null){
            itemView=li.inflate(R.layout.item_pagos,parent,false);

        }
        Pago pago= lista.get(position);

        TextView numContrato = itemView.findViewById(R.id.tvNumeroContrato);
        numContrato.setText(pago.getNumero()+"");

        TextView monto= itemView.findViewById(R.id.tvMonto);
        monto.setText(pago.getContrato().getPrecioMensual()+"");

        TextView inquilino = itemView.findViewById(R.id.tvInquilino);
        inquilino.setText("El Inquilino/a "+pago.getContrato().getInquilino().getNombre()+" "+pago.getContrato().getInquilino().getApellido());

        TextView concepto = itemView.findViewById(R.id.tvConcepto);
        concepto.setText("Pago mensual del Inmueble "+pago.getContrato().getInmueble().getDireccion()+"");


        return itemView;

    }
}
