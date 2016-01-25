package test.test2 ;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import test.test2.classes.VilleAdapter;
import test.test2.classes.Ville;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

 public static final String KEY_ville = "ville";

    ListView listView;
    List<Ville> villes;
ImageView imgWeather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.list);
        villes = new ArrayList<>();
        villes.add(new Ville("medenine",6.6101378,16.4389275));
        villes.add(new Ville("tataouine",36,10));
        villes.add(new Ville("Sfax",36,4));
        villes.add(new Ville("Nabeul",7,10));
        villes.add(new Ville("Djerba",36,85));
        villes.add(new Ville("kef",45,10));


        VilleAdapter dd = new VilleAdapter(this,villes);
    //  listView.setAdapter((ListAdapter) dd);
        imgWeather = (ImageView) findViewById(R.id.icon);
        listView.setAdapter(dd);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
             intent.putExtra(KEY_ville,villes.get(i));
                startActivity(intent);
            }
        });
    }
}
