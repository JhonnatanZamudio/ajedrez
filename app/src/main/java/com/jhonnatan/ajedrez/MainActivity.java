package com.jhonnatan.ajedrez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Declaración de variables
    Button comenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaramos instancias
        comenzar = (Button)findViewById(R.id.btnComenzar);

        //Definimos la funcion del boton Comenzar
        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cambiamos de pantalla a registrate
                Intent intent = new Intent(MainActivity.this, configuracion.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);
                finish();
            }
        });
    }

    //Desactivamos el boton de atras
    @Override public void onBackPressed() { }
}