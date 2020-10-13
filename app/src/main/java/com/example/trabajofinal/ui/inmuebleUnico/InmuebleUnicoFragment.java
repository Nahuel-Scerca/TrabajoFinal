package com.example.trabajofinal.ui.inmuebleUnico;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trabajofinal.R;
import com.example.trabajofinal.modelo.Inmueble;

public class InmuebleUnicoFragment extends Fragment {

    private InmuebleUnicoViewModel inmuebleViewModel;
    private EditText etId,etDireccion,etTipo,etAmbientes,etPrecio,etUso;
    private CheckBox cbEstado;
    private TextView tvNombreInmueble;
    private ImageView ivImagenInmueble;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_inmueble_unico, container, false);
        inicializar(root);
        return root;
    }

    private void inicializar(View view) {
        etId = view.findViewById(R.id.etId);
        etId.setEnabled(false);
        tvNombreInmueble= view.findViewById(R.id.tvNombreInmueble);
        tvNombreInmueble.setEnabled(false);
        etDireccion = view.findViewById(R.id.etDireccion);
        etDireccion.setEnabled(false);
        etTipo = view.findViewById(R.id.etTipo);
        etTipo.setEnabled(false);
        etUso = view.findViewById(R.id.etUso);
        etUso.setEnabled(false);
        etAmbientes = view.findViewById(R.id.etAmbientes);
        etAmbientes.setEnabled(false);
        etPrecio = view.findViewById(R.id.etPrecio);
        etPrecio.setEnabled(false);

        cbEstado = view.findViewById(R.id.cbEstado);
        ivImagenInmueble = view.findViewById(R.id.ivImagenInquilino);
        inmuebleViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InmuebleUnicoViewModel.class);
        inmuebleViewModel.getInmueble().observe(getActivity(), new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble inmueble) {
                tvNombreInmueble.setText(inmueble.getDireccion());
                etId.setText(inmueble.getId() + "");
                etDireccion.setText(inmueble.getDireccion());
                etTipo.setText(inmueble.getTipo());
                etUso.setText(inmueble.getUso());
                etAmbientes.setText(inmueble.getAmbientes() + "");
                etPrecio.setText("$" + inmueble.getPrecio());

                if(inmueble.getEstado() ==1){
                    cbEstado.setChecked(true);
                }

                ivImagenInmueble.setImageResource(inmueble.getFoto());
            }
        });
        inmuebleViewModel.cargarInmueble(getArguments());
    }

}