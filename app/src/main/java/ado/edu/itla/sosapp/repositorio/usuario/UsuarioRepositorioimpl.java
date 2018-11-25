package ado.edu.itla.sosapp.repositorio.usuario;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.DbConexion;

public class UsuarioRepositorioimpl implements UsuarioRepositorio {

    private DbConexion dbConexion;

    public UsuarioRepositorioimpl(Context context) {
        this.dbConexion = new DbConexion(this, "db", context, 1);
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
        return null;
    }
}
