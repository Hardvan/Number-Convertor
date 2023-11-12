package com.example.number_convertor_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class BinaryActivity extends AppCompatActivity {

    //Declaring all components
    EditText et_number;

    Button b_toDecimal, b_toHexa, b_toOctal;
    ImageButton b_back;

    TextView tv_result_title;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary);

        et_number = findViewById(R.id.et_input);

        b_toDecimal = findViewById(R.id.b_toBINA);
        b_toHexa = findViewById(R.id.b_toHexa);
        b_toOctal = findViewById(R.id.b_Octal);

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
                startActivity(new Intent(BinaryActivity.this, MainActivity.class));
            }
        });

    }

    public void calculateResult(String number, String to) {

        String result = "";
        String result_title = "";

        // Binary to Decimal
        if (to.equals("Decimal")) {

            result = BinaryToDecimal(number);
            result_title = "Binary to Decimal Conversion:";
        }

        // Binary to Hexadecimal
        else if (to.equals("Hexadecimal")) {

            result = BinaryToHexadecimal(number);
            result_title = "Binary to Hexadecimal Conversion:";
        }

        // Binary to Octal
        else if (to.equals("Octal")) {

            result = BinaryToOctal(number);
            result_title = "Binary to Octal Conversion:";
        }

        displayResult(result, result_title);
    }

    public String BinaryToDecimal(String binary) {

        return String.valueOf(Integer.parseInt(binary,2));
    }

    public String BinaryToHexadecimal(String binary) {

        return Integer.toHexString(Integer.parseInt(BinaryToDecimal(binary)));
    }

    public String BinaryToOctal(String binary) {

        return Integer.toOctalString(Integer.parseInt(BinaryToDecimal(binary)));
    }

    public void displayResult(String result, String result_title) {

        tv_result_title.setText(result_title);
        tv_result.setText(result);

    }

}