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

public class FDActivity extends AppCompatActivity {
    EditText edit_amount,edit_interest,edit_tenure;
    Button btn_calculate,btn_clear;
    TextView text_maturity;
    ImageView img_back_2;
    void Variable_ID() {
//        EDITTEXT
        edit_amount = findViewById(R.id.edit_amount);
        edit_interest = findViewById(R.id.edit_interest);
        edit_tenure = findViewById(R.id.edit_tenure);
//        BUTTON
        btn_calculate = findViewById(R.id.btn_calculate);
        btn_clear = findViewById(R.id.btn_clear);
//        TEXTVIEW
        text_maturity = findViewById(R.id.text_maturity);
//        IMAGEVIEW
        img_back_2 = findViewById(R.id.img_back_2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fdactivity);

        Variable_ID();

        btn_clear.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Clear();
            }
        });

        btn_calculate.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Calculator();
            }
        });

        img_back_2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent j = new Intent(FDActivity.this,MainActivity.class);
                startActivity(j);
            }
        });
    }
    public void Clear()
    {
        edit_amount.setText(null);
        edit_interest.setText(null);
        edit_tenure.setText(null);
        text_maturity.setText(null);
    }
    public void Calculator()
    {
        String investment_text = edit_amount.getText().toString();
        String intrest_text = edit_interest.getText().toString();
        String tenure_text = edit_tenure.getText().toString();

        if(investment_text.isEmpty() && intrest_text.isEmpty() && tenure_text.isEmpty())
        {
            Toast.makeText(this, "Enter The Valure", Toast.LENGTH_SHORT).show();
        } else if (investment_text.isEmpty()) {
            Toast.makeText(this, "Enter Amount", Toast.LENGTH_SHORT).show();
        } else if (intrest_text.isEmpty()) {
            Toast.makeText(this, "Enter Expected Rate", Toast.LENGTH_SHORT).show();
        } else if (tenure_text.isEmpty()) {
            Toast.makeText(this, "Enter Tunure", Toast.LENGTH_SHORT).show();
        } else {
            Double investment_amt = Double.parseDouble(investment_text);
            Double Rate_of_interest = Double.parseDouble(intrest_text);
            Double Tenure = Double.parseDouble(tenure_text);

            if(Rate_of_interest <= 50 && Tenure <= 30){
                Double rate = (investment_amt * Rate_of_interest * Tenure) / 100;
                Double amount = investment_amt + rate;

                text_maturity.setText(String.format("%.2f",amount));
            } else {
                Toast.makeText(this, "Enter The Rong Value", Toast.LENGTH_SHORT).show();
            }
        }
    }
}