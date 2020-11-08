package com.example.trabajofinal.ui.inquilinos;

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
import com.example.trabajofinal.modelo.Inmueble;
import com.example.trabajofinal.modelo.Inquilino;
import com.example.trabajofinal.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InquilinoViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList> inquilino;
    //private ArrayList<Inquilino> lista = new ArrayList<>();
    private Context context;

    public InquilinoViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<ArrayList> getInquilino() {
        if(inquilino== null){
            inquilino= new MutableLiveData<>();
        }
        return inquilino;
    }



   /* public void cargarDatos(){
        lista.add(new Inquilino(1,"403154842", "Nahuel", "Scerca","nahuel@gmail.com", "2664243132",new Inmueble("9 de Julio 1221",1)));
        lista.add(new Inquilino(2,"23123213", "Hernan", "Gomez","hernan@gmail.com", "266448485",new Inmueble("Jujuy 9",2)));
        lista.add(new Inquilino(3,"33211332", "Flavio", "Aguilar","fla@gmail.com", "26648798",new Inmueble("Balcarce 1212",3)));
        lista.add(new Inquilino(4,"1235654567", "Emanuel", "Ferreyra","ema@gmail.com", "2664313131",new Inmueble("Yapeyu 123",4)));

        inquilino.setValue(lista);
    }*/

    public void obtenerInquilinos(){

        final SharedPreferences sh= context.getSharedPreferences("datos",0);
        String token=sh.getString("token","---");

        final Call<List<Inquilino>> arrayInquilinos = ApiClient.getMyApiInterface().obtenerInquilinos(token);

        arrayInquilinos.enqueue(new Callback<List<Inquilino>>() {
            @Override
            public void onResponse(Call<List<Inquilino>> call, Response<List<Inquilino>> response) {


                if(response.isSuccessful()) {

                    inquilino.setValue((ArrayList) response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Inquilino>> call, Throwable t) {

                Toast.makeText(context,"No se puedo obtener los Inquilinos",Toast.LENGTH_LONG).show();
            }
        });

    }
}