package com.example.trabajofinal.request;


import com.example.trabajofinal.modelo.Contrato;
import com.example.trabajofinal.modelo.Inmueble;
import com.example.trabajofinal.modelo.Inquilino;
import com.example.trabajofinal.modelo.Pago;
import com.example.trabajofinal.modelo.Propietario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class ApiClient {

    private static final String PATH ="http://192.168.0.14:45455/api/";
    private static MyApiInterface myApiInterface;

    public static  MyApiInterface getMyApiInterface(){
        Gson gson= new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        myApiInterface= retrofit.create(MyApiInterface.class);

        return myApiInterface;

    }


    public interface MyApiInterface {


        //Propietarios
        @FormUrlEncoded
        @POST("Propietarios/Login")
        Call<String> obtenerToken(@Field("Usuario") String usuario,@Field("Clave") String clave);


        @GET("Propietarios")
        Call<Propietario> obtenerPropietario(@Header("Authorization") String autorizacion);


        @PUT("Propietarios")
        Call<Propietario> actualizarPropietario(@Header("Authorization") String autorizacion,@Body Propietario propietario);


        //Inmuebles
        @GET("Inmuebles")
        Call<List<Inmueble>> obtenerInmuebles(@Header("Authorization") String autorizacion);

        @PUT("Inmuebles")
        Call<Inmueble> actualizarEstado(@Header("Authorization") String autorizacion,@Body Inmueble inmueble);


        //Inquilinos
        @GET("Inquilinos")
        Call<List<Inquilino>> obtenerInquilinos(@Header("Authorization") String autorizacion);


        //Contratos
        @GET("Contratos/Inmueble/{id}")
        Call<Contrato> obtenerContratos(@Header("Authorization") String autorizacion , @Path("id") int id );


        //Pagos
        @GET("Pagos")
        Call<List<Pago>> obtenerPagos(@Header("Authorization") String autorizacion);
    }


}
