package com.example.repasoexamenandroid.ui.listado;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repasoexamenandroid.R;
import com.example.repasoexamenandroid.modelo.AdapterVehiculos;
import com.example.repasoexamenandroid.modelo.DAOVehiculo;
import com.example.repasoexamenandroid.modelo.IDAOVehiculo;
import com.example.repasoexamenandroid.modelo.Vehiculo;
import com.example.repasoexamenandroid.ui.modificar.ModificarFragment;

import java.util.ArrayList;

public class ListadoFragment extends Fragment {

    RecyclerView recycler;
    AdapterVehiculos adaptador;
    IDAOVehiculo dao;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listado, container, false);

        dao = DAOVehiculo.getInstance(getContext());
        adaptador = new AdapterVehiculos(view.getContext(), dao.getVehiculos());
        recycler = view.findViewById(R.id.recyclerVehiculos);
        recycler.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recycler.setAdapter(adaptador);
        Toast.makeText(getContext(), "Manten pulsado un vehiculo para mostrar opciones.", Toast.LENGTH_LONG).show();

        return view;
    }
}