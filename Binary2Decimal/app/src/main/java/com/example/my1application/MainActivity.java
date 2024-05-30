package com.example.my1application;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText binaryInput;
    Button convertButton;


    TextView decimalOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binaryInput = findViewById(R.id.binaryInput);
        convertButton = findViewById(R.id.convertButton);
        decimalOutput = findViewById(R.id.decimalOutput);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String binaryStr = binaryInput.getText().toString().trim();
                if (!binaryStr.isEmpty()) {
                    int decimal = binaryToDecimal(binaryStr);
                    decimalOutput.setText("Decimal Number: " + decimal);
                } else {
                    decimalOutput.setText("Decimal Number: ");
                }
            }
        });
    }

    private int binaryToDecimal(String binaryStr) {
        int decimal = 0;
        int power = 0;
        for (int i = binaryStr.length() - 1; i >= 0; i--) {
            if (binaryStr.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }
}
