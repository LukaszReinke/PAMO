/*
 Łukasz Reinke
 S15037
 Aplikacja mobilna, która realizuje funkcjonalności kalkulatora BMI.
*/

package com.example.calcbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calcbmi.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicjalizacja elementów UI
        final EditText weightInput = findViewById(R.id.weightInput);
        final EditText heightInput = findViewById(R.id.heightInput);
        Button calculateButton = findViewById(R.id.calculateButton);
        final TextView resultText = findViewById(R.id.resultText);

        // Ustawienie słuchacza kliknięć dla przycisku
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pobranie wprowadzonych danych
                String weightStr = weightInput.getText().toString();
                String heightStr = heightInput.getText().toString();

                // Sprawdzenie, czy pola nie są puste
                if (!"".equals(weightStr) && !"".equals(heightStr)) {
                    // Konwersja na odpowiednie typy
                    float weight = Float.parseFloat(weightStr);
                    float height = Float.parseFloat(heightStr) / 100; // Konwersja na metry

                    // Obliczanie BMI
                    float bmi = weight / (height * height);

                    // Wyświetlanie wyniku
                    resultText.setText(String.format("Twoje BMI: %.2f", bmi));
                }
            }
        });
    }
}
