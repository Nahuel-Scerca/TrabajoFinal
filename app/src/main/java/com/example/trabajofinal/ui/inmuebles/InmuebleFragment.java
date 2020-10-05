package com.example.trabajofinal.ui.inmuebles;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.trabajofinal.R;
import com.example.trabajofinal.modelo.Inmueble;
import com.example.trabajofinal.ui.inmuebleUnico.InmuebleUnicoFragment;

import java.util.ArrayList;

public class InmuebleFragment extends Fragment {

    private ListView lvLista;
    private ConstraintLayout item;
    private  ArrayList<Inmueble> lista;
    private InmuebleViewModel vm;
    ArrayAdapter<Inmueble> adapter;
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
                 adapter= new ListaAdapter(context,R.layout.item,arrayList,getLayoutInflater());
                lvLista.setAdapter(adapter);

                lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Bundle bundle = new Bundle();
                        Inmueble inmueble = adapter.getItem(i);
                        Log.d("Salida: ", inmueble.getDireccion());
                        bundle.putSerializable("inmueble", inmueble);
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.inmuebleFragment, bundle);
                    }
                });

            }
        });

        vm.cargarDatos();


    }

}