package ado.edu.itla.taskapp.vista;

import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ado.edu.itla.taskapp.R;
import ado.edu.itla.taskapp.utils.SharedPreferenceManager;

/**
 * Created by MESCyT on 21/7/2018.
 */


public class CuentaDialog  extends DialogFragment{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.cuenta_dialog,null);

        TextView cuenta = v.findViewById(R.id.tvCuentaUsuario);
        TextView tipo = v.findViewById(R.id.tvCuentatipo);
        SharedPreferenceManager spm = new SharedPreferenceManager(getContext());
        cuenta.setText(spm.getNombre());
        tipo.setText(spm.getTipo());
        return v;
    }
}
