package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView text;
    double numero1;
    double numero2;
    String operacion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.gridlayoutcalculadora);

        text = findViewById(R.id.text);

        Button b0 = findViewById(R.id.b0);
        Button b1 = findViewById(R.id.b1);
        Button b2 = findViewById(R.id.b2);
        Button b3 = findViewById(R.id.b3);
        Button b4 = findViewById(R.id.b4);
        Button b5 = findViewById(R.id.b5);
        Button b6 = findViewById(R.id.b6);
        Button b7 = findViewById(R.id.b7);
        Button b8 = findViewById(R.id.b8);
        Button b9 = findViewById(R.id.b9);

        Button coma = findViewById(R.id.coma);
        Button sumar = findViewById(R.id.sumar);
        Button restar = findViewById(R.id.restar);
        Button multiplicar = findViewById(R.id.multiplicar);
        Button dividir = findViewById(R.id.dividir);
        Button igual = findViewById(R.id.igual);
        Button c = findViewById(R.id.c);
        Button ac = findViewById(R.id.ac);

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!text.getText().toString().equals("0")) {
                    text.setText(text.getText() + "0");
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("1");
                } else {
                    text.setText(text.getText() + "1");
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("2");
                } else {
                    text.setText(text.getText() + "2");
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("3");
                } else {
                    text.setText(text.getText() + "3");
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("4");
                } else {
                    text.setText(text.getText() + "4");
                }
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("5");
                } else {
                    text.setText(text.getText() + "5");
                }
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("6");
                } else {
                    text.setText(text.getText() + "6");
                }
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("7");
                } else {
                    text.setText(text.getText() + "7");
                }
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("8");
                } else {
                    text.setText(text.getText() + "8");
                }
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("0")) {
                    text.setText("9");
                } else {
                    text.setText(text.getText() + "9");
                }
            }
        });

        coma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!text.getText().toString().contains(",")) {
                    text.setText(text.getText() + ",");
                }
            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("0");
                operacion = "";
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pantalla = text.getText().toString();

                if (pantalla.length() > 1) {
                    text.setText(pantalla.substring(0, pantalla.length() - 1));
                } else {
                    text.setText("0");
                }
            }
        });

        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero1 = Double.parseDouble(text.getText().toString().replace(",", "."));
                operacion = "+";
                text.setText("0");
            }
        });

        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero1 = Double.parseDouble(text.getText().toString().replace(",", "."));
                operacion = "-";
                text.setText("0");
            }
        });

        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero1 = Double.parseDouble(text.getText().toString().replace(",", "."));
                operacion = "*";
                text.setText("0");
            }
        });

        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero1 = Double.parseDouble(text.getText().toString().replace(",", "."));
                operacion = "/";
                text.setText("0");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero2 = Double.parseDouble(text.getText().toString().replace(",", "."));

                double resultado = 0;

                if (operacion.equals("+")) {
                    resultado = numero1 + numero2;
                } else if (operacion.equals("-")) {
                    resultado = numero1 - numero2;
                } else if (operacion.equals("*")) {
                    resultado = numero1 * numero2;
                } else if (operacion.equals("/")) {
                    if (numero2 == 0) {
                        text.setText("Error");
                        return;
                    }
                    resultado = numero1 / numero2;
                }

                text.setText(String.valueOf(resultado).replace(".", ","));
                operacion = "";
            }
        });
    }
}
