package com.example.trabajofinal.ui.contratos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trabajofinal.R;
import com.example.trabajofinal.modelo.Contrato;
import com.example.trabajofinal.modelo.Inmueble;
import com.example.trabajofinal.modelo.Inquilino;

import java.util.ArrayList;
import java.util.Date;

public class ContratoViewModel extends ViewModel {

    private MutableLiveData<ArrayList> contrato;
    private ArrayList<Contrato> lista = new ArrayList<>();

    public LiveData<ArrayList> getContrato() {
        if(contrato== null){
            contrato= new MutableLiveData<>();
        }
        return contrato;
    }



    public void cargarDatos(){
        lista.add(new Contrato(1, null,null, 15000, new Inquilino(), new Inmueble("Jujuy 929",1)));
        lista.add(new Contrato(2,null,null, 11000, new Inquilino(), new Inmueble("9 de agosto 929",2)));
        lista.add(new Contrato(3, null,null, 14000, new Inquilino(), new Inmueble("Narciso 99",3)));
        lista.add(new Contrato(4,null,null, 20000, new Inquilino(), new Inmueble("Junin 229",4)));
        contrato.setValue(lista);
    }


}