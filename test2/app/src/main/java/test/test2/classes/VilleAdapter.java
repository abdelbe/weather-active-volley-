package test.test2.classes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import test.test2.R;

/**
 * Created by ODC-5 on 17/11/2015.
 */
public class VilleAdapter extends BaseAdapter {

    List<Ville> villes;
    Activity context;
    private LayoutInflater inflater = null;
    /**
     * Constructor
     * c: context
     * depense: list of depenses
     **/
    public VilleAdapter(Activity c, List<Ville> villes ){
        context = c;
        this.villes = villes;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    public int getCount() {
        return villes.size();
    }


    public Object getItem(int position) {
        return position;
    }


    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        TextView tv_name,tv_position;

    }


    public View getView(final int position, View convertView, ViewGroup parent) {
        final Holder holder = new Holder();
        View rowView = inflater.inflate(R.layout.item_ville, null);

        holder.tv_name = (TextView) rowView.findViewById(R.id.tv_ville_name);
        holder.tv_position = (TextView) rowView.findViewById(R.id.tv_ville_position);

        holder.tv_name.setText(villes.get(position).getName());
        holder.tv_position.setText("(" + villes.get(position).getLat()
                + "," + villes.get(position).getLng()+")");

        return rowView;
    }







}
