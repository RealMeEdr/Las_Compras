package com.example.lascompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Lista extends AppCompatActivity {

    private EditText et_numpedido, et_fecha, et_alcachofa,et_apio, et_berenjena;
    private EditText et_calabaza, et_cebolla, et_espinacas, et_jitomate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        et_numpedido = (EditText)findViewById(R.id.txt_num_pedido);
        et_fecha = (EditText)findViewById(R.id.txt_fecha);
        et_alcachofa = (EditText)findViewById(R.id.txt_Alcachofa);
        et_apio = (EditText)findViewById(R.id.txtApio);
        et_berenjena = (EditText)findViewById(R.id.txtBerenjena);
        et_calabaza = (EditText)findViewById(R.id.txtCalabaza);
        et_cebolla = (EditText)findViewById(R.id.txtCebolla);
        et_espinacas = (EditText)findViewById(R.id.txtEspinacas);
        et_jitomate = (EditText)findViewById(R.id.txt_Jitomate);
    }

    public void Guardar(View view){
       AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Tianguis", null, 1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();

        String numero_pedido = et_numpedido.getText().toString();
        String fecha_string = et_fecha.getText().toString();
        String alcachofa = et_alcachofa.getText().toString();
        String apio = et_apio.getText().toString();
        String berenjena = et_berenjena.getText().toString();
        String calabaza = et_calabaza.getText().toString();
        String cebolla = et_cebolla.getText().toString();
        String espinacas = et_espinacas.getText().toString();
        String jitomate = et_jitomate.getText().toString();

        if(!numero_pedido.isEmpty() && !alcachofa.isEmpty() && !fecha_string.isEmpty() && !apio.isEmpty() && !berenjena.isEmpty() && !calabaza.isEmpty() &&
        !cebolla.isEmpty() && !espinacas.isEmpty() && !jitomate.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("nom_lista", numero_pedido);
            registro.put("fecha", fecha_string);
            registro.put("alcachofa", alcachofa);
            registro.put("apio", apio);
            registro.put("berenjena", berenjena);
            registro.put("calabaza", calabaza);
            registro.put("cebolla", cebolla);
            registro.put("espinacas", espinacas);
            registro.put("jitomate", jitomate);

            BasedeDatos.insert("Tianguis", null, registro);
            BasedeDatos.close();
        Toast.makeText(this, "Registro exitoso",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Debe rellenar todos los campos", Toast.LENGTH_LONG).show();
        }
    }
}