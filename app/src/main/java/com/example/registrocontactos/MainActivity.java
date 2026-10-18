
package com.example.registrocontactos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre, etCorreo, etTelefono;
    private RadioGroup rgTipoContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("CICLO_VIDA", "MainActivity: onCreate");

        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etTelefono = findViewById(R.id.etTelefono);
        rgTipoContacto = findViewById(R.id.rgTipoContacto);
        Button btnContinuar = findViewById(R.id.btnContinuar);

        btnContinuar.setOnClickListener(v -> validarFormulario());
    }

    private void validarFormulario() {
        String nombre = etNombre.getText().toString().trim();
        String correo = etCorreo.getText().toString().trim();
        String telefono = etTelefono.getText().toString().trim();

        if (nombre.isEmpty()) {
            etNombre.setError("Ingresa el nombre");
            etNombre.requestFocus();
            return;
        }

        if (correo.isEmpty()) {
            etCorreo.setError("Ingresa el correo");
            etCorreo.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            etCorreo.setError("Ingresa un correo válido");
            etCorreo.requestFocus();
            return;
        }

        if (telefono.isEmpty()) {
            etTelefono.setError("Ingresa el teléfono");
            etTelefono.requestFocus();
            return;
        }

        if (!telefono.matches("[0-9]{8}")) {
            etTelefono.setError("El teléfono debe tener 8 dígitos");
            etTelefono.requestFocus();
            return;
        }

        int seleccionado = rgTipoContacto.getCheckedRadioButtonId();

        if (seleccionado == -1) {
            return;
        }

        String tipo = seleccionado == R.id.rbPersonal
                ? "Personal" : "Trabajo";

        Intent intent = new Intent(MainActivity.this,
                ConfirmacionActivity.class);

        intent.putExtra("nombre", nombre);
        intent.putExtra("correo", correo);
        intent.putExtra("telefono", telefono);
        intent.putExtra("tipo", tipo);

        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CICLO_VIDA", "MainActivity: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CICLO_VIDA", "MainActivity: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CICLO_VIDA", "MainActivity: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CICLO_VIDA", "MainActivity: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CICLO_VIDA", "MainActivity: onDestroy");
    }
}
