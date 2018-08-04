package ado.edu.itla.taskapp.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ado.edu.itla.taskapp.MainActivity;
import ado.edu.itla.taskapp.R;
import ado.edu.itla.taskapp.utils.SharedPreferenceManager;
import ado.edu.itla.taskapp.entidad.Usuario;
import ado.edu.itla.taskapp.repositorio.db.CategoriaRepositorioDBimp;


public class LoginActivity extends AppCompatActivity {

    private EditText etUser;
    private EditText etPassword;
    CategoriaRepositorioDBimp repositorioDBimp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        etUser = findViewById(R.id.etLogUser);
        etPassword = findViewById(R.id.etLogPassword);
        repositorioDBimp = new CategoriaRepositorioDBimp(this);

        SharedPreferenceManager sharedPreferenceManager = new SharedPreferenceManager(this);

        if (sharedPreferenceManager.isLoggedIn()){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            finish();
            startActivity(intent);
        }

        Button btnRegistrar = findViewById(R.id.btnRegistarse);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistrerActivity.class);
                startActivity(intent);
            }
        });

        Button btnLogin = findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(repositorioDBimp.login(etUser.getText().toString(),etPassword.getText().toString())){

                    Usuario usuario = repositorioDBimp.tipoUsuario(etUser.getText().toString());
                    SharedPreferenceManager sharedPreferenceManager = new SharedPreferenceManager(LoginActivity.this);
                    sharedPreferenceManager.userLogin(usuario.getEmail(),String.valueOf(usuario.getTipoUsuario()),usuario.getNombre());

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("usuario",usuario);
                    startActivity(intent);

                }else {Toast.makeText(LoginActivity.this,"Usuario Incorrecto",Toast.LENGTH_LONG).show();}
            }
        });
    }

}
