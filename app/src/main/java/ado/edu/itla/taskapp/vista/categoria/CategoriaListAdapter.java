package ado.edu.itla.taskapp.vista;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ado.edu.itla.taskapp.R;
import ado.edu.itla.taskapp.entidad.Categoria;

/**
 * Created by MESCyT on 23/6/2018.
 */

public class CategoriaListAdapter extends BaseAdapter {

    private Context mCtx;
    private List<Categoria> mList;
    public CategoriaListAdapter(Context mCtx,List<Categoria> mList) {
        this.mCtx = mCtx;
        this.mList = mList;

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(mCtx);
            view = inflater.inflate(R.layout.categoria_listview_row,null);
        }

        TextView tvCategoriaId = view.findViewById(R.id.tvListCatId);
        TextView tvCategoria = view.findViewById(R.id.tvListCategoria);

        Categoria cat  = mList.get(i);

        tvCategoriaId.setText(cat.getId().toString());
        tvCategoria.setText(cat.getNombre().toString().toUpperCase());


        return view;
    }
}
