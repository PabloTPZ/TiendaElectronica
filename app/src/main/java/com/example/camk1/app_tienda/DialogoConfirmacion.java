package com.example.camk1.app_tienda;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DialogoConfirmacion extends DialogFragment {

    public boolean volverCargar = false;
    private DialogInterface.OnDismissListener onDismissListener;
    String cantidad="";
    String nombre="";
    String precio="";
    String impt="";

    String cnatidadp="";
    String imporp="";
    String preciop="";
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        //llama a la actividad dlientedialogo.xml
        LayoutInflater infrater = getActivity().getLayoutInflater();
        View view = infrater.inflate(R.layout.dialogo_confirmacion, null);
        builder.setView(view);
        ImageButton cargar = (ImageButton) view.findViewById(R.id.aceptarCompra);
        Button agregar=(Button)view.findViewById(R.id.agregarMas);

        Bundle mBundle = new Bundle();
        mBundle = getArguments();
        cantidad= mBundle.getString("cantidad", "");
        nombre= mBundle.getString("nombreProd", "");
        precio=mBundle.getString("precio", "");
        impt=mBundle.getString("imporp", "");

        cnatidadp = mBundle.getString("cantidadp");
        imporp = mBundle.getString("imporp");
        preciop=mBundle.getString("preciop");

        if(cnatidadp==null){
            cnatidadp="";
            imporp="";
            preciop="";
        }
        TextView cant=(TextView)view.findViewById(R.id.total);
        TextView compraactual=(TextView)view.findViewById(R.id.compraactual);
        cant.setText(String.valueOf(Integer.parseInt(cantidad)*Integer.parseInt(precio)));
        compraactual.setText("SU COMPRA ACTUAL ES: \n"+nombre);
        final TextView nombrecli=(TextView)view.findViewById(R.id.nombre);
        final TextView nit=(TextView)view.findViewById(R.id.nit);

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FacturaActicity.class);
                intent.putExtra("nombreCliente",nombrecli.getText().toString());
                intent.putExtra("nitCliente",nit.getText().toString());
                intent.putExtra("cantidad",cantidad);
                intent.putExtra("precio",precio);
                intent.putExtra("nombrep",nombre);
                intent.putExtra("importe",String.valueOf(Integer.parseInt(cantidad)*Integer.parseInt(precio)));

                intent.putExtra("cnatidadp",cnatidadp);
                intent.putExtra("imporp",imporp);
                intent.putExtra("preciop",preciop);
                getActivity().startActivity(intent);
                getActivity().finish();
                dismiss();
            }
        });
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ProductoActivity.class);
                intent.putExtra("cantidad",cantidad);
                intent.putExtra("precio",precio);
                intent.putExtra("nombrep",nombre);
                intent.putExtra("importe",String.valueOf(Integer.parseInt(cantidad)*Integer.parseInt(precio)));
                getActivity().startActivity(intent);
                getActivity().finish();
                dismiss();
            }
        });
        return builder.create();
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
    }

    public boolean isVolverCargar() {
        return volverCargar;
    }
}
