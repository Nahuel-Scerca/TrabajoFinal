package com.example.trabajofinal.ui.pagos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trabajofinal.modelo.Contrato;
import com.example.trabajofinal.modelo.Inmueble;
import com.example.trabajofinal.modelo.Inquilino;
import com.example.trabajofinal.modelo.Pago;

import java.util.ArrayList;

public class PagosViewModel extends ViewModel {

    private MutableLiveData<ArrayList> pagos;
    private ArrayList<Pago> lista = new ArrayList<>();

    public LiveData<ArrayList> getPagos() {
        if(pagos== null){
            pagos= new MutableLiveData<>();
        }
        return pagos;
    }



    public void cargarDatos(){
        lista.add(new Pago(1, 1001, new Contrato(1, "30/12/2010","31/12/2020", 15000, new Inquilino(1,"403154842", "Nahuel", "Scerca","nahuel@gmail.com", "2664243132"), new Inmueble("9 de julio 1221",1)),  "10/10/2020"));
        lista.add(new Pago(2, 1002, new Contrato(1, "30/12/2010","31/12/2020", 15000, new Inquilino(1,"403154842", "Nahuel", "Scerca","nahuel@gmail.com", "2664243132"), new Inmueble("9 de julio 1221",1)),  "10/11/2020"));


        lista.add(new Pago(3, 1003, new Contrato(2,"20/11/2021","20/11/2012", 11000, new Inquilino(2,"23123213", "Hernan", "Gomez","hernan@gmail.com", "266448485"), new Inmueble("jujuy 9",2)),  "10/111/2020"));
        lista.add(new Pago(4, 1004, new Contrato(2,"20/11/2021","20/11/2012", 11000, new Inquilino(2,"23123213", "Hernan", "Gomez","hernan@gmail.com", "266448485"), new Inmueble("jujuy 9",2)),  "10/111/2020"));


        lista.add(new Pago(5, 1005, new Contrato(3, "11/08/2020","10/06/2024", 14000, new Inquilino(3,"33211332", "Flavio", "Aguilar","fla@gmail.com", "26648798"), new Inmueble("balcarce 1212",3)),  "10/12/2020"));
        lista.add(new Pago(6, 1006, new Contrato(3, "11/08/2020","10/06/2024", 14000, new Inquilino(3,"33211332", "Flavio", "Aguilar","fla@gmail.com", "26648798"), new Inmueble("balcarce 1212",3)),  "10/12/2020"));


        lista.add(new Pago(7, 1007, new Contrato(4,"15/02/2019","14/10/2020", 20000, new Inquilino(4,"1235654567", "Emanuel", "Ferreyra","ema@gmail.com", "2664313131"), new Inmueble("yapeyu 123",4)), "10/10/2020"));
        lista.add(new Pago(8, 1008, new Contrato(4,"15/02/2019","14/10/2020", 20000, new Inquilino(4,"1235654567", "Emanuel", "Ferreyra","ema@gmail.com", "2664313131"), new Inmueble("yapeyu 123",4)), "10/10/2020"));


        pagos.setValue(lista);
    }
}