package com.a3wa.webservice.webservice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.FuelKt;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Handler;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity implements Handler<String>{

    private Model model;

    private TextView txtTitre;
    private TextView txtDesc;
    private TextView txtCarac;
    private ImageView imgView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.template2);

        this.txtTitre = findViewById(R.id.txtTitre);
        this.txtDesc = findViewById(R.id.txtDesc);
        this.txtCarac = findViewById(R.id.txtCarac);
        this.imgView = findViewById(R.id.imgView);

        Model model = (Model) getIntent().getSerializableExtra("categorie");
        Picasso.get().load(model.getPhoto()).into(this.imgView);




        //get
        Fuel.get("http://51.15.254.4:9001/ws/prod/infoProd/"+model.getId()).responseString(this);

    }


            @Override
            public void failure(Request request, Response response, FuelError error) {
                //do something when it is failure
            }

            @Override
            public void success(Request request, Response response, String data) {

                try {
                    JSONObject obj = new JSONObject(data);
                    this.model = new Model(obj.getInt("id"),obj.getString("title"),obj.getString("photo"),obj.getString("descriptionProd"),obj.getString("caracteristiques"), (float)obj.getDouble("tarif"));

                    this.txtTitre.setText(this.model.getTitre());
                    this.txtDesc.setText(this.model.getDesc());
                    this.txtCarac.setText(this.model.getCarac());

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


}
