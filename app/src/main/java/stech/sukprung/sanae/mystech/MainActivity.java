package stech.sukprung.sanae.mystech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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






    }   // Main Method


    private void initialView() {    // void ไม่มีคืนค่ากลับ
        userEditText = (EditText) findViewById(R.id.edtUser);
        passEditText = (EditText) findViewById(R.id.edtPass);
        textView = (TextView) findViewById(R.id.txtRegis);
        button = (Button) findViewById(R.id.btnLogin);

    }
}   // end Main Class
