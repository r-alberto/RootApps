package ado.edu.itla.sosapp.repositorio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ado.edu.itla.sosapp.MainActivity;

public class DbConexion extends SQLiteOpenHelper {

    private static String NOMBRE_BASEDATOS = "sosapp.db";
    private static int VERSION_BASEDATOS = 1;

    private static String TABLA_USUARIO = "CREATE TABLE `usuario` (" +
            "`id`INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "`nombre`TEXT NOT NULL," +
            "`password`TEXT NOT NULL," +
            "`email`TEXT NOT NULL" +
            ")";

    public DbConexion(MainActivity mainActivity, String db, Context context, int i) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_USUARIO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
