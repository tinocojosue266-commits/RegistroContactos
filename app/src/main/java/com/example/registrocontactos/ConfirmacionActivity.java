
package com.example.registrocontactos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ConfirmacionActivity extends AppCompatActivity {

    public static final ArrayList<String> contactos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        Log.d("CICLO_VIDA", "ConfirmacionActivity: onCreate");

        String nombre = getIntent().getStringExtra("nombre");
        String correo = getIntent().getStringExtra("correo");
        String telefono = getIntent().getStringExtra("telefono");
        String tipo = getIntent().getStringExtra("tipo");

        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvCorreo = findViewById(R.id.tvCorreo);
        TextView tvTelefono = findViewById(R.id.tvTelefono);
        TextView tvTipo = findViewById(R.id.tvTipo);

        tvNombre.setText("Nombre: " + nombre);
        tvCorreo.setText("Correo: " + correo);
        tvTelefono.setText("Teléfono: " + telefono);
        tvTipo.setText("Tipo: " + tipo);

        Button btnVolver = findViewById(R.id.btnVolver);
        Button btnConfirmar = findViewById(R.id.btnConfirmar);

        btnVolver.setOnClickListener(v -> finish());

        btnConfirmar.setOnClickListener(v -> {
            String contacto = nombre + " | " + correo + " | "
                    + telefono + " | " + tipo;

            contactos.add(contacto);

            Toast.makeText(this, "Contacto agregado",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(
                    ConfirmacionActivity.this, ListaContactosActivity.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CICLO_VIDA", "ConfirmacionActivity: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CICLO_VIDA", "ConfirmacionActivity: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CICLO_VIDA", "ConfirmacionActivity: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CICLO_VIDA", "ConfirmacionActivity: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CICLO_VIDA", "ConfirmacionActivity: onDestroy");
    }
}
