package com.example.proyecto_pdm01.controladores;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proyecto_pdm01.R;

public class Vista_Registro extends AppCompatActivity {

    private String email;
    private String usuario;
    private int edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vista_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public int comprobarDatos() {

        String usuario = ((EditText) findViewById(R.id.usuario)).getText().toString();
        String correoElectronico = ((EditText) findViewById(R.id.email)).getText().toString();
        int edad = 0;
        int res = 1;
        try {
            edad = Integer.parseInt(((EditText) findViewById(R.id.edad)).getText().toString());
        } catch (NumberFormatException e) {
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("La edad debe ser un número válido")
                    .setPositiveButton("Aceptar", null)
                    .show();
            return -1;
        }

        if (edad < 18) {
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("La edad debe ser mayor de 18 años")
                    .setPositiveButton("Aceptar", null)
                    .show();
            return -1;
        }
        if (usuario.isEmpty() || correoElectronico.isEmpty() || edad == 0) {
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Por favor, rellena todos los campos.")
                    .setPositiveButton("Aceptar", null)
                    .show();
            return -1;
        }

        return res;
    }

    public void recogerRegistro(View view) {
        if (comprobarDatos() == 1){
            Toast.makeText(this, "Registro realizado con éxito", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(this, "Error al registrar", Toast.LENGTH_SHORT).show();
            return ;
        }

    }
}