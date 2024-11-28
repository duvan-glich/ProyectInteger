package com.example.proyecto;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarProductos extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinner;
    private EditText edtId, edtNombre, edtCant;
    private Button btnRegistrar;

    // Comentamos FirebaseFirestore
    // private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_productos);

        edtId = findViewById(R.id.edtId);
        edtNombre = findViewById(R.id.edtNombre);
        edtCant = findViewById(R.id.edtCant);
        spinner = findViewById(R.id.spinner);
        btnRegistrar = findViewById(R.id.btnRegistrar);  // Corregido el ID del botón

        btnRegistrar.setOnClickListener(this);

        // Opciones para el Spinner
        String[] opciones = {"Bicicleta", "Patines", "Guantes", "Sudaderas", "Pesas", "Bandas", "Balones", "Raquetas"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);
    }

    private void registrarMaterial() {
        String id = edtId.getText().toString();
        String nombre = edtNombre.getText().toString();
        String cantidad = edtCant.getText().toString();
        String tipo = spinner.getSelectedItem().toString();

        if (!id.isEmpty() && !nombre.isEmpty() && !cantidad.isEmpty() && !tipo.equals("Tipo")) {
            // Comentamos la parte de FirebaseFirestore
            // CollectionReference materialesRef = db.collection("productos");  // Cambié a 'productos'

            // En vez de Firebase, solo mostramos un mensaje simulando el registro
            // Producto producto = new Producto(id, nombre, cantidad, tipo);

            // Aquí puedes simular el registro y el éxito en el Toast
            // materialesRef.add(producto)
            //         .addOnSuccessListener(documentReference -> {
            //             Toast.makeText(this, nombre + " se ha registrado con éxito", Toast.LENGTH_SHORT).show();
            //             edtId.setText("");
            //             edtNombre.setText("");
            //             edtCant.setText("");
            //             spinner.setSelection(0);
            //         })
            //         .addOnFailureListener(e -> Toast.makeText(this, "Error al registrar material", Toast.LENGTH_SHORT).show());

            // Simulamos éxito de registro
            Toast.makeText(this, nombre + " se ha registrado con éxito (simulado)", Toast.LENGTH_SHORT).show();
            edtId.setText("");
            edtNombre.setText("");
            edtCant.setText("");
            spinner.setSelection(0);

        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        registrarMaterial();
    }
}
