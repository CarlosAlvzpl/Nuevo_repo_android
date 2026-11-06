package com.example.gestioncuentabar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etTotal;
    private AutoCompleteTextView actvCamarero;
    private CheckBox cbPropina;
    private SeekBar seekBar;
    private TextView tvPorcentaje;
    private RadioGroup rgPago;
    private RatingBar ratingBar;
    private Button btnCalcular;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTotal       = findViewById(R.id.etTotal);
        actvCamarero  = findViewById(R.id.actvCamarero);
        cbPropina     = findViewById(R.id.cbPropina);
        seekBar       = findViewById(R.id.seekBar);
        tvPorcentaje  = findViewById(R.id.tvPorcentaje);
        rgPago        = findViewById(R.id.rgPago);
        ratingBar     = findViewById(R.id.ratingBar);
        btnCalcular   = findViewById(R.id.btnCalcular);
        tvResultado   = findViewById(R.id.tvResultado);

        String[] camareros = getResources().getStringArray(R.array.lista_camareros);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                camareros);
        actvCamarero.setAdapter(adapter);
        actvCamarero.setThreshold(3);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvPorcentaje.setText(getString(R.string.propina_texto, progress));
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        cbPropina.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                seekBar.setEnabled(isChecked);
                tvPorcentaje.setEnabled(isChecked);
            }
        });
        seekBar.setEnabled(cbPropina.isChecked());
        tvPorcentaje.setEnabled(cbPropina.isChecked());

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTotal();
            }
        });
    }

    private void calcularTotal() {
        String texto = etTotal.getText().toString().trim();
        if (texto.isEmpty()) {
            mostrarError(getString(R.string.error_vacio));
            return;
        }

        double total;
        try {
            total = Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            mostrarError(getString(R.string.error_formato));
            return;
        }

        if (total <= 0) {
            mostrarError(getString(R.string.error_minimo));
            return;
        }

        String camarero = actvCamarero.getText().toString().trim();
        if (camarero.length() < 3) {
            mostrarError(getString(R.string.error_camarero));
            return;
        }

        int porcentaje = 0;
        if (cbPropina.isChecked()) {
            porcentaje = seekBar.getProgress();
        }
        double propina    = total * porcentaje / 100.0;
        double totalFinal = total + propina;

        String metodo = getString(R.string.efectivo);
        if (rgPago.getCheckedRadioButtonId() == R.id.rbTarjeta) {
            metodo = getString(R.string.tarjeta);
        }

        float estrellas = ratingBar.getRating();

        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.res_camarero, camarero)).append("\n");
        sb.append(getString(R.string.res_total, total)).append("\n");
        if (cbPropina.isChecked()) {
            sb.append(getString(R.string.res_propina, porcentaje, propina)).append("\n");
        }
        sb.append(getString(R.string.res_total_final, totalFinal)).append("\n");
        sb.append(getString(R.string.res_pago, metodo)).append("\n");
        sb.append(getString(R.string.res_calificacion, estrellas));

        tvResultado.setTextColor(Color.BLACK);
        tvResultado.setText(sb.toString());
    }

    private void mostrarError(String mensaje) {
        tvResultado.setTextColor(Color.RED);
        tvResultado.setText(mensaje);
    }
}