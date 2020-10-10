package com.example.trabajofinal.ui.contratoUnico;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trabajofinal.R;
import com.example.trabajofinal.modelo.Contrato;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class contrato_unico extends Fragment {

    private Context context;
    private TextView tvContratoId,tvDireccion,tvMonto,tvDesde,tvHasta,tvInquilino;
    private ContratoUnicoViewModel contratoViewModel;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private ContratoUnicoViewModel mViewModel;

    public static contrato_unico newInstance() {
        return new contrato_unico();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_contrato_unico, container, false);
        context=root.getContext();
        inicializar(root);
        return root;
    }
    private void inicializar(View view) {
        tvContratoId = view.findViewById(R.id.tvContratoId);
        tvDireccion = view.findViewById(R.id.tvDireccion);
        tvMonto = view.findViewById(R.id.tvMonto);
        tvDesde = view.findViewById(R.id.tvDesde);
        tvHasta = view.findViewById(R.id.tvHasta);
        tvInquilino = view.findViewById(R.id.tvInquilino);
        contratoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratoUnicoViewModel.class);
        contratoViewModel.getContrato().observe(getActivity(), new Observer<Contrato>() {
            @Override
            public void onChanged(Contrato contrato) {
                tvContratoId.setText(contrato.getId() + "");
                tvDireccion.setText(contrato.getInmueble().getDireccion());
                tvMonto.setText(contrato.getMontoAlquiler()+"");
                tvDesde.setText(contrato.getFechaDesde());
                tvHasta.setText(contrato.getFechaHasta());
                tvInquilino.setText(contrato.getInquilino().getNombre() +" "+ contrato.getInquilino().getApellido());

            }
        });
        contratoViewModel.cargarContrato(getArguments());
    }


}