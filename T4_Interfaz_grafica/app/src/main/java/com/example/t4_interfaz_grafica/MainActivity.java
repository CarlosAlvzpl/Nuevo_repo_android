package com.example.t4_interfaz_grafica;

import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation;



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

        // 1. Inicializar Vistas
        Button boton1 = findViewById(R.id.button1);
        Button boton2 = findViewById(R.id.button2);
        Button boton3 = findViewById(R.id.button3);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Button buttonCheck = findViewById(R.id.buttonCheck);
        TextView textoResultado = findViewById(R.id.textoResultado);

        TextView textoView = findViewById(R.id.texto); // Antes llamado miTexto
        AutoCompleteTextView autoComplete = findViewById(R.id.miTexto); // Antes llamado textoLeido
        Spinner miSpinner = findViewById(R.id.miSpinner);


        // 2. Configurar el TextView (Color rojo, fuente monoespaciada y negrita)
        textoView.setText("Nuevo texto a mostrar");
        textoView.setTextColor(Color.RED);
        textoView.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
        textoView.setTextSize(24);

        // 3. Configurar AutoCompleteTextView
        String[] opciones = {"Opcion1", "Opcion2", "Opcion3", "Opcion4", "Opcion5"};
        ArrayAdapter<String> adaptadorAutoComplete = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, opciones);
        autoComplete.setAdapter(adaptadorAutoComplete);

        // 4. Configurar Spinner
        String[] valores = {"Star Wars", "Reservoir dogs", "El Club de la lucha", "Snatch: Cerdos y Diamantes"};
        ArrayAdapter<String> adaptadorSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, valores);
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Mejora visual
        miSpinner.setAdapter(adaptadorSpinner);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                System.out.println("Has seleccionado el valor:" + adapterView.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                System.out.println("No has seleccionado nada");
            }
        });

        // 5. Configurar Botones y Animaciones
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoView.clearAnimation(); // Detiene la animación
                textoView.setText("Se ha pulsado el boton de parar");
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoView.clearAnimation();
                Animation miAnimacion = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                miAnimacion.setRepeatCount(20);
                textoView.startAnimation(miAnimacion); // Aplica la animación al TextView
                textoView.setText("Se ha pulsado el boton de rotar");
            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoView.clearAnimation();
                Animation miAnimacionMover = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion);
                textoView.startAnimation(miAnimacionMover); // Aplica la animación al TextView
                textoView.setText("Se ha pulsado el boton de mover");
            }
        });


            // Listener para cambios en el CheckBox
            CheckBox checkBox1 = findViewById(R.id.checkbox1);
                checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        //código para seleccionado
                    } else {
                        //código para no seleccionado
                    }
                }


        });


        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el ID del RadioButton seleccionado
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // Verificar si algún RadioButton está seleccionado
                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedOption = selectedRadioButton.getText().toString();
                    textoResultado.setText("Seleccionado: " + selectedOption);
                } else {
                    // No se ha seleccionado ninguna opción
                    textoResultado.setText("No se ha seleccionado ninguna opción");
                }
            }
        });
    }
}