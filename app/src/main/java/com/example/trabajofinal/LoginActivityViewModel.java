package com.example.trabajofinal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LoginActivityViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<String> error;

    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<String> getError() {
        if(error == null){
            error = new MutableLiveData<>();
        }
        return error;
    }

    public void autenticacion(String u, String c){
        String usuario= "nahuel";
        String contraseña = "1234";
        if (usuario.equals(u) && contraseña.equals(c)) {
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        } else {
            error.setValue("Usuario y/o o contraseña incorrectos");
        }
    }

}
