package com.example.camk1.app_tienda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by hola on 27/11/2016.
 */

public class FacturaActicity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView fecha=(TextView)findViewById(R.id.fecha);
        TextView nombreCliente=(TextView)findViewById(R.id.nombreC);
        TextView nitcliente=(TextView)findViewById(R.id.nitC);
        TextView cantidad=(TextView)findViewById(R.id.cantidad);
        TextView descripcion=(TextView)findViewById(R.id.descripcion);
        TextView unit=(TextView)findViewById(R.id.unit);
        TextView importe=(TextView)findViewById(R.id.importe);
        TextView total=(TextView)findViewById(R.id.total);



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
