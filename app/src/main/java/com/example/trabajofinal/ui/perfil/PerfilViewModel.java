package com.example.trabajofinal.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.trabajofinal.modelo.Propietario;
import com.example.trabajofinal.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends AndroidViewModel {

    private MutableLiveData<Propietario> propietario;
    private Context context;

    public PerfilViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<Propietario> getPropietario() {
        if(propietario== null){
            propietario= new MutableLiveData<>();
        }
        return propietario;
    }

    public void editarPropietario(Propietario prop){
        final SharedPreferences sh= context.getSharedPreferences("datos",0);
        String token=sh.getString("token","---");
        int id = sh.getInt("id",-1);
        //seteamos/recuperamos el id porque prop viene sin id , y nos haria un post
        prop.setId(id);

            final Call<Propietario> propiet = ApiClient.getMyApiInterface().actualizarPropietario(token,prop);
            propiet.enqueue(new Callback<Propietario>() {
                @Override
                public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                    Log.d("salida","no entro");

                    if(response.isSuccessful()) {
                        Log.d("salida","ahora entre"+response.isSuccessful());
                        SharedPreferences.Editor editor= sh.edit();

                        Propietario propietarioApi = response.body();
                        propietario.setValue(propietarioApi);
                        Log.d("salida",propietarioApi.getNombre() + "ENTRE");

                        editor.putInt("id",propietarioApi.getId());
                        editor.putString("nombre",propietarioApi.getNombre());
                        editor.putString("apellido",propietarioApi.getApellido());
                        editor.putString("dni",propietarioApi.getDni());
                        editor.putString("email",propietarioApi.getEmail());
                        editor.putString("clave",propietarioApi.getClave());
                        editor.putString("telefono",propietarioApi.getTelefono());
                        editor.commit();
                        Toast.makeText(context,"Se modifico correctamente", Toast.LENGTH_LONG);
                    }
                }

                @Override
                public void onFailure(Call<Propietario> call, Throwable t) {
                    Toast.makeText(context,"No se puedo obtener el TOKEN",Toast.LENGTH_LONG).show();
                }
            });

    }

    public void recuperarPropietario(Boolean login){

        final SharedPreferences sh= context.getSharedPreferences("datos",0);
        String token=sh.getString("token","---");
        String email = sh.getString("email","--");
        Log.d("salida","TOKEN:"+token);

        if(login){
            final Call<Propietario> propiet = ApiClient.getMyApiInterface().obtenerPropietario(token);
            propiet.enqueue(new Callback<Propietario>() {
                @Override
                public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                    Log.d("salida","no entro");

                    if(response.isSuccessful()) {
                        Log.d("salida","ahora entre"+response.isSuccessful());
                        SharedPreferences.Editor editor= sh.edit();

                        Propietario propietarioApi = response.body();
                        propietario.setValue(propietarioApi);
                        Log.d("salida",propietarioApi.getNombre() + "ENTRE");

                        editor.putInt("id",propietarioApi.getId());
                        editor.putString("nombre",propietarioApi.getNombre());
                        editor.putString("apellido",propietarioApi.getApellido());
                        editor.putString("dni",propietarioApi.getDni());
                        editor.putString("email",propietarioApi.getEmail());
                        editor.putString("clave",propietarioApi.getClave());
                        editor.putString("telefono",propietarioApi.getTelefono());
                        editor.commit();

                    }
                }

                @Override
                public void onFailure(Call<Propietario> call, Throwable t) {
                    Toast.makeText(context,"No se puedo obtener el TOKEN",Toast.LENGTH_LONG).show();
                }
            });
        }


        Propietario p = new Propietario(
                sh.getInt("id",-1),
                sh.getString("nombre","--"),
                sh.getString("apellido","--"),
                sh.getString("email","--"),
                sh.getString("clave","--"),
                sh.getString("dni","--"),
                sh.getString("telefono","--")
        );

        propietario.setValue(p);
    }
}