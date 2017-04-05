package stech.sukprung.sanae.mystech;

import android.nfc.tech.TagTechnology;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private EditText nameEditText, surmaeEditText, addressEditText, userEditText, passwordEditText;
    private Button button;
    private String nameString, surnameString, addressString, userString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Initial View  [ผูกตัวแปรกับ View ที่ Activity]
        initialView();

        controller();


    }   // Main Method

    private void controller() {
        button.setOnClickListener(RegisterActivity.this);
    }

    private void initialView() {
        nameEditText = (EditText) findViewById(R.id.edtName);
        surmaeEditText = (EditText) findViewById(R.id.edtSurname);
        addressEditText = (EditText) findViewById(R.id.edtAddress);
        userEditText = (EditText) findViewById(R.id.edtUser);
        passwordEditText = (EditText) findViewById(R.id.edtPassword);
        button = (Button) findViewById(R.id.btnRegister);
    }

    @Override
    public void onClick(View v) {

        if (v == button) {
            nameString = nameEditText.getText().toString().trim();
            surnameString = surmaeEditText.getText().toString().trim();
            addressString = addressEditText.getText().toString().trim();
            userString = userEditText.getText().toString().trim();
            passwordString = passwordEditText.getText().toString().trim();

            // Check Space
            if (nameString.equals("") || surnameString.equals("") || addressString.equals("") ||
                    userString.equals("") || passwordString.equals("")) {

                // Have Space
                MyAlert myAlert = new MyAlert(RegisterActivity.this);
                myAlert.myDialog("Have Space", "Please Fill All Blank");

            } else {

                // No Space

            }

        }
        // get Value From EditText


    }   // onClick
}   //Main Class
