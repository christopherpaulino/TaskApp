package ado.edu.itla.taskapp.vista;

import android.annotation.TargetApi;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import ado.edu.itla.taskapp.R;
import ado.edu.itla.taskapp.entidad.Categoria;
import ado.edu.itla.taskapp.repositorio.CategoriaRepositorio;
import ado.edu.itla.taskapp.repositorio.db.CategoriaRepositorioDBimp;

public class CategoriaListaActivity extends AppCompatActivity {

    private CategoriaRepositorio categoriaRepositorio;
    private final String TAG = CategoriaListaActivity.class.getSimpleName();
    private  CategoriaListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_lista);


        Log.d(TAG,"OnCreate");
        ListView mListView = findViewById(R.id.lvCategorias);
        categoriaRepositorio = new CategoriaRepositorioDBimp(this);
        List<Categoria> categorias = categoriaRepositorio.buscar("");
        Log.d(TAG,"Total de Categorias"+ categorias.size());
        mAdapter = new CategoriaListAdapter(this,categorias);
        mListView.setAdapter(mAdapter );

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Categoria cat = (Categoria) adapterView.getItemAtPosition(i);

                Intent regCatIntent = new Intent(CategoriaListaActivity.this,CategoriaActivity.class);
                regCatIntent.putExtra("categoria",cat);

                startActivity(regCatIntent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }
}
