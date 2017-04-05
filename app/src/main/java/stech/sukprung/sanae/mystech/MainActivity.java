package stech.sukprung.sanae.mystech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit [ตัวแปร]
    private EditText userEditText, passEditText;
    private TextView textView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ///Initial View  [ผูกตัวแปรกับ View ที่ Activity]
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
        }

        // For Button
        if (v== button) {
            Log.d(tag, "You Click Button 'Login'");
        }


    }   // Method On Click



}   // end Main Class
