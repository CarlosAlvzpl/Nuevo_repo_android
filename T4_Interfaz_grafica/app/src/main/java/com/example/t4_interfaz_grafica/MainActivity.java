package com.example.t4_interfaz_grafica;

import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }


    @Override
    protected void onStart(){
        super.onStart();

        Button boton1 = findViewById(R.id.button1);
        Button boton2 = findViewById(R.id.button2);
        Button boton3 = findViewById(R.id.button3);

        TextView texto = findViewById(R.id.texto);
        TextView miTexto = (TextView) findViewById(R.id.texto);
        miTexto.setText("Nuevo texto a mostrar");

        //Opcion 1 para cambiar el color.
        miTexto.setTextColor(Color.parseColor("#0000FF"));

        // Opcion 2 para cambiar el color.
        miTexto.setTextColor(Color.RED);

        // Cambio del Texto a Negrita
        miTexto.setTypeface((Typeface) null, Typeface.ITALIC);

        // Cambio el tamaño del texto
        miTexto.setTextSize(24);



        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miTexto.clearAnimation();
                texto.setText("Se ha pulsado el boton de parar");
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miTexto.clearAnimation();
                Animation miAnimacion = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                miAnimacion.setRepeatCount(20);
                miTexto.startAnimation(miAnimacion);
                texto.setText("Se ha pulsado el boton de rotar");
            }
        });


        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miTexto.clearAnimation();
                Animation miAnimacionMover = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion);
                miTexto.startAnimation(miAnimacionMover);
                texto.setText("Se ha pulsado el boton de mover");
            }
        });
    }


}