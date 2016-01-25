package test.test2;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

import test.test2.classes.Ville;
import test.test2.classes.VilleAdapter;
import test.test2.classes.VilleWeather;
import test.test2.classes.VilleWeatherAdapter;
import test.test2.classes.VilleWeatherDAO;

public class AfficheDB extends AppCompatActivity {

ListView list1;
    ImageView icon1;
public    List<VilleWeather> villesWeather;
    FloatingActionButton fab;
  // public VilleWeatherAdapter dd = new VilleWeatherAdapter(this,villesWeather);
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_db);
        list1= (ListView)findViewById(R.id.list);
ImageView icon1=(ImageView)findViewById(R.id.icon);
        fab = (FloatingActionButton) findViewById(R.id.fab);
   /*    DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .showImageOnFail(R.drawable.logo_weather)
                .showImageOnLoading(R.drawable.logo_weather)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(defaultOptions).build();
        ImageLoader.getInstance().init(config);
*/
        villesWeather = new ArrayList<>();
        View view = null;
        VilleWeatherDAO dao = new VilleWeatherDAO(view);

    //    VilleWeatherDAO dao = new VilleWeatherDAO(view);


       // boolean medenine = villesWeather.add(new villesWeather("medenine", 6.6101378, 16.4389275));
        for (VilleWeather v : dao.select()) {
           villesWeather.add(v);
           // dao.deleteAll(v);
            System.out.println(v);
          //  ImageLoader.getInstance().displayImage("http://openweathermap.org/img/w/" + v.getIcon() + ".png",
                  //  icon1);

        }




        //  listView.setAdapter((ListAdapter) dd);
        VilleWeatherAdapter dd = new VilleWeatherAdapter(this,villesWeather);
        list1.setAdapter(dd);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                villesWeather = new ArrayList<>();

                VilleWeatherDAO dao = new VilleWeatherDAO(view);

                for (VilleWeather v : dao.select()) {
                    //  villesWeather.add(v);
                    dao.deleteAll(v);
             //       new Delete().from(Item.class).where("Id = ?", 1).execute();
                    System.out.println(v);
                    Intent toto = new Intent(AfficheDB.this, MainActivity.class);
                    startActivity(toto);
                    //  ImageLoader.getInstance().displayImage("http://openweathermap.org/img/w/" + v.getIcon() + ".png",
                    //  icon1);

                }
            }
        });





        list1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View v,
                                           int index, long arg3) {
     String  selectedItem = list1.getItemAtPosition(index).toString();

              //  Toast.makeText(getApplicationContext(), ""+selectedItem+"", Toast.LENGTH_SHORT).show();
              //  new Delete().from(VilleWeather.class, index).execute();
                new Delete().from(VilleWeather.class).where("Id = ?", 1).execute();
              //  list1.setAdapter(dd);
                // VilleWeather weather = villesWeather.get(index);
              //  VilleWeather.delete(index);
                return false;
            }
        });









    }

    protected void RemoveItem(String item) {


    }


}
