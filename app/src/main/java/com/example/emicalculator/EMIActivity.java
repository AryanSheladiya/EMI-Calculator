package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EMIActivity extends AppCompatActivity {
    EditText edit_principal,edit_interest,edit_loan;
    Button btn_calculate,btn_clear;
    TextView text_EMI;
    ImageView img_back;
    void Variable_ID(){
//        EDITTEXT
        edit_principal=findViewById(R.id.edit_principal);
        edit_interest=findViewById(R.id.edit_interest);
        edit_loan=findViewById(R.id.edit_loan);
//        BUTTON
        btn_calculate=findViewById(R.id.btn_calculate);
        btn_clear=findViewById(R.id.btn_clear);
//        TEXTVIEW
        text_EMI=findViewById(R.id.text_EMI);
//        IMAGEVIEW
        img_back=findViewById(R.id.img_back);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emiactivity);

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

        img_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EMIActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
    void Clear(){
        edit_principal.setText(null);
        edit_interest.setText(null);
        edit_loan.setText(null);
        text_EMI.setText(null);
    }

    void Calculator()
    {
        String principal=edit_principal.getText().toString();
        String interest=edit_interest.getText().toString();
        String loan=edit_loan.getText().toString();

        if (principal.isEmpty() && interest.isEmpty() && loan.isEmpty())
        {
            Toast.makeText(this, "Enter The Value", Toast.LENGTH_SHORT).show();
        } else if (principal.isEmpty()) {
            Toast.makeText(this, "Enter Principal Amount", Toast.LENGTH_SHORT).show();
        } else if (interest.isEmpty()) {
            Toast.makeText(this, "Enter Interest", Toast.LENGTH_SHORT).show();
        } else if (loan.isEmpty()) {
            Toast.makeText(this, "Enter Loan Tenure", Toast.LENGTH_SHORT).show();
        } else {
            double principal_amount =Double.parseDouble(edit_principal.getText().toString());
            double intrest_rate =Double.parseDouble(edit_interest.getText().toString());
            double loan_tenure =Double.parseDouble(edit_loan.getText().toString());

            if (intrest_rate <= 50 && loan_tenure <= 30) {
                double monthlyInterest = (intrest_rate / 12) / 100;
                int numberofpayments = (int) (loan_tenure * 12);
                double emi = principal_amount * (monthlyInterest * Math.pow(1 + monthlyInterest, numberofpayments)) / (Math.pow(1 + monthlyInterest, numberofpayments) - 1);

                text_EMI.setText(String.format("%2.2f", emi));
            }else {
                Toast.makeText(this, "Enterv The Rong Value", Toast.LENGTH_SHORT).show();
            }
        }
    }
}