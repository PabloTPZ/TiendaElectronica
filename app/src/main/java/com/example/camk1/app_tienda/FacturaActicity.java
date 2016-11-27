package com.example.camk1.app_tienda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by hola on 27/11/2016.
 */

public class FacturaActicity extends AppCompatActivity {
    String nombreCli="";
    String nitCli="";
    String cnatidad="";
    String nombrep="";
    String impor="";
    String precio="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView fecha=(TextView)findViewById(R.id.fecha);
        Date d = new Date();
        CharSequence s  = DateFormat.format("MMMM d, yyyy ", d.getTime());

        TextView nombreCliente=(TextView)findViewById(R.id.nombreC);
        TextView nitcliente=(TextView)findViewById(R.id.nitC);
        TextView cantidad=(TextView)findViewById(R.id.cantidad);
        TextView descripcion=(TextView)findViewById(R.id.descripcion);
        TextView unit=(TextView)findViewById(R.id.unit);
        TextView importe=(TextView)findViewById(R.id.importe);
        TextView total=(TextView)findViewById(R.id.total);
        Intent intent = getIntent();
        nombreCli = intent.getStringExtra("nombreCliente");
        nitCli = intent.getStringExtra("nitCliente");
        cnatidad = intent.getStringExtra("cantidad");
        nombrep = intent.getStringExtra("nombrep");
        impor = intent.getStringExtra("importe");
        precio=intent.getStringExtra("precio");
        nombreCliente.setText(nombreCli);
        nitcliente.setText(nitCli);
        cantidad.setText(cnatidad);
        descripcion.setText(nombrep);
        importe.setText(impor);
        unit.setText(precio);
        fecha.setText(String.valueOf(s));


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
