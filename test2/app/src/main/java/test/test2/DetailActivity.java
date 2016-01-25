package test.test2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.Model;
import com.activeandroid.query.Select;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import test.test2.classes.Ville;
import test.test2.classes.VilleWeather;
import test.test2.classes.VilleWeatherDAO;


import android.view.View;

import com.activeandroid.query.Select;

import java.util.List;



public class DetailActivity extends AppCompatActivity {

    public static final String URL_WEATHER = "http://api.openweathermap.org/data/2.5/weather?lat=$lat$&lon=$long$&APPID=9ea381fa340e63422ce2a40463a736f0";

    Ville ville;
    TextView text1;
    TextView text2;
    ImageView imgWeather;
    FloatingActionButton fab, fab1;

    String desc, icon, temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .showImageOnFail(R.drawable.logo_weather)
                .showImageOnLoading(R.drawable.logo_weather)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(defaultOptions).build();
        ImageLoader.getInstance().init(config);


        ville = (Ville) getIntent().getSerializableExtra(MainActivity.KEY_ville);

        imgWeather = (ImageView) findViewById(R.id.image1);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);


        //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //   setSupportActionBar(toolbar);
        getWeather();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         /*     System.out.println(ville);
                VilleWeatherDAO dao = new VilleWeatherDAO(view);
                VilleWeather vWeatehr = new VilleWeather(ville, Float.parseFloat(temp), desc, icon);
                dao.add(vWeatehr);
                //  finish();

                for (VilleWeather v : dao.select()) {
                    System.out.println(v);
                } */
            Intent toto = new Intent(DetailActivity.this, AfficheDB.class);
               startActivity(toto);


            }
        });



        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        System.out.println(ville);
                VilleWeatherDAO dao = new VilleWeatherDAO(view);
                VilleWeather vWeatehr = new VilleWeather(ville, Float.parseFloat(temp), desc, icon);
                dao.add(vWeatehr);
                //  finish();

                for (VilleWeather v : dao.select()) {
                    System.out.println(v);
                }
             //   Intent toto = new Intent(DetailActivity.this, AfficheDB.class);
              //  startActivity(toto);


            }
        });




    }


    public void getWeather() {
        String url = URL_WEATHER.replace("$lat$", "" + ville.getLat()).replace("$long$", "" + ville.getLng());
        System.out.println(url);

        Volley.newRequestQueue(this).add(
                new JsonObjectRequest(Method.GET, url, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println(response.toString());
                        JSONArray json = response.optJSONArray("weather");
                        JSONObject jsonMain = response.optJSONObject("main");
                        desc = json.optJSONObject(0).optString("main");
                        icon = json.optJSONObject(0).optString("icon");
                        temp = jsonMain.optString("temp");
                        System.out.println(icon + desc + temp);

                        text1.setText(temp);
                        text2.setText(desc);
                        ImageLoader.getInstance().displayImage("http://openweathermap.org/img/w/" + icon + ".png",
                                imgWeather);


                        fab.setVisibility(View.VISIBLE);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
        );


    }
}
