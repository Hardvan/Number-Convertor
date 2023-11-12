package com.example.number_convertor_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b_Binary, b_Hexa, b_Decimal, b_Octal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_Binary = findViewById(R.id.b_Binary);
        b_Hexa = findViewById(R.id.b_Hexa);
        b_Decimal = findViewById(R.id.b_Decimal);
        b_Octal = findViewById(R.id.b_Octal);

        b_Binary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, BinaryActivity.class));

            }
        });
        b_Hexa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HexadecimalActivity.class));
            }
        });
        b_Decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DecimalActivity.class));
            }
        });
        b_Octal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, OctalActivity.class));

            }
        });


    }
}