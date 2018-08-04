package ado.edu.itla.taskapp.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import ado.edu.itla.taskapp.MainActivity;
import ado.edu.itla.taskapp.R;
import ado.edu.itla.taskapp.utils.SharedPreferenceManager;
import ado.edu.itla.taskapp.entidad.Usuario;
import ado.edu.itla.taskapp.repositorio.db.CategoriaRepositorioDBimp;

public class RegistrerActivity extends AppCompatActivity {


    private Button btnCancelar;
    private Button btnRegistrar;
    private EditText etNombre, etUsuario, etPassword, etConfirmarPassword;
    private RadioGroup rgTipo;
    private Usuario usuario;
    private Usuario.TipoUsuario tipoUsuario;
    private CategoriaRepositorioDBimp repositorioDBimp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrer);

        repositorioDBimp =  new CategoriaRepositorioDBimp(this);

        btnCancelar = findViewById(R.id.btnRegUsuCancelar);
        btnRegistrar = findViewById(R.id.btnRegUsuario);
        etNombre = findViewById(R.id.etRegUsuNombre);
        etUsuario = findViewById(R.id.etRegEmail);
        etPassword = findViewById(R.id.etRegUsuPassword);
        etConfirmarPassword = findViewById(R.id.etRegUsuConfirmar);



        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        rgTipo = findViewById(R.id.rgTipo);
        rgTipo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int id = group.getCheckedRadioButtonId();
                switch (id){
                    case R.id.rbNormal:
                        tipoUsuario = Usuario.TipoUsuario.NORMAL;
                        break;
                    case R.id.rbTecnico:
                        tipoUsuario = Usuario.TipoUsuario.TECNICO;
                        break;
                }
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (repositorioDBimp.comprobarUsuario(etUsuario.getText().toString())){
                    etUsuario.setError("Usuario No Disponible");
                    etUsuario.requestFocus();

                }else{

                if (repositorioDBimp.comprobarPassword(etPassword.getText().toString(),etConfirmarPassword.getText().toString())){
                    etConfirmarPassword.setError("Contraseñas No Coinciden");
                    etConfirmarPassword.requestFocus();
                }else {
                    usuario = new Usuario();
                    usuario.setNombre(etNombre.getText().toString());
                    usuario.setEmail(etUsuario.getText().toString());
                    usuario.setTipoUsuario(tipoUsuario);
                    usuario.setPassword(etPassword.getText().toString());

                    repositorioDBimp.guardar(usuario);

                    SharedPreferenceManager sharedPreferenceManager = new SharedPreferenceManager(RegistrerActivity.this);

                    if (sharedPreferenceManager.isLoggedIn()){
                        Intent intent = new Intent(RegistrerActivity.this, MainActivity.class);
                        Toast.makeText(RegistrerActivity.this,"Usuario Registrado",Toast.LENGTH_LONG).show();
                        finish();
                        startActivity(intent);
                    }else {
                    onBackPressed();}
                }
                }

            }
        });

    }
}
