package com.example.trabajofinal.ui.inmuebleUnico;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trabajofinal.modelo.Inmueble;

public class InmuebleUnicoViewModel extends ViewModel {
    private MutableLiveData<Inmueble> inmueble;

    public InmuebleUnicoViewModel() {
        super();
    }
    public LiveData<Inmueble> getInmueble() {
        if (inmueble == null) {
            inmueble = new MutableLiveData<>();
        }
        return inmueble;
    }

    public void cargarInmueble(Bundle bundle) {
        Inmueble inmueble = (Inmueble) bundle.getSerializable("inmueble");


        this.inmueble.setValue(inmueble);
    }
}