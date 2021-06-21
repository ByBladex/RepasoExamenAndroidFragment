package com.example.repasoexamenandroid.modelo;

import java.util.ArrayList;
import java.util.List;

public interface IDAOVehiculo {

    public int insertarVehiculo(Vehiculo vehiculo);
    public int eliminarVehiculo(Vehiculo vehiculo);
    public int eliminarVehiculos(List<Vehiculo> listaVehiculos);
    public int modificarVehiculo(String matricula, String matricula2, String marca, String modelo);
    public Vehiculo getVehiculo(String matricula);
    public ArrayList<Vehiculo> getVehiculos();
}
