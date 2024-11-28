package com.example.proyecto;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListarProductos extends AppCompatActivity {

    ListView listViewProductos;
    ArrayList<String> listaInformacion;
    ArrayList<Producto> listaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_productos);

        listViewProductos = findViewById(R.id.listViewProductos);

        // FirebaseFirestore db;  // Comentado, Firebase no está en uso

        // Simulamos la lista de productos (esto reemplaza la consulta a Firebase)
        simularListaProductos();

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaInformacion);
        listViewProductos.setAdapter(adaptador);

        listViewProductos.setOnItemClickListener((adapterView, view, pos, l) -> {
            String informacion = "Nombre: " + listaProductos.get(pos).getNombre() + "\n";
            informacion += "Categoria: " + listaProductos.get(pos).getCategoria() + "\n";
            informacion += "Stock: " + listaProductos.get(pos).getStock() + "\n";
            informacion += "Precio: " + listaProductos.get(pos).getPrecio() + "\n";

            Toast.makeText(ListarProductos.this, informacion, Toast.LENGTH_LONG).show();
        });
    }

    // Simulamos la obtención de productos (sin Firebase)
    private void simularListaProductos() {
        listaProductos = new ArrayList<>();

        // Simulamos algunos productos para la prueba
        listaProductos.add(new Producto("Bicicleta", "Deporte", "10", "300"));
        listaProductos.add(new Producto("Patines", "Deporte", "15", "150"));
        listaProductos.add(new Producto("Guantes", "Accesorios", "50", "20"));
        listaProductos.add(new Producto("Sudadera", "Ropa", "30", "40"));
        listaProductos.add(new Producto("Balón", "Deporte", "20", "25"));

        // Llamamos a obtenerLista para actualizar la vista
        obtenerLista();
    }

    // Actualizamos la lista de información para mostrar en el ListView
    private void obtenerLista() {
        listaInformacion = new ArrayList<>();
        for (Producto producto : listaProductos) {
            listaInformacion.add("Nombre: " + producto.getNombre() + " | Stock: " + producto.getStock() + " | Precio: " + producto.getPrecio());
        }
    }
}
