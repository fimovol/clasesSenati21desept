package com.example.el_24deseptiembre;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper mydb;
    EditText etNombre,etApellido,etCorreo;
    Button btRegistrar, btVerdatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DataBaseHelper(this);
        etNombre = findViewById(R.id.editTextTextPersonName);
        etApellido= findViewById(R.id.editTextTextPersonName2);
        etCorreo = findViewById(R.id.editTextTextPersonName3);

        btRegistrar = findViewById(R.id.button);
        btVerdatos = findViewById(R.id.button2);
        ViweData();
        AddData();
    }
    public void AddData(){
        btRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isinsert = mydb.insertData(
                        etNombre.getText().toString(),
                        etApellido.getText().toString(),
                        etCorreo.getText().toString()
                );
                if(isinsert){
                    Toast.makeText(MainActivity.this,
                            "registro insertafo",
                            Toast.LENGTH_LONG
                            ).show();
                }else{
                    Toast.makeText(MainActivity.this,
                            "registro NO insertafo",
                            Toast.LENGTH_LONG
                    ).show();
                }
            }
        });
    }
    public void showMesage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void ViweData(){
        btVerdatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = mydb.getAllData();
                if(res.getCount() == 0){
                    showMesage("error","nada que ver aqui");
                    return;
                }
                StringBuffer bufer = new StringBuffer();

                while(res.moveToNext()){
                    bufer.append("ID"+res.getString(0)+"\n");
                    bufer.append("Nombre"+res.getString(1)+"\n");
                    bufer.append("Apellido"+res.getString(2)+"\n");
                    bufer.append("Correo"+res.getString(3)+"\n");
                }
                showMesage("Data",bufer.toString());
            }
        });
    }
}