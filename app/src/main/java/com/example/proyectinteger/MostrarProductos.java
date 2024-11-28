package com.example.proyecto;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MostrarProductos extends AppCompatActivity implements View.OnClickListener {

    private EditText edtId, edtNombre, edtCategoria, edtTipo;
    private Button btnBuscar;

    // Comentamos FirebaseFirestore
    // private FirebaseFirestore db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_productos);

        // Comentamos la inicialización de FirebaseFirestore
        // db = FirebaseFirestore.getInstance();

        edtId = findViewById(R.id.edtId);
        edtNombre = findViewById(R.id.edtNombre);
        edtCategoria = findViewById(R.id.edtCant); // Asegúrate de que coincida con el XML
        edtTipo = findViewById(R.id.edtTipo);
        btnBuscar = findViewById(R.id.btnBuscar);  // Corregido el ID del botón

        btnBuscar.setOnClickListener(this);
    }

    private void BuscarProducto() {
        String id = edtId.getText().toString();

        if (!id.isEmpty()) {
            // Simulamos la consulta al producto sin Firebase
            // En este caso, simplemente verificamos si el ID es "123" para simular la existencia del producto
            if (id.equals("123")) {
                edtNombre.setText("Producto Ejemplo");
                edtCategoria.setText("10");
                edtTipo.setText("Bicicleta");
            } else {
                Toast.makeText(this, "El ID especificado no existe", Toast.LENGTH_SHORT).show();
                edtNombre.setText("");
                edtCategoria.setText("");
                edtTipo.setText("");
            }
        } else {
            Toast.makeText(this, "Por favor ingrese un ID", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        BuscarProducto();
    }
}
