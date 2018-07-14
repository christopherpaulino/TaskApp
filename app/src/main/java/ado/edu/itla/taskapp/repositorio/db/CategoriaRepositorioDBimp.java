package ado.edu.itla.taskapp.repositorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ado.edu.itla.taskapp.entidad.Usuario;
import ado.edu.itla.taskapp.repositorio.CategoriaRepositorio;
import ado.edu.itla.taskapp.entidad.Categoria;
import ado.edu.itla.taskapp.repositorio.UsuarioRepositorio;


public class CategoriaRepositorioDBimp implements CategoriaRepositorio, UsuarioRepositorio{


    private ConexionDB conexionDB;
    public static final String TABLA_USUARIO = "usuario";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_EMAIL = "email";
    public static final String CAMPO_TIPO = "tipo";
    public static final String CAMPO_PASSWORD = "password";
    public static final String TABLA_CATEGORIA = "categoria";

    public CategoriaRepositorioDBimp(Context context) {

        conexionDB = new ConexionDB(context);
    }

    @Override
    public boolean guardar(Usuario usuario) {

        ContentValues cv  = new ContentValues();
        cv.put(CAMPO_NOMBRE, usuario.getNombre());
        cv.put(CAMPO_EMAIL, usuario.getEmail());
        cv.put(CAMPO_TIPO, String.valueOf(usuario.getTipoUsuario()));
        cv.put(CAMPO_PASSWORD, usuario.getPassword());


        SQLiteDatabase db = conexionDB.getWritableDatabase();
        Long id = db.insert(TABLA_USUARIO,null,cv);

        db.close();
        if (id.intValue() >0 ){
            usuario.setId(id.intValue());
            return true;
        }

        return false;
    }

    @Override
    public Usuario buscarUsuario(int id) {
        return null;
    }

    @Override
    public Usuario buscarUsuario(String username) {
        return null;
    }

    @Override
    public List<Usuario> buscarTecnicos() {


        return null;
    }

    @Override
    public boolean guardar(Categoria categoria) {

        if (categoria.getId()!= null && categoria.getId()>0){
            return actualizar(categoria);
        }

        ContentValues cv  = new ContentValues();
        cv.put(CAMPO_NOMBRE, categoria.getNombre());

        SQLiteDatabase db = conexionDB.getWritableDatabase();
        Long id = db.insert(TABLA_CATEGORIA,null,cv);

            db.close();
        if (id.intValue() >0 ){
            categoria.setId(id.intValue());
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizar(Categoria categoria) {

        Log.e("Categoria Update",categoria.toString());
        ContentValues cv  = new ContentValues();
        cv.put(CAMPO_NOMBRE, categoria.getNombre());

        SQLiteDatabase db = conexionDB.getWritableDatabase();
       int cantidad =  db.update(TABLA_CATEGORIA,cv,"id = ?",new String[]{categoria.getId().toString()});

        db.close();

        return cantidad > 0;
    }

    @Override
    public Categoria buscar(int id) {
        return null;
    }

    @Override
    public List<Categoria> buscar(String buscar) {

        //TODO: buscar  las cate

        List<Categoria> categorias = new ArrayList();

        SQLiteDatabase db = conexionDB.getReadableDatabase();
        String[] columnas = {"id",CAMPO_NOMBRE};

       Cursor cr =  db.query(TABLA_CATEGORIA,columnas,null,null,null,null,null);

       cr.moveToFirst();

       while(!cr.isAfterLast()){
           int id = cr.getInt(0);
           String nombre = cr.getString(1);

          /* Categoria c = new Categoria();
           .setId(id);
           .setNombre(nombre);*/


           categorias.add(new Categoria(id,nombre));

           cr.moveToNext();

       }
       cr.close();
       db.close();


        return categorias;
    }
}
