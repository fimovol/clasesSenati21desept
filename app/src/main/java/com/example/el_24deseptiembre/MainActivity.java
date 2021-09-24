package com.example.el_24deseptiembre;

import androidx.appcompat.app.AppCompatActivity;

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
}