package ado.edu.itla.sosapp.repositorio.usuario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.DbConexion;

public class UsuarioRepositorioimpl implements UsuarioRepositorio {

    private DbConexion dbConexion;

    public UsuarioRepositorioimpl(Context context) {
        this.dbConexion = new DbConexion(context);
    }

    @Override
    public void guardar(Usuario usuario) {

        ContentValues cv = new ContentValues();
        cv.put("email", usuario.getEmail());
        cv.put("password", usuario.getPassword());
        cv.put("nombre", usuario.getNombre());

        //TODO: guardad usuario

        SQLiteDatabase db = dbConexion.getWritableDatabase();
        Long id = db.insert("usuario", null, cv);
        usuario.setId(id.intValue());



    }

    @Override
    public Usuario buscar(String email) {

        SQLiteDatabase db = dbConexion.getReadableDatabase();
        Cursor cursor = null;
        Usuario usuario = null;
        String nombre ="";
        try {
            cursor = db.query("usurio",null,"email=?", new String[] {email}, null,null,null);

            if (cursor .moveToNext()){
                nombre =
                        cursor.getString(cursor.getColumnIndex(email));
                usuario = new Usuario();

                usuario.setId(cursor.getInt(cursor.getColumnIndex("id")));
                usuario.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                usuario.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                usuario.setEmail(cursor.getString(cursor.getColumnIndex("email")));

                cursor.close();
            }
        }
        catch (Exception e){}

        return null;
    }
}
