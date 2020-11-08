package com.example.trabajofinal.ui.contratos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trabajofinal.R;
import com.example.trabajofinal.modelo.Contrato;
import com.example.trabajofinal.modelo.Inmueble;
import com.example.trabajofinal.modelo.Inquilino;
import com.example.trabajofinal.request.ApiClient;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContratoViewModel extends AndroidViewModel {

    private MutableLiveData<Contrato> contrato;
    private ArrayList<Contrato> lista = new ArrayList<>();
    private Context context;

    public ContratoViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<Contrato> getContrato() {
        if(contrato== null){
            contrato= new MutableLiveData<>();
        }
        return contrato;
    }



    /*public void cargarDatos(){
        lista.add(new Contrato(1, "30/12/2010","31/12/2020", 15000, new Inquilino(1,"403154842", "Nahuel", "Scerca","nahuel@gmail.com", "2664243132"), new Inmueble("9 de julio 1221",1)));
        lista.add(new Contrato(2,"20/11/2021","20/11/2012", 11000, new Inquilino(2,"23123213", "Hernan", "Gomez","hernan@gmail.com", "266448485"), new Inmueble("jujuy 9",2)));
        lista.add(new Contrato(3, "11/08/2020","10/06/2024", 14000, new Inquilino(3,"33211332", "Flavio", "Aguilar","fla@gmail.com", "26648798"), new Inmueble("balcarce 1212",3)));
        lista.add(new Contrato(4,"15/02/2019","14/10/2020", 20000, new Inquilino(4,"1235654567", "Emanuel", "Ferreyra","ema@gmail.com", "2664313131"), new Inmueble("yapeyu 123",4)));
        contrato.setValue(lista);
    }*/

    public void obtenerContrato(int id){

        final SharedPreferences sh= context.getSharedPreferences("datos",0);
        String token=sh.getString("token","---");


        final Call<Contrato> arrayContratos = ApiClient.getMyApiInterface().obtenerContratos(token,id);

        arrayContratos.enqueue(new Callback<Contrato>() {
            @Override
            public void onResponse(Call<Contrato> call, Response<Contrato> response) {
                Log.d("ApiContrato", new Gson().toJson(response.body()));
                if(response.isSuccessful()) {
                    Log.d("consultaContrato","NO ENTRA?"+response.body().getId());
                    contrato.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Contrato> call, Throwable t) {
                Toast.makeText(context,"No se puedo obtener el Contrato",Toast.LENGTH_LONG).show();
                Log.d("consultaContrato",t.getCause().toString());
            }
        });

    }


}