package com.example.number_convertor_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class OctalActivity extends AppCompatActivity {

    //Declaring all components
    EditText et_number;

    Button b_toBinary, b_toHex, b_toDecimal;
    ImageButton b_back;

    TextView tv_result_title;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_octal);

        et_number = findViewById(R.id.et_input);

        b_toBinary = findViewById(R.id.b_toBINA);
        b_toHex = findViewById(R.id.b_toHEXAD);
        b_toDecimal = findViewById(R.id.b_toOCTA);

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

        b_toHex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = et_number.getText().toString();
                calculateResult(number, "Hexadecimal");
            }
        });

        b_toDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = et_number.getText().toString();
                calculateResult(number, "Decimal");
            }
        });

        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OctalActivity.this, MainActivity.class));
            }
        });

    }

    public void calculateResult(String number, String to) {

        String result = "";
        String result_title = "";

        // Octal to Binary
        if (to.equals("Binary")) {

            result = OctalToBinary(number);
            result_title = "Octal to Binary Conversion:";
        }

        // Octal to Hexadecimal
        else if (to.equals("Hexadecimal")) {

            result = OctalToHexadecimal(number);
            result_title = "Octal to Hexadecimal Conversion:";
        }

        // Octal to Decimal
        else if (to.equals("Decimal")) {

            result = OctalToDecimal(number);
            result_title = "Octal to Decimal Conversion:";
        }

        displayResult(result, result_title);
    }

    public String OctalToBinary(String octal) {

        return Integer.toBinaryString(Integer.parseInt(octal,8));
    }

    public String OctalToHexadecimal(String octal) {

        return Integer.toHexString(Integer.parseInt(octal,8));
    }

    public String OctalToDecimal(String octal) {

        return String.valueOf(Integer.parseInt(octal,8));
    }

    public void displayResult(String result, String result_title) {

        tv_result_title.setText(result_title);
        tv_result.setText(result);

    }
}