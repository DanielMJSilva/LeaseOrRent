package com.example.danielmachadojustodasilva_comp304section003_lab02_ex01;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;
import java.util.regex.Pattern;


public class InformationActivity extends AppCompatActivity {

    public TextInputLayout textInputName;
    public TextInputLayout textInputCard;
    public TextInputLayout textInputAddress;
    public TextInputLayout textInputEmail;


    public static final Pattern EMAIL_ADDRESS = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@"
                    + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\."
                    + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Boolean cash = getIntent().getBooleanExtra("Cash", false);

        textInputName = findViewById(R.id.name_text);
        textInputCard = findViewById(R.id.card_text);
        textInputAddress = findViewById(R.id.address_text);
        textInputEmail = findViewById(R.id.email_text);

        if(cash){
            textInputCard.setVisibility(View.INVISIBLE);
        }
    }

    private boolean validateCard() {
        String usernameInput = textInputCard.getEditText().getText().toString().trim();

        if (usernameInput.isEmpty()) {
            textInputCard.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() < 16) {
            textInputCard.setError("It needs 16 numbers");
            return false;
        } else {
            textInputCard.setError(null);
            return true;
        }
    }

    private boolean validateName() {
        String usernameInput = textInputName.getEditText().getText().toString().trim();

        if (usernameInput.isEmpty()) {
            textInputName.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() < 10) {
            textInputName.setError("Name too short");
            return false;
        } else {
            textInputName.setError(null);
            return true;
        }
    }


   public boolean validateEmail() {
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputEmail.setError("Field can't be empty");
            return false;
        } else if (!EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textInputEmail.setError("Please enter a valid email address");
            return false;
        } else {
            textInputEmail.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateEmail() | !validateCard() | !validateName()) {
            return;
        }

        String input = "";

        input += "Name: " + textInputName.getEditText().getText().toString();
        input += "\n";
        input += "Card: " + textInputCard.getEditText().getText().toString();
        input += "\n";
        input += "Email: " + textInputEmail.getEditText().getText().toString();


        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }


}