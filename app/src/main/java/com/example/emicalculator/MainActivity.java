package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout emi_liner;
    LinearLayout fd_liner;
    LinearLayout rd_liner;
    LinearLayout tax_liner;
    LinearLayout Currency;
    LinearLayout ppf_liner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emi_liner=findViewById(R.id.emi_liner);
        fd_liner=findViewById(R.id.fd_liner);
        rd_liner=findViewById(R.id.rd_liner);
        tax_liner=findViewById(R.id.tax_liner);
        Currency=findViewById(R.id.Currency);
        ppf_liner=findViewById(R.id.ppf_liner);

        emi_liner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,EMIActivity.class);
                startActivity(i);
            }
        });

        fd_liner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent j = new Intent(MainActivity.this,FDActivity.class);
                startActivity(j);
            }
        });

        rd_liner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent j = new Intent(MainActivity.this,RDActivity.class);
                startActivity(j);
            }
        });

        tax_liner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent j = new Intent(MainActivity.this,TaxActivity.class);
                startActivity(j);
            }
        });

        Currency.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent j = new Intent(MainActivity.this,Currency_ConversionActivity.class);
                startActivity(j);
            }
        });

        Currency.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent j = new Intent(MainActivity.this,Currency_ConversionActivity.class);
                startActivity(j);
            }
        });

        ppf_liner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent j = new Intent(MainActivity.this,PPFActivity.class);
                startActivity(j);
            }
        });
    }
}