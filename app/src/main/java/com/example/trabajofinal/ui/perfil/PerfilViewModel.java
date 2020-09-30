package com.example.trabajofinal.ui.perfil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trabajofinal.modelo.Propietario;

public class PerfilViewModel extends ViewModel {

    private MutableLiveData<Propietario> propietario;

    public LiveData<Propietario> getPropietario() {
        if(propietario== null){
            propietario= new MutableLiveData<>();
        }
        return propietario;
    }

    public void recuperarPropietario(){

        Propietario p = new Propietario();
        p.setNombre("Nahuel");
        p.setApellido("Scerca");
        p.setMail("nahuelsherca@gmail.com");
        p.setPassword("123");
        p.setDni("40318407");
        p.setTelefono("2664243132");

        propietario.setValue(p);
    }
}