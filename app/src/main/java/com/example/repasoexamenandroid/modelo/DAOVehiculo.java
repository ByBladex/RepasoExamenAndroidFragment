package com.example.repasoexamenandroid.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.repasoexamenandroid.bd.VehiculoSQLiteHelper;

import java.util.ArrayList;
import java.util.List;

public class DAOVehiculo implements IDAOVehiculo{

    private static IDAOVehiculo dao = null;
    private ArrayList<Vehiculo> listaVehiculos;
    private VehiculoSQLiteHelper helper;
    private SQLiteDatabase db;

    DAOVehiculo(Context context){
        listaVehiculos = new ArrayList<Vehiculo>();
        helper = new VehiculoSQLiteHelper(context,"bdVehiculosSQLite",null,1);

        construirLista();
    }

    public int construirLista(){
        try{
            db = helper.getWritableDatabase();
            listaVehiculos.clear();
            if(db != null){
                Cursor c = db.rawQuery("SELECT * FROM Vehiculo", null);
                if(c.moveToFirst()){
                    do{
                        listaVehiculos.add(new Vehiculo(c.getString(0),c.getString(1),c.getString(2)));
                    }
                    while(c.moveToNext());
                }
                c.close();
                db.close();
                return 1;
            }
            return 0;
        }
        catch (SQLException ex){
            return 0;
        }
    }

    @Override
    public int insertarVehiculo(Vehiculo vehiculo) {
        try{
            db = helper.getWritableDatabase();
            if(db != null){
                db.execSQL("INSERT INTO Vehiculo (matricula, marca, modelo) VALUES('"+vehiculo.getMatricula()+"','"+vehiculo.getMarca()+"','"+vehiculo.getModelo()+"')");
                construirLista();
                db.close();
                return 1;
            }
            else
                return 0;
        }
        catch (SQLException ex){
            return 0;
        }
    }

    @Override
    public int eliminarVehiculo(Vehiculo vehiculo) {
        try{
            db = helper.getWritableDatabase();
            if(db != null){
                db.execSQL("DELETE FROM Vehiculo WHERE matricula='"+vehiculo.getMatricula()+"'");
                construirLista();
                db.close();
                return 1;
            }
            else
                return 0;
        }
        catch (SQLException ex){
            return 0;
        }
    }

    @Override
    public int eliminarVehiculos(List<Vehiculo> listaVehiculos) {
        try{
            db = helper.getWritableDatabase();
            if(db != null){
                for(Vehiculo vehiculo: listaVehiculos){
                    db.execSQL("DELETE FROM Vehiculo WHERE matricula='"+vehiculo.getMatricula()+"'");
                }
                construirLista();
                db.close();
                return 1;
            }
            else
                return 0;
        }
        catch (SQLException ex){
            return 0;
        }
    }

    @Override
    public int modificarVehiculo(String matricula, String matricula2, String marca, String modelo) {
        try{
            int id = listaVehiculos.indexOf(matricula);
            Vehiculo vehiculo = listaVehiculos.get(id);
            db = helper.getWritableDatabase();
            if(db != null){
                db.execSQL("UPDATE Vehiculo SET matricula='"+matricula2+"', marca='"+marca+"', modelo='"+modelo+"' WHERE matricula='"+vehiculo.getMatricula()+"'");
                construirLista();
                db.close();
                return 1;
            }
            else
                return 0;
        }
        catch (ArrayIndexOutOfBoundsException | SQLException ex){
            return 0;
        }
    }

    @Override
    public Vehiculo getVehiculo(String matricula) {
        for(Vehiculo vehiculo: listaVehiculos){
            if(vehiculo.getMatricula() == matricula){
                return vehiculo;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Vehiculo> getVehiculos() {
        return listaVehiculos;
    }

    public static IDAOVehiculo getInstance(Context context){
        if(dao == null)
            dao = new DAOVehiculo(context);
        return dao;
    }
}
