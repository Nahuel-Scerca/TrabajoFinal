package com.example.trabajofinal.ui.inquilinos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.trabajofinal.R;
import com.example.trabajofinal.modelo.Inquilino;

import java.util.List;

public class Adapter extends ArrayAdapter<Inquilino> {

    private Context context;
    private List<Inquilino> lista;
    private LayoutInflater li;

    public Adapter(@NonNull Context context, int resource, @NonNull List<Inquilino> objects , LayoutInflater li) {

        super(context, resource, objects);
        this.context = context;
        this.lista= objects;
        this.li=li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView= convertView;
        if(itemView==null){
            itemView=li.inflate(R.layout.custom_grid_layout,parent,false);

        }
        Inquilino inquilino= lista.get(position);
        ImageView foto = itemView.findViewById(R.id.ivInquilino);
        foto.setImageResource(R.drawable.inquilino);

        TextView nombre= itemView.findViewById(R.id.tvNombre);
        nombre.setText(inquilino.getNombre()+"  "+inquilino.getApellido());

        TextView inmueble= itemView.findViewById(R.id.tvInmueble);
        inmueble.setText("Inmueble: "+inquilino.getInmueble().getDireccion());


        return itemView;

    }
}
