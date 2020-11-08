package com.example.trabajofinal.ui.inmuebleUnico;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trabajofinal.modelo.Inmueble;
import com.example.trabajofinal.request.ApiClient;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InmuebleUnicoViewModel extends AndroidViewModel {
    private MutableLiveData<Inmueble> inmueble;
    private Context context;
    public InmuebleUnicoViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<Inmueble> getInmueble() {
        if (inmueble == null) {
            inmueble = new MutableLiveData<>();
        }
        return inmueble;
    }
    public void cambiarEstado(Inmueble inm){
        final SharedPreferences sh= context.getSharedPreferences("datos",0);
        String token=sh.getString("token","---");

        Call<Inmueble> cambiarEstado = ApiClient.getMyApiInterface().actualizarEstado(token,inm);


        Log.d("Api", new Gson().toJson(inm));
        cambiarEstado.enqueue(new Callback<Inmueble>() {
            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                if(response.isSuccessful()){
                    Log.d("Api", response.body()+"");
                    inmueble.setValue(response.body());
                }
                else{
                    Log.d("sali","Nada"+call.toString());
                }
            }

            @Override
            public void onFailure(Call<Inmueble> call, Throwable t) {
                Toast.makeText(context,"No se pudo Actualizar el Estado",Toast.LENGTH_LONG);
            }
        });
    }

    public void cargarInmueble(Bundle bundle) {
        Inmueble inmueble = (Inmueble) bundle.getSerializable("inmueble");


        this.inmueble.setValue(inmueble);
    }
}