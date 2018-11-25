package ado.edu.itla.sosapp.entidad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import ado.edu.itla.sosapp.MainActivity;
import ado.edu.itla.sosapp.R;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorio;
import ado.edu.itla.sosapp.repositorio.usuario.UsuarioRepositorioimpl;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegistrarseActivity extends AppCompatActivity {
    private static String TAG = "REGISTRO_USUARIO";
    UsuarioRepositorio usuarioRepositorio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        usuarioRepositorio = new UsuarioRepositorioimpl(this);



        final EditText emailText = findViewById(R.id.registrar_email);
        final EditText nombreText = findViewById(R.id.registrar_nombre);
        final EditText passwordText = findViewById(R.id.registrar_password);
        final EditText password2Text = findViewById(R.id.registrar_password2);
        ImageView bguardar = findViewById(R.id.registrar_guardar);

        ImageView bcancelar = (ImageView) findViewById(R.id.r_cancelar);

        bcancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent login = new Intent(RegistrarseActivity.this, MainActivity.class);
                startActivity(login);
            }
        });

        bguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = new Usuario();
                usuario.setNombre(nombreText.getText().toString());
                usuario.setEmail(emailText.getText().toString());
                usuario.setPassword(passwordText.getText().toString());


                        if(emailText.getText().toString().trim().isEmpty()
                        || nombreText.getText().toString().trim().isEmpty()
                        || passwordText.getText().toString().trim().isEmpty()
                        || password2Text.getText().toString().trim().isEmpty()){

                    //falta algún valor.
                            // Alerta de usuario creado
                            Toast.makeText(RegistrarseActivity.this, "HAY CAMPOS VACÍOS", Toast.LENGTH_SHORT).show();

                }else{

                            Toast.makeText(RegistrarseActivity.this, "USUARIO CREADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
                        //Limpiar los edits
                        nombreText.setText("");
                        emailText.setText("");
                        passwordText.setText("");
                        password2Text.setText("");
                    }


                    //Alerta de usuario creado


                    Log.i(TAG, usuario.toString());
                    usuarioRepositorio.guardar(usuario);
                    Log.i(TAG, usuario.toString());


                }
             });


    }

}



