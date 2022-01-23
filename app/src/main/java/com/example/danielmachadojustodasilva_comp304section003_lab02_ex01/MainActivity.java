package com.example.danielmachadojustodasilva_comp304section003_lab02_ex01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.enter_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

    // Open new activity
    public void openActivity2(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}