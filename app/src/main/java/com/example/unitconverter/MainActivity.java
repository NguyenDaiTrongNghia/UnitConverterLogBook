package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onConvertClick(View v){
    Spinner sp1 = (Spinner)findViewById(R.id.spinner1);
    String choice1 = sp1.getSelectedItem().toString();
    Spinner sp2 = (Spinner)findViewById(R.id.spinner2);
    String choice2 = sp2.getSelectedItem().toString();

    EditText ed1 = (EditText)findViewById(R.id.editTextText);
    EditText tvResult = findViewById(R.id.editTextText2);
    double value1 = Double.parseDouble(ed1.getText().toString());
    double baseValue = 0;
    double convertedValue = 0;

        switch (choice1) {
            case "Meter":
                baseValue = value1;
                break;
            case "Millimeter":
                baseValue = value1 / 1000;
                break;
            case "Mile":
                baseValue = value1 * 1609.34;
                break;
            case "Foot":
                baseValue = value1 * 0.3048;
                break;
        }
        switch (choice2) {
            case "Meter":
                convertedValue = baseValue;
                break;
            case "Millimeter":
                convertedValue = baseValue * 1000;
                break;
            case "Mile":
                convertedValue = baseValue / 1609.34;
                break;
            case "Foot":
                convertedValue = baseValue / 0.3048;
                break;
        }
        tvResult.setText(String.valueOf(convertedValue));
    }
}