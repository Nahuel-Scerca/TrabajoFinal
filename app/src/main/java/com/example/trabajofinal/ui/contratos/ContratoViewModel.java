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
        lista.add(new Contrato(1, "30/12/2010","31/12/2020", 15000, new Inquilino(1,"403154842", "Nahuel", "Scerca","nahuel@gmail.com", "2664243132"), new Inmueble("9 de julio 1221",1)));
        lista.add(new Contrato(2,"20/11/2021","20/11/2012", 11000, new Inquilino(2,"23123213", "Hernan", "Gomez","hernan@gmail.com", "266448485"), new Inmueble("jujuy 9",2)));
        lista.add(new Contrato(3, "11/08/2020","10/06/2024", 14000, new Inquilino(3,"33211332", "Flavio", "Aguilar","fla@gmail.com", "26648798"), new Inmueble("balcarce 1212",3)));
        lista.add(new Contrato(4,"15/02/2019","14/10/2020", 20000, new Inquilino(4,"1235654567", "Emanuel", "Ferreyra","ema@gmail.com", "2664313131"), new Inmueble("yapeyu 123",4)));
        contrato.setValue(lista);
    }


}