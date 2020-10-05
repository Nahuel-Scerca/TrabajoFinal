package com.example.trabajofinal.ui.inquilinoUnico;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trabajofinal.modelo.Inmueble;
import com.example.trabajofinal.modelo.Inquilino;

public class InquilinoUnicoViewModel extends ViewModel {

    private MutableLiveData<Inquilino> inquilino;

    public InquilinoUnicoViewModel() {
        super();
    }

    public LiveData<Inquilino> getInquilino() {
        if (inquilino == null) {
            inquilino = new MutableLiveData<>();
        }
        return inquilino;
    }

    public void cargarInmueble(Bundle bundle) {
        Inquilino inquilino = (Inquilino) bundle.getSerializable("inquilino");


        this.inquilino.setValue(inquilino);
    }
}