package com.example.recyylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.recyylerview.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding a1;
    Bitmap bmp = null;
    LisenDo lisenDo;
    String s1,s2,s3,s4,s5,s6,s7,s8;
    String API = "https://api.androidhive.info/contacts/";
    String res;
    DemoModel demoModel;
    List<DemoModel> values = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        a1= DataBindingUtil.setContentView(this,R.layout.activity_main);

        a1.rcylid.setLayoutManager(new LinearLayoutManager(this));


        lisenDo=new LisenDo() {
            @Override
            public void iamdo(int p) {
                Toast.makeText(MainActivity.this, "you have clicked on "+p, Toast.LENGTH_SHORT).show();
            }
        };
        Detaill det = new Detaill();

        det.execute();




    }

    public List<DemoModel> getValues() {





        return values;
    }


    private class Detaill extends AsyncTask {


        @Override
        protected Object doInBackground(Object[] objects) {

            GettDtt gt = new GettDtt();
            res = gt.makeServiceCall(API);

            try {
                JSONObject wholeobj = new JSONObject(res);
                JSONArray jsarr = wholeobj.getJSONArray("contacts");

                for(int  i = 0;i< jsarr.length();i++)
                {
                       JSONObject arrobj2 = jsarr.getJSONObject(i);

                       s1 =arrobj2.getString("id");
                       s2 = arrobj2.getString("name");
                       s3 = arrobj2.getString("email");
                       s4 = arrobj2.getString("address");
                       s5 = arrobj2.getString("gender");

                    JSONObject phobj2 = arrobj2.getJSONObject("phone");
                    s6 = phobj2.getString("mobile");
                    s7 = phobj2.getString("home");
                    s8 = phobj2.getString("office");

                    values.add(new DemoModel(s1,s2,s3,s4,s5,s6,s7,s8));


                }



            } catch (JSONException e) {
                e.printStackTrace();
            }






            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            MyAdapter myAdapter = new MyAdapter(lisenDo);

            myAdapter.setData(getValues());
            a1.rcylid.setAdapter(myAdapter);


//            arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
//            listView.setAdapter(arrayAdapter);




        }
    }
}