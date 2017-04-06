package stech.sukprung.sanae.mystech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit [ตัวแปร]
    private EditText userEditText, passEditText;
    private TextView textView;
    private Button button;
    private String userString, passwordString, truePasswordString;
    private boolean aBoolean = true;    // ตัวแปร boolean มีค่าเริ่มต้นเป็น true




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Initial View  [ผูกตัวแปรกับ View ที่ Activity]
        initialView();

        // create Controller
        controller();


    }   // Main Method


    // สร้าง  Method สำหรับควบคุม
    private void controller() {
        textView.setOnClickListener(MainActivity.this);
        button.setOnClickListener(MainActivity.this);

    }


    private void initialView() {    // void ไม่มีคืนค่ากลับ
        userEditText = (EditText) findViewById(R.id.edtUser);
        passEditText = (EditText) findViewById(R.id.edtPass);
        textView = (TextView) findViewById(R.id.txtRegis);
        button = (Button) findViewById(R.id.btnLogin);

    }

    @Override
    public void onClick(View v) {

        String tag = "SriwattanaV1";

        // For Text view
        if (v == textView) {
            Log.d(tag, "You Click TextView 'New Register'");

            // Create Intent สืบทอดจาก class Intent
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        }

        // For Button
        if (v== button) {
            Log.d(tag, "You Click Button 'Login'");

            // Get Value From Edit Text
            userString = userEditText.getText().toString().trim();
            passwordString = passEditText.getText().toString().trim();

            // Check Space
            if (userString.equals("") || passwordString.equals("")) {
                //Have Space
                MyAlert myAlert = new MyAlert(MainActivity.this);
                myAlert.myDialog("Have Space", "Please Fill All");

            } else {
                // No Space
                checkUserAnPass();
            }

        }


    }   // Method On Click

    private void checkUserAnPass() {
        try {

            GetUser getUser = new GetUser(MainActivity.this);
            getUser.execute();

            String strJSON = getUser.get();
            Log.d("TestV2", "JSON ==> " + strJSON);

            // Check User
            JSONArray jsonArray = new JSONArray(strJSON);
            for (int i=0; i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (userString.equals(jsonObject.getString("User"))) {
                    aBoolean = false;
                    truePasswordString = jsonObject.getString("Password");
                }
            }   //For  วนลูปตัดคำใน strJSON

            if (aBoolean) {
                MyAlert myAlert = new MyAlert(MainActivity.this);
                myAlert.myDialog("User False", "No This User on Database");
            } else if (!(passwordString.equals(truePasswordString))) {
                MyAlert myAlert = new MyAlert(MainActivity.this);
                myAlert.myDialog("Password False", "Please Try Again");

            } else {
                Intent intent = new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(intent);
                finish();
            }



        } catch (Exception e) {
            Log.d("TestV2", "e check ==> " + e.toString());
        }
    }


}   // end Main Class
