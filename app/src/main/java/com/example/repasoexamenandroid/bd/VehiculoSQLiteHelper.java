package com.example.repasoexamenandroid.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class VehiculoSQLiteHelper extends SQLiteOpenHelper {

    final String SQLCreate = "CREATE TABLE vehiculo (matricula TEXT PRIMARY KEY, marca TEXT, modelo TEXT)";

    public VehiculoSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCreate);
        db.execSQL("INSERT INTO Vehiculo (matricula, marca, modelo) VALUES ('AVD0101', 'Toyota', 'Supra'), ('JDK0101', 'Nissan', 'Skyline'), ('SDK0101', 'Mazda', 'Rx-5'), ('SQL0101', 'Honda', 'NSX')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS vehiculos");
        this.onCreate(db);
    }
}
