package test.test2.classes;

import java.io.Serializable;

/**
 * Created by ODC-5 on 17/11/2015.
 */
public class Ville implements Serializable {
  private   String name ;
    private double lat, lng ;

    public Ville(String name, double lat, double lng){

        this.name= name;
        this.lat=lat;
        this.lng=lng;

    }
    public String toString() {
        return "Ville{" +
                "name='" + name + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
