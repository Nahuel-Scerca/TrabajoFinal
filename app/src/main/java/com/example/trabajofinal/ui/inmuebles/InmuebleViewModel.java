package com.example.trabajofinal.ui.inmuebles;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trabajofinal.R;
import com.example.trabajofinal.modelo.Inmueble;
import com.example.trabajofinal.modelo.Propietario;

import java.util.ArrayList;

public class InmuebleViewModel extends ViewModel {

    private MutableLiveData<ArrayList> inmueble;
    private ArrayList<Inmueble> lista = new ArrayList<>();

    public LiveData<ArrayList> getInmueble() {
        if(inmueble== null){
            inmueble= new MutableLiveData<>();
        }
        return inmueble;
    }



    public void cargarDatos(){
        lista.add(new Inmueble("9 de julio 1221", 2,"Departamento", "Domestico", 11111, "123123","2313123",100000, 1, 1, R.drawable.casa1, "String archivos"));
        lista.add(new Inmueble("jujuy 9", 2,"Departamento", "Domestico", 11111, "123123","2313123",100000, 1, 1, R.drawable.casa1, "String archivos"));
        lista.add(new Inmueble("balcarce 1212", 2,"Departamento", "Domestico", 11111, "123123","2313123",100000, 1, 1, R.drawable.casa2, "String archivos"));
        lista.add(new Inmueble("yapeyu 123", 2,"Departamento", "Domestico", 11111, "123123","2313123",100000, 1, 1, R.drawable.casa3, "String archivos"));

        inmueble.setValue(lista);
    }


}