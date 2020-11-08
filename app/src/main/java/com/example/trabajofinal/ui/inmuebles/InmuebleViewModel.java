package com.example.trabajofinal.ui.inmuebles;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.trabajofinal.R;
import com.example.trabajofinal.modelo.Inmueble;
import com.example.trabajofinal.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InmuebleViewModel extends AndroidViewModel {

    private MutableLiveData<List<Inmueble>> inmueble;
    private ArrayList<Inmueble> lista = new ArrayList<>();
    private Context context;

    public InmuebleViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<List<Inmueble>> getInmueble() {
        if(inmueble== null){
            inmueble= new MutableLiveData<List<Inmueble>>();
        }
        return inmueble;
    }


/*
    public void cargarDatos(){
        lista.add(new Inmueble(1,"9 de julio 1221", 2,"Departamento", "Domestico", 11111, "123123","2313123",100000, 1, 1, R.drawable.casa1));
        lista.add(new Inmueble(2,"Jujuy 9", 2,"Departamento", "Domestico", 11111, "123123","2313123",120000, 1, 1, R.drawable.casa1));
        lista.add(new Inmueble(3,"Balcarce 1212", 2,"Departamento", "Domestico", 11111, "123123","2313123",140000, 1, 1, R.drawable.casa2));
        lista.add(new Inmueble(4,"Yapeyu 123", 2,"Departamento", "Domestico", 11111, "123123","2313123",110000, 1, 1, R.drawable.casa3));

        inmueble.setValue(lista);
    }*/



    public void obtenerInmuebles(){

        final SharedPreferences sh= context.getSharedPreferences("datos",0);
        String token=sh.getString("token","---");


            final Call<List<Inmueble>>  arrayInmuebles = ApiClient.getMyApiInterface().obtenerInmuebles(token);

            arrayInmuebles.enqueue(new Callback<List<Inmueble>>() {
                @Override
                public void onResponse(Call<List<Inmueble>> call, Response<List<Inmueble>> response) {


                    if(response.isSuccessful()) {

                        inmueble.setValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<List<Inmueble>> call, Throwable t) {

                    Toast.makeText(context,"No se puedo obtener los inmuebles",Toast.LENGTH_LONG).show();
                }
            });

    }


}