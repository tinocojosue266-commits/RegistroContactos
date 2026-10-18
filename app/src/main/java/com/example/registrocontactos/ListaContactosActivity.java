
package com.example.registrocontactos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListaContactosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contactos);

        Log.d("CICLO_VIDA", "ListaContactosActivity: onCreate");

        RecyclerView rvContactos = findViewById(R.id.rv_contactos);
        Button btnNuevo = findViewById(R.id.btn_nuevo_contacto);

        rvContactos.setLayoutManager(new LinearLayoutManager(this));
        rvContactos.setAdapter(
                new ContactoAdapter(ConfirmacionActivity.contactos));

        btnNuevo.setOnClickListener(v -> {
            Intent intent = new Intent(
                    ListaContactosActivity.this,
                    MainActivity.class
            );
            startActivity(intent);
            finish();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CICLO_VIDA", "ListaContactosActivity: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CICLO_VIDA", "ListaContactosActivity: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CICLO_VIDA", "ListaContactosActivity: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CICLO_VIDA", "ListaContactosActivity: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CICLO_VIDA", "ListaContactosActivity: onDestroy");
    }
}
