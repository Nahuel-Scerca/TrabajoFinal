package com.example.trabajofinal.ui.contratos;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabajofinal.R;
import com.example.trabajofinal.modelo.Contrato;
import com.example.trabajofinal.modelo.Inmueble;
import com.example.trabajofinal.ui.inmuebles.InmuebleViewModel;
import com.example.trabajofinal.ui.inmuebles.ListaAdapter;

import java.util.ArrayList;

public class ContratoFragment extends Fragment {

    private ListView lvLista;
    private ConstraintLayout item;
    private  ArrayList<Contrato> lista;
    private InmuebleViewModel vm;
    private ContratoViewModel vmc;
    private ArrayList<Contrato> arrayListContrato;
    ArrayAdapter<Inmueble> adapter;
    Context context;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_contratos, container, false);
        context=root.getContext();
        inicializar(root);
        return root;

    }



    private void inicializar(View view) {
        lvLista = view.findViewById(R.id.lvLista);
        vmc= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratoViewModel.class);
        vmc.getContrato().observe(getViewLifecycleOwner(), new Observer<ArrayList>() {
            @Override
            public void onChanged(ArrayList arrayList) {
                arrayListContrato = arrayList;
                Log.d("Salida", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA  "+arrayListContrato.size()+"");
            }
        });
        vmc.cargarDatos();

        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InmuebleViewModel.class);

        vm.getInmueble().observe(getViewLifecycleOwner(), new Observer<ArrayList>() {
            @Override
            public void onChanged(final ArrayList arrayList) {
                adapter= new ListaAdapter(context,R.layout.item,arrayList,getLayoutInflater());
                lvLista.setAdapter(adapter);

                lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Bundle bundle = new Bundle();
                        Inmueble inmueble = adapter.getItem(i);
                        Log.d("Salida", "eSTE ES EL ID INMUEBELE"+inmueble.getId()+"");

                        for (int it = 0; it < 4; it++){
                            Contrato contrato = arrayListContrato.get(it);
                            if(inmueble.getId() == contrato.getIdInmueble()){
                                bundle.putSerializable("contrato", contrato);
                            }

                        }


                        Contrato contrato = arrayListContrato.get(1);
                        Log.d("Salida", "ESTE ES EL ID CONTRATO"+contrato.getId()+"");
                        bundle.putSerializable("contrato", contrato);
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.contrato_unico, bundle);
                    }
                });

            }
        });

        vm.cargarDatos();


    }

}