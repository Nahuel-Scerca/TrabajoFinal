package com.example.trabajofinal;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trabajofinal.modelo.Contrato;
import com.example.trabajofinal.modelo.Inmueble;

public class ContratoUnicoViewModel extends ViewModel {

    private MutableLiveData<Contrato> contrato;

    public ContratoUnicoViewModel() {
        super();
    }

    public LiveData<Contrato> getContrato() {
        if (contrato == null) {
            contrato = new MutableLiveData<>();
        }
        return contrato;
    }

    public void cargarContrato(Bundle bundle) {
        Contrato contrato = (Contrato) bundle.get("contrato");


        this.contrato.setValue(contrato);
    }
}