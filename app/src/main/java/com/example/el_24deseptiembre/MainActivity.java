package com.example.el_24deseptiembre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
}