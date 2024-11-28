package com.example.proyectinteger;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity implements View.OnClickListener {

    private Button btnReg, btnBu, btnLi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        btnReg = findViewById(R.id.btnReg);
        btnBu = findViewById(R.id.btnBu);
        btnLi = findViewById(R.id.btnLi);

        btnReg.setOnClickListener(this);
        btnBu.setOnClickListener(this);
        btnLi.setOnClickListener(this);
    }

    // Método para mostrar y ocultar el menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    // Método para asignar las funciones correspondientes a las opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.opRegistrar) {
            Intent intent = new Intent(MainActivity1.this, RegistrarProductos.class);
            startActivity(intent);

        } else if (id == R.id.opMostrar) {
            Intent intent = new Intent(MainActivity1.this, MostrarProductos.class);
            startActivity(intent);

        } else if (id == R.id.opListar) {
            Intent intent = new Intent(MainActivity1.this, ListarProductos.class);
            startActivity(intent);

        } else {
            finish();
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnReg) {
            // Abrir la actividad de RegistrarProductos
            Intent in = new Intent(MainActivity1.this, RegistrarProductos.class);
            startActivity(in);
        } else if (v.getId() == R.id.btnBu) {
            // Abrir la actividad de MostrarProductos
            Intent in2 = new Intent(MainActivity1.this, MostrarProductos.class);
            startActivity(in2);
        } else if (v.getId() == R.id.btnLi) {
            // Abrir la actividad de ListarProductos
            Intent in3 = new Intent(MainActivity1.this, ListarProductos.class);
            startActivity(in3);
        }
    }
}
