package com.example.proyecto_pdm01.controladores;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proyecto_pdm01.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void initRegistro(View view){
        Intent intentRegistro = new Intent(this, Vista_Registro.class);
        startActivity(intentRegistro);
        Toast.makeText(this, "Registro iniciado", Toast.LENGTH_SHORT).show();
    }
    public void initLista(View view){
        Intent intentLista = new Intent(this, Vista_Lista.class);
        startActivity(intentLista);
        Toast.makeText(this, "Lista Iniciada", Toast.LENGTH_SHORT).show();
    }

}