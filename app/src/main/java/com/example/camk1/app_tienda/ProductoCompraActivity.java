package com.example.camk1.app_tienda;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.Map;

/**
 * Created by hola on 27/11/2016.
 */

public class ProductoCompraActivity extends AppCompatActivity {

    //Variables
    private String keyProducto;
    private String categoria;
    private int stockProducto;
    private int cantidadProducto;
    private double precio=0;
    private String nombreProducto;
    //Views
    private TextView informacion;
    private TextView stock;
    private EditText cantidad;
    private TextView nomProduc;
    private ImageView imagenpro;

    String cnatidadp="";
    String nombrep="";
    String imporp="";
    String preciop="";

    private DatabaseReference myDataBase = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra_producto);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageButton compra=(ImageButton)findViewById(R.id.carrito);
        informacion=(TextView)findViewById(R.id.infoPro);
        stock = (TextView) findViewById(R.id.stock);
        cantidad=(EditText) findViewById(R.id.cantidad);
        nomProduc=(TextView) findViewById(R.id.nomProducto);
        imagenpro=(ImageView) findViewById(R.id.imagenpro);

        Intent intent = getIntent();
        keyProducto = intent.getStringExtra("KeyProducto");
        categoria = intent.getStringExtra("Categoria");

        cnatidadp = intent.getStringExtra("cantidadp");
        nombrep = intent.getStringExtra("nombrep");
        imporp = intent.getStringExtra("importep");
        preciop=intent.getStringExtra("preciop");

        if(cnatidadp==null){
            cnatidadp="";
            nombrep="";
            imporp="";
            preciop="";
        }

        compra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantidadProducto=Integer.valueOf(cantidad.getText().toString());

                if (stockProducto>cantidadProducto){
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    final DialogoConfirmacion dialogo = new DialogoConfirmacion();
                    TextView total=(TextView) findViewById(R.id.total);
                    Bundle bundle = new Bundle();
                    bundle.putString("keyProducto", keyProducto);
                    bundle.putString("nombreProd", nombrep+"\n"+nombreProducto);
                    bundle.putString("precio", String.valueOf(cantidadProducto));
                    bundle.putString("cantidad", String.valueOf(cantidadProducto));

                    bundle.putString("imporp", imporp);
                    bundle.putString("preciop", preciop);
                    bundle.putString("cantidadp", cnatidadp);

                    dialogo.setArguments(bundle);
                    dialogo.show(fragmentManager, "tagAlerta");
                    dialogo.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            if (dialogo.isVolverCargar()) {
                                onStart();
                            }
                        }
                    });
                }else{
                    Toast.makeText(getApplication(),"No hay stock disponible para realizar la comprar",Toast.LENGTH_SHORT).show();
                }
            }
        });
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

    @Override
    protected void onStart() {
        super.onStart();
        DatabaseReference categoriaProducto = myDataBase.child(categoria);
        categoriaProducto.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                if (dataSnapshot.hasChildren()) {
                    if (dataSnapshot.getKey().equals(keyProducto)){
                        Map<String, Object> dataChild = (Map<String, Object>) dataSnapshot.getValue();
                        informacion.setText(dataChild.get("Descripcion").toString());
                        Picasso.with(getApplicationContext()).load(dataChild.get("Imagen").toString()).into(imagenpro);

                        stockProducto=Integer.valueOf(dataChild.get("Stock").toString());
                        stock.setText("Stock: "+stockProducto);

                        nombreProducto=dataChild.get("Nombre").toString();
                        nomProduc.setText(nombreProducto);

                        precio=Double.valueOf(dataChild.get("Precio").toString());
                    }
                }
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                if (dataSnapshot.hasChildren()) {
                    if (dataSnapshot.getKey().equals(keyProducto)){
                        Map<String, Object> dataChild = (Map<String, Object>) dataSnapshot.getValue();
                        informacion.setText(dataChild.get("Descripcion").toString());
                        Picasso.with(getApplicationContext()).load(dataChild.get("Imagen").toString()).into(imagenpro);
                        stock.setText(dataChild.get("Stock").toString());
                        nomProduc.setText(dataChild.get("Nombre").toString());
                        precio=Double.valueOf(dataChild.get("Precio").toString());
                    }
                }
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