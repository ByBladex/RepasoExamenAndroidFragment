package com.example.repasoexamenandroid.ui.modificar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class ModificarFragment extends Fragment {

    private IDAOVehiculo dao;
    private String matricula;
    EditText editTextModMatricula;
    EditText editTextModMatricula2;
    EditText editTextModMarca;
    EditText editTextModModelo;
    Button btnModificar, btnBuscar;
    Vehiculo vehiculo;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_modificar, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editTextModMatricula = view.findViewById(R.id.editTextModMatricula);
        editTextModMatricula2 = view.findViewById(R.id.editTextModMatricula2);
        editTextModMarca = view.findViewById(R.id.editTextModMarca);
        editTextModModelo = view.findViewById(R.id.editTextModModelo);
        btnModificar = view.findViewById(R.id.btnModificar);
        btnModificar.setOnClickListener(modificar);
        btnBuscar = view.findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(buscar);

        dao = DAOVehiculo.getInstance(getContext());


    }

    View.OnClickListener modificar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!editTextModMatricula2.toString().equals("") && !editTextModMarca.toString().equals("") && !editTextModModelo.toString().equals("")){
                if(dao.modificarVehiculo(editTextModMatricula.getText().toString(), editTextModMatricula2.getText().toString(), editTextModMarca.getText().toString(), editTextModModelo.getText().toString()) == 1){
                    Toast.makeText(getView().getContext(), "Vehiculo modificado satisfactoriamente", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getView().getContext(), "Error al modificar el vehiculo", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(getView().getContext(), "*Todos los campos son obligatorios*", Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener buscar = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            vehiculo = dao.getVehiculo(matricula);
            if(vehiculo != null){
                editTextModMatricula2.setText(vehiculo.getMatricula());
                editTextModMarca.setText(vehiculo.getMarca());
                editTextModModelo.setText(vehiculo.getModelo());
                Toast.makeText(getView().getContext(), "Vehiculo encontrado", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(getView().getContext(), "El vehiculo buscado no existe", Toast.LENGTH_SHORT).show();
        }
    };
}