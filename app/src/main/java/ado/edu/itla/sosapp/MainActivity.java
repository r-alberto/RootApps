package ado.edu.itla.sosapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ado.edu.itla.sosapp.entidad.RegistrarseActivity;
import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.DbConexion;


public class MainActivity extends AppCompatActivity {

DbConexion helper = new DbConexion(this,"db",null,1);




      /*     Button btnBotton = (Button) findViewById(R.id.button);
        btnBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario usuario = new Usuario();
                try {
                    usuario.setEdad(-12);
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Edad no permitida.", Toast.LENGTH_LONG).show();
                }

            }
        });*/

         private static final String TAG = "SOSAPP.MAINACTIVITY";

        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Log.d(TAG, "Entrando al Main Activity");
            Log.e(TAG, "Esto es un error");

            TextView btnregistrarse = (TextView) findViewById(R.id.btnregistrarse);
            ImageView btnlogin;


            btnregistrarse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent registrarse = new Intent(MainActivity.this, RegistrarseActivity.class);
                    startActivity(registrarse);

                }
            });


            Usuario usuario = new Usuario();
            usuario.setEmail("r_alberto@outlook.com");
            usuario.setNombre("Reynaldo Alberto");
            usuario.setUsername("r_alberto");

            Usuario usuario1 = new Usuario();
            usuario1.setEmail("r_alberto@outlook.com");
            usuario1.setNombre("Reynaldo Alberto");
            usuario1.setUsername("r_alberto");


            List<Usuario> usuarioList = new ArrayList<>();
            usuarioList.add(usuario);
            usuarioList.add(usuario1);

            Log.i(TAG, "Tamaño de la lista: " + usuarioList.size());

            for (Usuario u : usuarioList) {
                Log.i(TAG, "Nombre: " + u.getNombre());
            }


            btnlogin = (ImageView) findViewById(R.id.btnlogin);
            btnlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText  etcorreologin = (EditText) findViewById(R.id.etcorreologin);
                    EditText  etpasswordlogin = (EditText) findViewById(R.id.etpasswordlogin);






                }
            });

    }
}


