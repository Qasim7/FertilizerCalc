package com.moranagro.fertilizercalc;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView azot, fosfor, kalium, ammofos, a_nitrat;
    double azot1, fosfor1, kalium1, ammofos1, a_nitrat1;
    EditText fertility;
    double fertility1;
    Button calculate, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        azot = findViewById(R.id.azot);
        fosfor = findViewById(R.id.fosfor);
        kalium = findViewById(R.id.kalium);
        ammofos = findViewById(R.id.ammofos);
        a_nitrat = findViewById(R.id.a_nitrat);
        fertility = findViewById(R.id.fertility);
        calculate = findViewById(R.id.calculate);
        clear = findViewById(R.id.clear);


        calculate.setOnClickListener(v -> {

            if (TextUtils.isEmpty(fertility.getText().toString()) || fertility.getText().toString().equals(".")) {

                Toast.makeText(this, "Rəqəmi daxil edin", Toast.LENGTH_SHORT).show();

            } else {

                fertility1 = Double.parseDouble(fertility.getText().toString());

                azot1 = fertility1 * 3;
                fosfor1 = fertility1;
                kalium1 = fertility1 * 2.9;
                ammofos1 = 100 * fertility1 / 16;
                a_nitrat1 = (100 * azot1 / 22) - (ammofos1 * 8 / 100);

                DecimalFormat df = new DecimalFormat("#.#");
                df.setRoundingMode(RoundingMode.HALF_UP);

                azot.setText(df.format(azot1));
                fosfor.setText(df.format(fosfor1));
                kalium.setText(df.format(kalium1));
                ammofos.setText(df.format(ammofos1));
                a_nitrat.setText(df.format(a_nitrat1));
            }
        });
        clear.setOnClickListener(v -> {
            azot.setText("");
            fosfor.setText("");
            kalium.setText("");
            ammofos.setText("");
            a_nitrat.setText("");
            fertility.setText("");
        });
    }
}