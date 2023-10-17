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

public class TaxActivity extends AppCompatActivity {
    EditText edit_amount,edit_tax;
    Button btn_calculate,btn_clear;
    TextView text_total;
    ImageView img_back;
    void Variable_ID()
    {
//        EDITTEXT
        edit_amount=findViewById(R.id.edit_amount);
        edit_tax=findViewById(R.id.edit_tax);
//        BUTTON
        btn_calculate=findViewById(R.id.btn_calculate);
        btn_clear=findViewById(R.id.btn_clear);
//        TEXTVIEW
        text_total=findViewById(R.id.text_total);
//        IMAGEVIEW
        img_back=findViewById(R.id.img_back);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax);

        Variable_ID();

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clear();
            }
        });

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculator();
            }
        });

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(TaxActivity.this,MainActivity.class);
                startActivity(j);
            }
        });
    }
    void Clear()
    {
        edit_amount.setText(null);
        edit_tax.setText(null);
        text_total.setText(null);
    }
    void Calculator()
    {
        String amount_string = edit_amount.getText().toString();
        String tax_string = edit_tax.getText().toString();

        if (amount_string.isEmpty() && tax_string.isEmpty()) {
            Toast.makeText(this, "Emter The Value", Toast.LENGTH_SHORT).show();
        } else if (amount_string.isEmpty()) {
            Toast.makeText(this, "Enter Amount", Toast.LENGTH_SHORT).show();
        } else if (tax_string.isEmpty()) {
            Toast.makeText(this, "Enter Tax", Toast.LENGTH_SHORT).show();
        } else {
            int amount_text = Integer.parseInt(amount_string);
            int tax_text = Integer.parseInt(tax_string);

            if (tax_text <= 50) {
                int tax = amount_text / 20;
                int total = amount_text + tax;
                text_total.setText(String.valueOf(total));
            } else {
                Toast.makeText(this, "Enter Rong Value", Toast.LENGTH_SHORT).show();
            }
        }
    }
}