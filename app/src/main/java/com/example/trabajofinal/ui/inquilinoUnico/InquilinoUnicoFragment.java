package com.example.trabajofinal.ui.inquilinoUnico;

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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trabajofinal.R;
import com.example.trabajofinal.modelo.Inquilino;

public class InquilinoUnicoFragment extends Fragment {

    private InquilinoUnicoViewModel inquilinoUnicoViewModel;
    private TextView tvnombre,tvApellido,tvTelefono,tvEmail;
    private ImageView ivImagenInquilino;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_inquilino_unico, container, false);
        inicializar(root);
        return root;
    }

    private void inicializar(View view) {
        tvnombre = view.findViewById(R.id.tvNombre);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvApellido = view.findViewById(R.id.tvApellido);
        tvTelefono = view.findViewById(R.id.tvTelefono);
        ivImagenInquilino = view.findViewById(R.id.ivImagenInquilino);
        ivImagenInquilino.setImageResource(R.drawable.inquilinoview);


        inquilinoUnicoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinoUnicoViewModel.class);
        inquilinoUnicoViewModel.getInquilino().observe(getActivity(), new Observer<Inquilino>() {
            @Override
            public void onChanged(Inquilino inquilino) {
                tvnombre.setText(inquilino.getNombre());
                tvApellido.setText(inquilino.getApellido());
                tvTelefono.setText(inquilino.getTelefono());
                tvEmail.setText(inquilino.getEmail());

            }
        });
        inquilinoUnicoViewModel.cargarInmueble(getArguments());
    }

}