package com.jhonnatan.ajedrez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class configuracion extends AppCompatActivity {

    //Declaración de variables
    Button caso1;
    Button caso2;
    Button caso3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        //Declaramos instancias
        caso1 = (Button)findViewById(R.id.btnCaso1);
        caso2 = (Button)findViewById(R.id.btnCaso2);
        caso3 = (Button)findViewById(R.id.btnCaso3);

        //Definimos la funcion del boton CASO 1
        caso1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cambiamos de pantalla a registrate
                Intent intent = new Intent(configuracion.this, caso1.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);
                finish();
            }
        });

        //Definimos la funcion del boton CASO 2
        caso2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cambiamos de pantalla a registrate
                Intent intent = new Intent(configuracion.this, caso2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);
                finish();
            }
        });

        //Definimos la funcion del boton CASO 3
        caso3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cambiamos de pantalla a registrate
                Intent intent = new Intent(configuracion.this, caso3.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);
                finish();
            }
        });
    }

    //Configuración del boton de atras
    @Override public void onBackPressed() {
        Intent intent = new Intent(configuracion.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
        finish();
    }
}