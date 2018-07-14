package ado.edu.itla.taskapp.repositorio.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class ConexionDB extends SQLiteOpenHelper {

    private static final String TAG = "ConexionDB";

    private static final String NOMBRE_DB = "taskapp.db";
    private static final int VERSION_DB = 1;


    //constructor de conexionDB
    public ConexionDB(Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Log.i(TAG,"Creando la tabla");
        sqLiteDatabase.execSQL(EstructuraDB.TABLA_CATEGORIA);
        sqLiteDatabase.execSQL(EstructuraDB.TABLA_USUARIO);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
