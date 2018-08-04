package ado.edu.itla.taskapp;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import ado.edu.itla.taskapp.utils.SharedPreferenceManager;
import ado.edu.itla.taskapp.entidad.Categoria;
import ado.edu.itla.taskapp.vista.CategoriaListaActivity;
import ado.edu.itla.taskapp.vista.CuentaDialog;
import ado.edu.itla.taskapp.vista.LoginActivity;
import ado.edu.itla.taskapp.vista.RegistrerActivity;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.user_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.navCerrar:
                SharedPreferenceManager sharedPreferenceManager = new SharedPreferenceManager(MainActivity.this);
                sharedPreferenceManager.logout();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                finish();
                startActivity(intent);
                break;

            case R.id.navReg :
                Intent regIntent = new Intent(MainActivity.this, RegistrerActivity.class);
                finish();
                startActivity(regIntent);
                break;

            case R.id.navCuenta:
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                DialogFragment dialogFragment = new CuentaDialog();
                dialogFragment.show(ft, "dialog");
                break;
        }



        return true;
    }
}
