package com.example.number_convertor_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class HexadecimalActivity extends AppCompatActivity {

    //Declaring all components
    EditText et_number;

    Button b_toDecimal, b_toBinary, b_toOctal;
    ImageButton b_back;

    TextView tv_result_title;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hexadecimal);

        et_number = findViewById(R.id.et_input);

        b_toDecimal = findViewById(R.id.b_toBINA);
        b_toBinary = findViewById(R.id.b_toHEXAD);
        b_toOctal = findViewById(R.id.b_toO);

        b_back = findViewById(R.id.b_back);

        tv_result_title = findViewById(R.id.tv_result_title);
        tv_result = findViewById(R.id.tv_result);


        b_toDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = et_number.getText().toString();
                calculateResult(number, "Decimal");
            }
        });

        b_toBinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = et_number.getText().toString();
                calculateResult(number, "Binary");
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
                startActivity(new Intent(HexadecimalActivity.this, MainActivity.class));
            }
        });

    }

    public void calculateResult(String number, String to) {

        String result = "";
        String result_title = "";

        // Hexadecimal to Decimal
        if (to.equals("Decimal")) {

            result = HexaToDecimal(number);
            result_title = "Hexadecimal to Decimal Conversion:";
        }

        // Hexadecimal to Binary
        else if (to.equals("Binary")) {

            result = HexaToBinary(number);
            result_title = "Hexadecimal to Binary Conversion:";
        }

        // Hexadecimal to Octal
        else if (to.equals("Octal")) {

            result = HexaToOctal(number);
            result_title = "Hexadecimal to Octal Conversion:";
        }

        displayResult(result, result_title);
    }

    public String HexaToDecimal(String hexa) {

        return String.valueOf(Integer.parseInt(hexa,16));
    }

    public String HexaToBinary(String hexa) {

        return Integer.toBinaryString(Integer.parseInt(HexaToDecimal(hexa)));
    }

    public String HexaToOctal(String hexa) {

        return Integer.toOctalString(Integer.parseInt(HexaToDecimal(hexa)));
    }

    public void displayResult(String result, String result_title) {

        tv_result_title.setText(result_title);
        tv_result.setText(result);

    }

}