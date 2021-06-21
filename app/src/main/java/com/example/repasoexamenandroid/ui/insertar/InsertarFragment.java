package com.example.repasoexamenandroid.ui.insertar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.repasoexamenandroid.R;
import com.example.repasoexamenandroid.modelo.DAOVehiculo;
import com.example.repasoexamenandroid.modelo.IDAOVehiculo;
import com.example.repasoexamenandroid.modelo.Vehiculo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class InsertarFragment extends Fragment {

    private EditText editTextMatricula;
    private EditText editTextMarca;
    private EditText editTextModelo;
    private IDAOVehiculo dao;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insertar, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dao = DAOVehiculo.getInstance(getContext());
        editTextMatricula = view.findViewById(R.id.editTextMatricula);
        editTextMarca = view.findViewById(R.id.editTextMarca);
        editTextModelo = view.findViewById(R.id.editTextModelo);
        FloatingActionButton btnInsertar = view.findViewById(R.id.btnInsertar);
        btnInsertar.setOnClickListener(insertarVehiculo);
    }

    View.OnClickListener insertarVehiculo = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(!editTextMatricula.getText().toString().equals("") && !editTextMarca.getText().toString().equals("") && !editTextModelo.getText().toString().equals("")){
                if(dao.insertarVehiculo(new Vehiculo(editTextMatricula.getText().toString(), editTextMarca.getText().toString(), editTextModelo.getText().toString())) == 1){
                    editTextMatricula.setText("");
                    editTextMarca.setText("");
                    editTextModelo.setText("");
                    Toast.makeText(getView().getContext(), "Vehiculo insertado satisfactoriamente", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getView().getContext(), "Error al insertar vehiculo", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(getView().getContext(), "*Todos los campos son obligatorios*", Toast.LENGTH_SHORT).show();
            }
        }
    };
}