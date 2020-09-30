package com.example.trabajofinal.ui.inmuebles;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.trabajofinal.R;
import com.example.trabajofinal.modelo.Inmueble;
import com.example.trabajofinal.ui.perfil.PerfilViewModel;

import java.util.ArrayList;

public class InmuebleFragment extends Fragment {

    private ListView lvLista;
    private  ArrayList<Inmueble> lista;
    private InmuebleViewModel vm;
    Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_inmueble, container, false);
        context=root.getContext();
        inicializar(root);
        return root;
    }

    private void inicializar(View view) {
        lvLista = view.findViewById(R.id.lvLista);

        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InmuebleViewModel.class);

        vm.getInmueble().observe(getViewLifecycleOwner(), new Observer<ArrayList>() {
            @Override
            public void onChanged(ArrayList arrayList) {
                ArrayAdapter<Inmueble> adapter= new ListaAdapter(context,R.layout.item,arrayList,getLayoutInflater());
                lvLista.setAdapter(adapter);
            }
        });

        vm.cargarDatos();


    }

}