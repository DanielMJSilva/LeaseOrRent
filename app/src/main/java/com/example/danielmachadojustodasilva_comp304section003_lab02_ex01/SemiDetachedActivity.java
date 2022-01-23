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

public class SemiDetachedActivity extends AppCompatActivity {

    private CheckBox checkBox5;
    private CheckBox checkBox6;
    private Button btn_select;

    private boolean cbOnOff5;
    private boolean cbOnOff6;

    public  static final String SHARED_PREFS = "sharedPrefs";
    public  static final String CB5 = "checkBox5";
    public  static final String CB6 = "checkBox6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semi_detached);
        btn_select = (Button) findViewById(R.id.select_btn);
        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
        checkBox6 = (CheckBox) findViewById(R.id.checkBox6);

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

        editor.putBoolean(CB5, checkBox5.isChecked());
        editor.putBoolean(CB6, checkBox6.isChecked());

        editor.apply();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        cbOnOff5 = sharedPreferences.getBoolean(CB5, false);
        cbOnOff6 = sharedPreferences.getBoolean(CB6, false);
    }

    public void updateViews(){
        checkBox5.setChecked(cbOnOff5);
        checkBox6.setChecked(cbOnOff6);
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