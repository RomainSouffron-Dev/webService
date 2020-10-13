package com.a3wa.webservice.webservice;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Handler;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private List<Model> produitList;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        this.produitList = new ArrayList<>();
        listView.setOnItemClickListener(this);

        Fuel.get("http://51.15.254.4:9001/ws/prod/list").responseString(new Handler<String>() {
            @Override
            public void failure(Request request, Response response, FuelError error) {
                //do something when it is failure
            }

            @Override
            public void success(Request request, Response response, String data) {


                try {
                    JSONArray array = new JSONArray(data);

                    for (int i = 0; i < array.length() ; i++) {

                        JSONObject obj = array.getJSONObject(i);
                        Model model = new Model(obj.getInt("id"),obj.getString("title"),obj.getString("photo"));
                        produitList.add(model);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Adapter adapter = new Adapter(MainActivity.this, produitList);
                listView.setAdapter(adapter);


            }
        });




    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Model model = this.produitList.get(position);
        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("categorie",model);
        startActivity(intent);

    }
}








