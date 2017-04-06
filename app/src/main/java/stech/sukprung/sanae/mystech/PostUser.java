package stech.sukprung.sanae.mystech;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by Administrator on 4/6/2017.
 */

// extends คือ การสืบทอดจาก class
public class PostUser extends AsyncTask<String,Void, String>{   //สืบทอด class AsyncTask [ทำซ้ำจนกว่าจะสำเร็จ]

    private Context context;
    // สร้างตัวแปร คงที่ แก้ไขไม่ได้
    private static final String urlPHP = "http://swiftcodingthai.com/tech/addUserSanae.php";

    public PostUser(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder() // sent to PHP
                    .add("isAdd", "true")
                    .add("Name", params[0])
                    .add("Surname", params[1])
                    .add("Address", params[2])
                    .add("User", params[3])
                    .add("Password", params[4])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlPHP).post(requestBody).build();    //กำหนดปลายทางที่ส่งค่า
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {     //Exception e = error ที่ยอมรับได้
            //e.printStackTrace();
            Log.d("TestV1", "e doIn ==> " + e.toString());

            return null;
        }


    }
}   //Main Class
