package com.example.trabajofinal.ui.inquilinoUnico;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    private TextView tvnombre,tvTelefono,tvEmail,tvDni,tvInmueble;
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
        tvTelefono = view.findViewById(R.id.tvTelefono);
        tvDni = view.findViewById(R.id.tvDni);
        tvInmueble = view.findViewById(R.id.tvInmueble);
        ivImagenInquilino = view.findViewById(R.id.ivImagenInquilino);

        ivImagenInquilino = view.findViewById(R.id.ivImagenInquilino);
        ivImagenInquilino.setImageResource(R.drawable.inquilinoview);


        inquilinoUnicoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinoUnicoViewModel.class);
        inquilinoUnicoViewModel.getInquilino().observe(getActivity(), new Observer<Inquilino>() {
            @Override
            public void onChanged(Inquilino inquilino) {

                tvnombre.setText(inquilino.getNombre()+" "+ inquilino.getApellido());
                tvTelefono.setText("Telefono: "+inquilino.getTelefono());
                tvEmail.setText("E-mail: "+inquilino.getEmail());
                tvDni.setText("Dni: "+inquilino.getDni());
                tvInmueble.setText("Direccion: "+inquilino.getInmueble().getDireccion());


                Resources res = getResources();
                Bitmap src = BitmapFactory.decodeResource(res,R.drawable.inquilinoview );
                RoundedBitmapDrawable dr = RoundedBitmapDrawableFactory.create(res, src);
                dr.setCornerRadius(100.0f);
                ivImagenInquilino.setImageDrawable(dr);

            }
        });
        inquilinoUnicoViewModel.cargarInmueble(getArguments());
    }

}