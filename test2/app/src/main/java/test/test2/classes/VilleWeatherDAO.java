package test.test2.classes;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by ODC-5 on 18/11/2015.
 */
public class VilleWeatherDAO {


    View view;

    public VilleWeatherDAO(View view){
        this.view = view;
    }

    public  void add(VilleWeather ville){
        ville.save();

    }
    public static void deleteAll(VilleWeather ville) {
        ville.delete();
    }


    public List<VilleWeather> select(){return new Select().from(VilleWeather.class).execute();
    }




}
