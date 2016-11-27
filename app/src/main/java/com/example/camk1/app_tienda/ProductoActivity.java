package com.example.camk1.app_tienda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.camk1.app_tienda.Clases.Producto;
import com.example.camk1.app_tienda.Clases.ProductoListaAdapter;
import com.example.camk1.app_tienda.Clases.TarjetaInicio;
import com.example.camk1.app_tienda.Clases.TarjetaInicioAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.security.AccessController.getContext;

/**
 * Created by hola on 27/11/2016.
 */

public class ProductoActivity extends AppCompatActivity {
    List<TarjetaInicio> tarjeta = new ArrayList<>();
    //RecyclerView
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    //Variables
    private String nombreProducto;
    private String imagenProducto;

    private DatabaseReference myDataBase = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
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

    @Override
    protected void onStart() {
        super.onStart();
        tarjeta.clear();
        myDataBase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (dataSnapshot.hasChildren()) {
                    nombreProducto="";
                    imagenProducto="https://firebasestorage.googleapis.com/v0/b/tiendaelec-3e964.appspot.com/o/Motores%2FpruebaImagen.jpg?alt=media&token=0bf267e0-11d5-4ba7-bc54-7bcf6bfb05f0";
                    nombreProducto = dataSnapshot.getKey();
                    Map<String, Object> dataChild = (Map<String, Object>) dataSnapshot.getValue();
                    imagenProducto = dataChild.get("ImagenProducto").toString();

                } else
                    Toast.makeText(getApplicationContext(), "No se encurntran datos en la db", Toast.LENGTH_LONG).show();
                tarjeta.add(new TarjetaInicio(nombreProducto,imagenProducto));
                usarRecycleView();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
