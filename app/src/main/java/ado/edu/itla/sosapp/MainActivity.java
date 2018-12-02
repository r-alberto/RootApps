package ado.edu.itla.sosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ado.edu.itla.sosapp.entidad.RegistrarseActivity;
import ado.edu.itla.sosapp.entidad.Usuario;
import ado.edu.itla.sosapp.repositorio.DbConexion;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorio;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorioimpl;


public class MainActivity extends AppCompatActivity {

DbConexion helper = new DbConexion(null);

UsuarioRepositorioimpl usuarioRepositorio;



         private static final String TAG = "SOSAPP.MAINACTIVITY";

        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Log.d(TAG, "Entrando al Main Activity");
            Log.e(TAG, "Esto es un error");

            TextView btnregistrarse = (TextView) findViewById(R.id.btnregistrarse);
            ImageView btnlogin = (ImageView) findViewById(R.id.btnlogin);

            final EditText etemail = (EditText) findViewById(R.id.etcorreologin);
            final EditText etpassword = (EditText) findViewById(R.id.etpasswordlogin);

            usuarioRepositorio = new UsuarioRepositorioimpl(this);

            btnregistrarse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                 Usuario usuario = usuarioRepositorio.buscar(etemail.getText().toString().trim());
                 if (usuario != null){
                     if (etpassword.getText().equals(usuario.getPassword())){
                         Toast.makeText(MainActivity.this, "Usuario y password correctos", Toast.LENGTH_SHORT).show();

                     }else {
                         Toast.makeText(MainActivity.this, "Usuario y password incorrectos", Toast.LENGTH_SHORT).show();
                     }

                 }else {
                     Toast.makeText(MainActivity.this, "El usuario no existe", Toast.LENGTH_SHORT).show();
                 }



                }
            });

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


