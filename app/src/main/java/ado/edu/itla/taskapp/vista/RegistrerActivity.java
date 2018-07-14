package ado.edu.itla.taskapp.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ado.edu.itla.taskapp.R;

public class RegistrerActivity extends AppCompatActivity {


    private Button btnCancelar;
    private Button btnRegistrar;
    private EditText etNombre;
    private EditText etEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrer);

        btnCancelar = findViewById(R.id.btnRegUsuCancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}
