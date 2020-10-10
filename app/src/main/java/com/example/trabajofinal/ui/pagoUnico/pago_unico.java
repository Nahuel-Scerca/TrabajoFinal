package com.example.trabajofinal.ui.pagoUnico;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.trabajofinal.R;
import com.example.trabajofinal.modelo.Contrato;
import com.example.trabajofinal.modelo.Inmueble;
import com.example.trabajofinal.modelo.Pago;
import com.example.trabajofinal.ui.contratoUnico.ContratoUnicoViewModel;
import com.example.trabajofinal.ui.inmuebles.ListaAdapter;

import java.util.ArrayList;

public class pago_unico extends Fragment {

    private ListView lvLista;
    ArrayAdapter<Pago> adapter;
    private Context context;
    private TextView tvMonto,tvInquilino,tvConcepto;
    private PagoUnicoViewModel pagoViewModel;

    public static pago_unico newInstance() {
        return new pago_unico();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_pago_unico, container, false);
        context=root.getContext();
        inicializar(root);
        return root;
    }

    private void inicializar(View view) {
        lvLista = view.findViewById(R.id.lvListaContratos);
        tvMonto = view.findViewById(R.id.tvMonto);
        tvInquilino = view.findViewById(R.id.tvInquilino);
        tvConcepto = view.findViewById(R.id.tvConcepto);

        pagoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PagoUnicoViewModel.class);
        pagoViewModel.getPagos().observe(getActivity(), new Observer<ArrayList>() {
            @Override
            public void onChanged(ArrayList arrayList) {

                adapter= new ListAdapter(context,R.layout.item_pagos,arrayList,getLayoutInflater());

                lvLista.setAdapter(adapter);


            }
        });
        pagoViewModel.cargarContrato(getArguments());
    }
}