package test.test2.classes;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import test.test2.R;

/**
 * Created by ODC-5 on 19/11/2015.
 */
public class VilleWeatherAdapter extends BaseAdapter {

    public List<VilleWeather> villesWeather;
    Activity context;
    private LayoutInflater inflater = null;
    /**
     * Constructor
     * c: context
     * depense: list of depenses
     **/
    public VilleWeatherAdapter(Activity c, List<VilleWeather> villesWeather ){
        context = c;
        this.villesWeather = villesWeather;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public int getCount() {
        return villesWeather.size();
    }


    public Object getItem(int position) {
        return position;
    }


    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        TextView tv_name,tv_position;
public ImageView icon1;
    }


    public View getView(final int position, View convertView, ViewGroup parent) {
        final Holder holder = new Holder();
        View rowView = inflater.inflate(R.layout.item_weather, null);

        holder.tv_name = (TextView) rowView.findViewById(R.id.tv_ville_name);
        holder.tv_position = (TextView) rowView.findViewById(R.id.tv_ville_position);


      //  holder.icon1 = (ImageView) rowView.findViewById(R.id.icon);


        holder.tv_name.setText(villesWeather.get(position).getName());
        holder.tv_position.setText("(" + villesWeather.get(position).getLat()
                + "," + villesWeather.get(position).getLng() + ")");
        String img= villesWeather.get(position).getIcon();
        Picasso.with(context).load("http://openweathermap.org/img/w/" + img + ".png").into((ImageView) rowView.findViewById(R.id.icon));


        return rowView;
    }







}







