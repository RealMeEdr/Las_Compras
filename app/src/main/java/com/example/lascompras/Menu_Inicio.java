package com.example.lascompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Menu_Inicio extends AppCompatActivity {

    private EditText et_num_ped, et_fecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__inicio);

        et_num_ped = (EditText)findViewById(R.id.txt_numpedido);
        et_fecha = (EditText)findViewById(R.id.txtFecha);
    }

    public void Nueva_Lista (View abrir){
        Intent lista = new Intent(this, Lista.class);
        startActivity(lista);
    }

    public void Buscar(View ver){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Tianguis", null, 1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();

        String num_pedido_string = et_num_ped.getText().toString();

        if(!num_pedido_string.isEmpty()){
            Cursor fila =  BasedeDatos.rawQuery
                    ("select fecha from Tianguis where nom_lista=" + num_pedido_string, null);
            if (fila.moveToFirst()){
                et_fecha.setText(fila.getString(0));
                BasedeDatos.close();
            }else{
                Toast.makeText(this, "No existe dicho valor de lista o pedido", Toast.LENGTH_LONG).show();
                BasedeDatos.close();
            }
        }else{
            Toast.makeText(this, "Debe introducir el código del pedido o lista", Toast.LENGTH_LONG).show();

        }
    }

}