package test.test2;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by ODC-5 on 18/11/2015.
 */
public class MyApp extends Application {


    public void onCreate() {
        super.onCreate();

        ActiveAndroid.initialize(this);
    }




}
