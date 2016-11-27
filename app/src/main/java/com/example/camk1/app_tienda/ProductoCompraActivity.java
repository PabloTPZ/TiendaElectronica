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
import android.widget.TextView;

/**
 * Created by hola on 27/11/2016.
 */

public class ProductoCompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra_producto);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageButton compra=(ImageButton)findViewById(R.id.carrito);
        TextView informacion=(TextView)findViewById(R.id.infoPro);
        TextView stock = (TextView) findViewById(R.id.stock);
        EditText cantidad=(EditText) findViewById(R.id.cantidad);
        compra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                final DialogoConfirmacion dialogo = new DialogoConfirmacion();
                dialogo.show(fragmentManager, "tagAlerta");
                dialogo.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        if (dialogo.isVolverCargar()) {
                            onStart();
                        }
                    }
                });
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
}
