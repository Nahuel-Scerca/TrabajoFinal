package com.example.trabajofinal.ui.pagos;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.trabajofinal.R;
import com.example.trabajofinal.modelo.Contrato;
import com.example.trabajofinal.modelo.Inmueble;
import com.example.trabajofinal.modelo.Pago;
import com.example.trabajofinal.ui.contratos.ContratoViewModel;
import com.example.trabajofinal.ui.inmuebles.InmuebleViewModel;
import com.example.trabajofinal.ui.inmuebles.ListaAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PagosFragment extends Fragment {

    private ListView lvLista;
    private ConstraintLayout item;
    private  ArrayList<Contrato> lista;
    private InmuebleViewModel vm;
    private PagosViewModel vmp;
    private List<Pago> arrayListPagos;
    ArrayAdapter<Inmueble> adapter;
    Context context;

    public static PagosFragment newInstance() {
        return new PagosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_pagos, container, false);
        context=root.getContext();
        inicializar(root);
        return root;
    }



    private void inicializar(View view) {
        lvLista = view.findViewById(R.id.lvListaIC);
        vmp= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PagosViewModel.class);
        vmp.getPagos().observe(getViewLifecycleOwner(), new Observer<ArrayList>() {
            @Override
            public void onChanged(ArrayList arrayList) {
                arrayListPagos = arrayList;
                    }
        });
        vmp.obtenerPagos();

        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InmuebleViewModel.class);

        vm.getInmueble().observe(getViewLifecycleOwner(), new Observer<List>() {
            @Override
            public void onChanged(final List list) {
                adapter= new ListaAdapter(context,R.layout.item,list,getLayoutInflater());
                lvLista.setAdapter(adapter);

                lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Bundle bundle = new Bundle();
                        Inmueble inmueble = adapter.getItem(i);
                        Log.d("ApiPago",inmueble.getDireccion()+"");

                        //Lista de Pagos que voy a mandar en el serializable
                        List<Pago> listaDePagos = new ArrayList<>();

                        for (int it = 0; it < arrayListPagos.size(); it++){
                            Pago pago = arrayListPagos.get(it);

                            if(inmueble.getId() == pago.getContrato().getInmueble().getId()){

                                listaDePagos.add(pago);

                            }

                        }
                        bundle.putSerializable("pagos",(Serializable) listaDePagos);
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.pago_unico, bundle);
                    }
                });

            }
        });

        vm.obtenerInmuebles();


    }

}