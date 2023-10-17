package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Currency_ConversionActivity extends AppCompatActivity {
    EditText edit_amount;
    Button btn_calculate,btn_clear;
    ImageView img_back;
    TextView text_convert;

    void Variable_ID()
    {
        edit_amount=findViewById(R.id.edit_amount);
        text_convert=findViewById(R.id.text_convert);

        btn_calculate=findViewById(R.id.btn_calculate);
        btn_clear=findViewById(R.id.btn_clear);

        text_convert=findViewById(R.id.text_convert);

        img_back=findViewById(R.id.img_back);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_conversion);

        Variable_ID();

        btn_clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Clear();
            }
        });

        btn_calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Calculate();
            }
        });

        img_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Currency_ConversionActivity.this,MainActivity.class);
                startActivity(j);
            }
        });
    }
    void Clear()
    {
        edit_amount.setText(null);
        text_convert.setText(null);
    }
    void Calculate()
    {
        String amount = edit_amount.getText().toString();
        if (amount.isEmpty())
        {
            Toast.makeText(this, "Enter Amount", Toast.LENGTH_SHORT).show();
        } else {
            Double Amount_ent=0.0;
            try {
                Amount_ent = Double.parseDouble(amount);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
                return;
            }

            Double exchangerate = 83.28;
            Double convert_amount = Amount_ent * exchangerate;

            text_convert.setText(String.format("%.2f",convert_amount));
        }
    }
}