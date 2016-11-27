package com.example.camk1.app_tienda;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class DialogoConfirmacion extends DialogFragment {

    public boolean volverCargar = false;
    private DialogInterface.OnDismissListener onDismissListener;

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

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volverCargar = true;
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
