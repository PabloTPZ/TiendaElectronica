package com.example.camk1.app_tienda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.camk1.app_tienda.Clases.Producto;
import com.example.camk1.app_tienda.Clases.ProductoListaAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hola on 27/11/2016.
 */

public class ProductoListaActivity extends AppCompatActivity {
    List<Producto> producto = new ArrayList<>();
    //RecyclerView
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    private String categoria;

    private DatabaseReference myDataBase = FirebaseDatabase.getInstance().getReference();


    //Variables
    private String keyProd;
    private String nombreProd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_producto);
        //nombre producto
        TextView tituloCategoria=(TextView)findViewById(R.id.nombreProducto);

        Intent intent = getIntent();
        categoria=intent.getStringExtra("Categoria");
        tituloCategoria.setText(categoria);
        Toast.makeText(getApplicationContext(),categoria,Toast.LENGTH_SHORT).show();
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
    protected void onStart() {
        super.onStart();
        DatabaseReference categoriaProducto = myDataBase.child(categoria);
        producto.clear();

        categoriaProducto.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Producto productoAgregar=new Producto("vacio","vacio");
                if (dataSnapshot.hasChildren()) {
                    keyProd = nombreProd= "";
                    keyProd = dataSnapshot.getKey();
                    Map<String, Object> dataChild = (Map<String, Object>) dataSnapshot.getValue();
                    nombreProd = dataChild.get("Nombre").toString();
                    productoAgregar = new Producto(keyProd,nombreProd);
                }
                if (!producto.contains(productoAgregar) && !productoAgregar.getKey().equals("vacio")){
                    producto.add(productoAgregar);
                }
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
