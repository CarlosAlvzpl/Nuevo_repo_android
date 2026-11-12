package com.example.listadosymenus;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listaPaises;
    TextView txtPais;

    String paises[] = {
            "España",
            "Andorra",
            "Francia",
            "Monaco",
            "Portugal",
            "Bélgica",
            "Países Bajos",
            "Grecia",
            "Polonia",
            "Austria"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPaises = findViewById(R.id.listaPaises);
        txtPais = findViewById(R.id.txtPais);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paises);

        listaPaises.setAdapter(adaptador);

        listaPaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                txtPais.setText(paises[position]);

            }
        });
    }
}
