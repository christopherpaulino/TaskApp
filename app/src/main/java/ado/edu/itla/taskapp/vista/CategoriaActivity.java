package ado.edu.itla.taskapp.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ado.edu.itla.taskapp.R;
import ado.edu.itla.taskapp.entidad.Categoria;
import ado.edu.itla.taskapp.entidad.Tarea;
import ado.edu.itla.taskapp.repositorio.db.CategoriaRepositorioDBimp;

public class CategoriaActivity extends AppCompatActivity {

    private static final String TAG = CategoriaActivity.class.getSimpleName();
    private CategoriaRepositorioDBimp categoriaRepositorioDBimp;
    private Categoria categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        categoriaRepositorioDBimp = new CategoriaRepositorioDBimp(this);

        Bundle bundle = getIntent().getExtras();


        final Button mButton  = findViewById(R.id.btnRegCat);
        final EditText etCategoria = findViewById(R.id.etRegCat);

        if (bundle!=null && bundle.containsKey("categoria")){
             categoria = (Categoria) bundle.getSerializable("categoria");
            mButton.setText("Actualizar");
            etCategoria.setText(categoria.getNombre());

        }
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (categoria == null){
                    categoria = new Categoria();
                }
                categoria.setNombre(etCategoria.getText().toString());
                categoriaRepositorioDBimp.guardar(categoria);

                Intent intent = new Intent(CategoriaActivity.this,CategoriaListaActivity.class);
                startActivity(intent);


            }
        });
    }
}
