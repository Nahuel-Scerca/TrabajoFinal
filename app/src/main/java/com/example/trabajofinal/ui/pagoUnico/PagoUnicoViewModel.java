package com.example.trabajofinal.ui.pagoUnico;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trabajofinal.modelo.Contrato;
import com.example.trabajofinal.modelo.Inmueble;
import com.example.trabajofinal.modelo.Pago;

import java.util.ArrayList;
import java.util.List;

public class PagoUnicoViewModel extends ViewModel {

    private MutableLiveData<ArrayList> pagos;
    private ArrayList<Pago> lista = new ArrayList<>();


    public PagoUnicoViewModel() {
        super();
    }

    public LiveData<ArrayList> getPagos() {
        if (pagos == null) {
            pagos = new MutableLiveData<>();
        }
        return pagos;
    }

    public void cargarContrato(Bundle bundle) {

        lista = (ArrayList) bundle.get("pagos");

        Log.d("Salida", lista.get(0)+"");

        pagos.setValue(lista);
    }
}