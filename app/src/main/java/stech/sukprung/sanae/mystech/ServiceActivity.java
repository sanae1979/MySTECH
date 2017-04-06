package stech.sukprung.sanae.mystech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        ListView listView = (ListView) findViewById(R.id.livName);

        try {

            GetUser getUser = new GetUser(ServiceActivity.this);
            getUser.execute();

            String strJSON = getUser.get();
            Log.d("TestV3", "JSON =>> " + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);

            String[] nameString = new String[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                nameString[i] = jsonObject.getString("Name");



            }   //for


            //Create ListView

            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(ServiceActivity.this,
                    android.R.layout.simple_list_item_1,nameString);
            listView.setAdapter(stringArrayAdapter);


        } catch (Exception e) {
            Log.d("TestV3", "e Main =>>" + e.toString());
        }


    }   //Main Method


}   // Main Class
