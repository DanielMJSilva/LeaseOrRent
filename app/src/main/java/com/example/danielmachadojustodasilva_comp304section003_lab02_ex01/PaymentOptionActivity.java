package com.example.danielmachadojustodasilva_comp304section003_lab02_ex01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentOptionActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    Button btn_select3;

    private boolean isCheckedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option);
        radioGroup = findViewById(R.id.radioGroup1);
        radioButton1 = findViewById(R.id.radio1);
        radioButton2 = findViewById(R.id.radio2);
        radioButton3 = findViewById(R.id.radio3);


        btn_select3 = findViewById(R.id.select_btn3);
        btn_select3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton1.isChecked()){
                    isCheckedValue = true;
                }else {
                    isCheckedValue = false;
                }
                openInfoActivity();
            }
        });
    }
    // Open new activity
    public void openInfoActivity(){
        Intent intent = new Intent(this, InformationActivity.class);
        intent.putExtra("Cash", isCheckedValue);
        startActivity(intent);
    }
}