package com.example.trabajofinal.ui.inquilinos;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajofinal.R;
import com.example.trabajofinal.modelo.Inmueble;
import com.example.trabajofinal.modelo.Inquilino;
import com.example.trabajofinal.ui.inmuebles.InmuebleViewModel;
import com.example.trabajofinal.ui.inmuebles.ListaAdapter;

import java.util.ArrayList;

public class InquilinoFragment extends Fragment {

    private GridView rvLista;
    private ConstraintLayout item;
    private ArrayList<Inquilino> lista;
    private InquilinoViewModel vm;
    ArrayAdapter<Inquilino> adapter;
    Context context;

    private InquilinoViewModel inquilinoViewModel;
    private RecyclerView dataList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_inquilino, container, false);
        context= root.getContext();
        inicializar(root);
        return root;
    }

    private void inicializar(View view) {
        rvLista = (GridView) view.findViewById(R.id.rvLista);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinoViewModel.class);

        vm.getInquilino().observe(getViewLifecycleOwner(), new Observer<ArrayList>() {
            @Override
            public void onChanged(ArrayList arrayList) {
                adapter= new Adapter(context,R.layout.custom_grid_layout,arrayList,getLayoutInflater());
                rvLista.setAdapter(adapter);

                rvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Bundle bundle = new Bundle();
                        Inquilino inquilino = adapter.getItem(i);
                        Log.d("Salida: ", inquilino.getNombre());
                        bundle.putSerializable("inquilino", inquilino);
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.inquilinoUnicoFragment, bundle);
                    }
                });

            }
        });

        vm.cargarDatos();


    }
}