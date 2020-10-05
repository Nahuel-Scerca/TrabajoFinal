package com.example.trabajofinal.ui.inquilinos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trabajofinal.R;
import com.example.trabajofinal.modelo.Inmueble;
import com.example.trabajofinal.modelo.Inquilino;

import java.util.ArrayList;

public class InquilinoViewModel extends ViewModel {

    private MutableLiveData<ArrayList> inquilino;
    private ArrayList<Inquilino> lista = new ArrayList<>();

    public LiveData<ArrayList> getInquilino() {
        if(inquilino== null){
            inquilino= new MutableLiveData<>();
        }
        return inquilino;
    }



    public void cargarDatos(){
        lista.add(new Inquilino("403154842", "Nahuel", "Scerca", "2664243132"));
        lista.add(new Inquilino("23123213", "Hernan", "Gomez", "266448485"));
        lista.add(new Inquilino("33211332", "Flavio", "Aguilar", "26648798"));
        lista.add(new Inquilino("1235654567", "Emanuel", "Ferreyra", "2664313131"));

        inquilino.setValue(lista);
    }
}