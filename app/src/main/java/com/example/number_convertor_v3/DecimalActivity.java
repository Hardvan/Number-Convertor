package com.example.number_convertor_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class DecimalActivity extends AppCompatActivity {

    //Declaring all components
    EditText et_number;

    Button b_toBinary, b_toHexa, b_toOctal;
    ImageButton b_back;

    TextView tv_result_title;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimal);

        et_number = findViewById(R.id.et_input);

        b_toBinary = findViewById(R.id.b_toBINA);
        b_toHexa = findViewById(R.id.b_toHEXAD);
        b_toOctal = findViewById(R.id.b_toOctal);

        b_back = findViewById(R.id.b_back);

        tv_result_title = findViewById(R.id.tv_result_title);
        tv_result = findViewById(R.id.tv_result);


        b_toBinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = et_number.getText().toString();
                calculateResult(number, "Binary");
            }
        });

        b_toHexa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = et_number.getText().toString();
                calculateResult(number, "Hexadecimal");
            }
        });

        b_toOctal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = et_number.getText().toString();
                calculateResult(number, "Octal");
            }
        });

        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DecimalActivity.this, MainActivity.class));
            }
        });

    }

    public void calculateResult(String number, String to) {

        String result = "";
        String result_title = "";

        // Decimal to Binary
        if (to.equals("Binary")) {

            result = DecimalToBinary(number);
            result_title = "Decimal to Binary Conversion:";
        }

        // Decimal to Hexadecimal
        else if (to.equals("Hexadecimal")) {

            result = DecimalToHexadecimal(number);
            result_title = "Decimal to Hexadecimal Conversion:";
        }

        // Decimal to Octal
        else if (to.equals("Octal")) {

            result = DecimalToOctal(number);
            result_title = "Decimal to Octal Conversion:";
        }

        displayResult(result, result_title);
    }

    public String DecimalToBinary(String decimal) {

        return Integer.toBinaryString(Integer.parseInt(decimal));
    }

    public String DecimalToHexadecimal(String decimal) {

        return Integer.toHexString(Integer.parseInt(decimal));
    }

    public String DecimalToOctal(String decimal) {

        return Integer.toOctalString(Integer.parseInt(decimal));
    }

    public void displayResult(String result, String result_title) {

        tv_result_title.setText(result_title);
        tv_result.setText(result);

    }
}