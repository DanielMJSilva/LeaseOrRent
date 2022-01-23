package com.example.danielmachadojustodasilva_comp304section003_lab02_ex01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ApartmentActivity extends AppCompatActivity {

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private Button btn_select;

    private boolean cbOnOff1;
    private boolean cbOnOff2;

    public  static final String SHARED_PREFS = "sharedPrefs";
    public  static final String CB1 = "checkBox1";
    public  static final String CB2 = "checkBox2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment);
        btn_select = (Button) findViewById(R.id.select_btn);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);

        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPaymentActivity();
            }
        });

        loadData();
        updateViews();
    }

    // Open Payment Activity activity
    public void openPaymentActivity(){
        Intent intent = new Intent(this, PaymentOptionActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_homes, menu);
        return true;
    }

    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(CB1, checkBox1.isChecked());
        editor.putBoolean(CB2, checkBox2.isChecked());

        editor.apply();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        cbOnOff1 = sharedPreferences.getBoolean(CB1, false);
        cbOnOff2 = sharedPreferences.getBoolean(CB2, false);
    }

    public void updateViews(){
        checkBox1.setChecked(cbOnOff1);
        checkBox2.setChecked(cbOnOff2);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.apartment:
                saveData();
                Intent intent1 = new Intent(this, ApartmentActivity.class);
                startActivity(intent1);
                return true;
            case R.id.detached_home:
                saveData();
                Intent intent2 = new Intent(this, DetachedActivity.class);
                startActivity(intent2);
                return true;
            case R.id.semi_detached_home:
                saveData();
                Intent intent3 = new Intent(this, SemiDetachedActivity.class);
                startActivity(intent3);
                return true;
            case R.id.condominium:
                saveData();
                Intent intent4 = new Intent(this, CondoActivity.class);
                startActivity(intent4);
                return true;
            case R.id.town_house:
                saveData();
                Intent intent5 = new Intent(this, TownHouseActivity.class);
                startActivity(intent5);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

