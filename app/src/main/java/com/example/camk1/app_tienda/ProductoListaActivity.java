package com.example.camk1.app_tienda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.camk1.app_tienda.Clases.Producto;
import com.example.camk1.app_tienda.Clases.ProductoListaAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hola on 27/11/2016.
 */

public class ProductoListaActivity extends AppCompatActivity {
    List<Producto> producto = new ArrayList<>();
    //RecyclerView
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_producto);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //nombre producto
        TextView nombrepro=(TextView)findViewById(R.id.nombreProducto);


    }
    public void usarRecycleView(){
        recycler = (RecyclerView) findViewById(R.id.my_recycler_view);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getBaseContext());
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new ProductoListaAdapter(producto);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getBaseContext()));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
