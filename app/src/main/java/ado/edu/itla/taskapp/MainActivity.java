package ado.edu.itla.taskapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ado.edu.itla.taskapp.entidad.Categoria;
import ado.edu.itla.taskapp.vista.CategoriaActivity;
import ado.edu.itla.taskapp.vista.CategoriaListaActivity;
import ado.edu.itla.taskapp.vista.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Categoria cat  = new Categoria();
        cat.setNombre("Categoria 1 Redes");



        Button mBtnCategoria =  findViewById(R.id.btnCategoria);

        mBtnCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent  = new Intent(MainActivity.this,LoginActivity.class);
               intent.putExtra("cat",cat.getNombre());
               startActivity(intent);

            }
        });
        Button mBtnListaCategoria =  findViewById(R.id.btnListaCategoria);

        mBtnListaCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivity.this,CategoriaListaActivity.class);
                startActivity(intent);

            }
        });

    }
}
