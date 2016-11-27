package com.example.camk1.app_tienda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.camk1.app_tienda.Clases.Producto;
import com.example.camk1.app_tienda.Clases.ProductoListaAdapter;
import com.example.camk1.app_tienda.Clases.TarjetaInicio;
import com.example.camk1.app_tienda.Clases.TarjetaInicioAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hola on 27/11/2016.
 */

public class ProductoActivity extends AppCompatActivity {
    List<TarjetaInicio> tarjeta = new ArrayList<>();
    //RecyclerView
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        tarjeta.add(new TarjetaInicio("Producto",""));
        tarjeta.add(new TarjetaInicio("Producto",""));
        tarjeta.add(new TarjetaInicio("Producto",""));
        tarjeta.add(new TarjetaInicio("Producto",""));
        usarRecycleView();
    }
    public void usarRecycleView(){
        recycler = (RecyclerView) findViewById(R.id.my_recycler_producto);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getBaseContext());
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        recycler.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));
        adapter = new TarjetaInicioAdapter(tarjeta);
        recycler.setAdapter(adapter);
    }
}
