package com.example.lascompras;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper  {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BasedeDatos) {
        BasedeDatos.execSQL("create table Tianguis(nom_lista int ,fecha date, alcachofa real, apio real, berenjena real, calabaza real, cebolla real, espinacas real, jitomate real)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
