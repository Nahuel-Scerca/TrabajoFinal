package com.example.trabajofinal.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.trabajofinal.R;
import com.example.trabajofinal.modelo.Propietario;

public class PerfilFragment extends Fragment {

    private EditText etNombre,etApellido,etPassword,etMail, etDni, etTelefono;
    private Button btGuardar,btEditar;

    private PerfilViewModel vm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_perfil, container, false);

        inicializar(root);
        return root;
    }

    private void inicializar(View view){
        etApellido= view.findViewById(R.id.etApellido);
        etNombre= view.findViewById(R.id.etNombre);
        etPassword= view.findViewById(R.id.etPassword);
        etMail= view.findViewById(R.id.etMail);
        etDni= view.findViewById(R.id.etDni);
        etTelefono= view.findViewById(R.id.etTelefono);
        btGuardar = view.findViewById(R.id.btGuardar);
        btEditar= view.findViewById(R.id.btEditar);

        etApellido.setEnabled(false);
        etNombre.setEnabled(false);
        etPassword.setEnabled(false);
        etMail.setEnabled(false);
        etDni.setEnabled(false);
        etTelefono.setEnabled(false);


        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PerfilViewModel.class);

        vm.getPropietario().observe(getViewLifecycleOwner(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                etNombre.setText(propietario.getNombre());
                etApellido.setText(propietario.getApellido());
                etPassword.setText(propietario.getPassword());
                etMail.setText(propietario.getMail());
                etDni.setText(propietario.getDni());
                etTelefono.setText(propietario.getTelefono());

            }
        });
        vm.recuperarPropietario();

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etApellido.setEnabled(true);
                etNombre.setEnabled(true);
                etPassword.setEnabled(true);
                etMail.setEnabled(true);
                etDni.setEnabled(true);
                etTelefono.setEnabled(true);
                btEditar.setVisibility(View.GONE);
                btGuardar.setVisibility(View.VISIBLE);
            }
        });

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Propietario p = new Propietario();
                p.setNombre(etNombre.getText().toString());
                p.setApellido(etApellido.getText().toString());
                p.setApellido(etPassword.getText().toString());
                p.setApellido(etMail.getText().toString());
                p.setApellido(etDni.getText().toString());
                p.setApellido(etTelefono.getText().toString());

                etApellido.setEnabled(false);
                etNombre.setEnabled(false);
                etPassword.setEnabled(false);
                etMail.setEnabled(false);
                etDni.setEnabled(false);
                etTelefono.setEnabled(false);

                btEditar.setVisibility(View.VISIBLE);
                btGuardar.setVisibility(View.GONE);
            }
        });
    }
}