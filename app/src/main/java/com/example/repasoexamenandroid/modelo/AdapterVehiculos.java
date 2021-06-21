package com.example.repasoexamenandroid.modelo;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repasoexamenandroid.R;

import java.util.ArrayList;

public class AdapterVehiculos extends RecyclerView.Adapter<AdapterVehiculos.ViewHolderDatos> {

    ArrayList<Vehiculo> listaDatos;
    Context context;

    public AdapterVehiculos(Context context, ArrayList<Vehiculo> listaVehiculos) {
        this.listaDatos = listaVehiculos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Enlaza Adaptador con la lista de la vista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehiculo_item,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) { //Establece la comunicacion entre el adaptador y el ViewHolderDatos
        holder.asignarDatos(listaDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        private TextView matricula;
        private TextView marca;
        private TextView modelo;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            matricula = (TextView) itemView.findViewById(R.id.txtMatricula);
            marca = (TextView) itemView.findViewById(R.id.txtMarca);
            modelo = (TextView) itemView.findViewById(R.id.txtModelo);
        }

        public void asignarDatos(Vehiculo vehiculo) {
            matricula.setText(vehiculo.getMatricula());
            marca.setText(vehiculo.getMarca());
            modelo.setText(vehiculo.getModelo());
        }
    }
}
