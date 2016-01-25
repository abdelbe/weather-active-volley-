package test.test2.classes;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by ODC-5 on 18/11/2015.
 */
@Table(name = "Ville")
public class VilleWeather extends Model {

    @Column
    private String name;
    @Column
    private double lat;
    @Column
    private double lng;
    @Column
    private float temp;
    @Column
    private String desc;
    @Column
    private String icon;


    public VilleWeather(){}

    public VilleWeather(Ville ville, float temp, String desc, String icon) {
       this.name = ville.getName();
      this.lat = ville.getLat();
       this.lng = ville.getLng();

       // this.ville= ville
        this.temp = temp;
        this.desc = desc;
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "VilleWeather{" +
                "name='" + name + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", temp=" + temp +
                ", desc='" + desc + '\'' +
                ", icon='" + icon + '\'' +
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

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }








}
