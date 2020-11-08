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
    private TextView tvContratoId,tvDireccion,tvMonto,tvDesde,tvHasta,tvInquilino,tvTexto;
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
        tvTexto= view.findViewById(R.id.tvTexto);
        contratoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratoUnicoViewModel.class);
        contratoViewModel.getContrato().observe(getActivity(), new Observer<Contrato>() {
            @Override
            public void onChanged(Contrato contrato) {
                tvContratoId.setText("Nº"+contrato.getId() + "");
                tvDireccion.setText("Ubicado en la calle "+contrato.getInmueble().getDireccion());
                tvMonto.setText("Mensualmente se abonaran: "+contrato.getPrecioMensual()+"");
               /* tvDesde.setText(contrato.getFechaDesde());
                tvHasta.setText(contrato.getFechaHasta());*/
                tvInquilino.setText("El Sr/a "+contrato.getInquilino().getNombre() +" "+ contrato.getInquilino().getApellido());

                tvTexto.setText("REUNIDOS por el motivo de Alquiler del Inmueble ubicado en San Luis calle: "+contrato.getInmueble().getDireccion()+" , el cual sera ocupado por el Inquilino "+contrato.getInquilino().getNombre() +" "+ contrato.getInquilino().getApellido()+" a un Monto mensual de "+contrato.getPrecioMensual()+" Que por VALIDADO el acuerdo de ambas partes el dia de la fecha "+contrato.getFechaDesde()+". Sin mas motivo alguno . ");
            }
        });
        contratoViewModel.cargarContrato(getArguments());
    }


}