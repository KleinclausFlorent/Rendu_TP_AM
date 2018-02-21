package com.florentgmail.kleinclaus.kleinclausflorent_tp_interfacesimple;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kleinclaus Florent on 17/02/2018.
 * But : Indiquer au listview quoi afficher et où l'afficher
 * Entrée : context, tableau des sports, la viewlist
 * Sortie : info du tableau placer dans la vue
 */

public class SportAdapter extends ArrayAdapter<SportClass> {

    private ArrayList<SportClass> sportList;
    private Context context;
    private  int viewRes;
    private Resources res;

    public SportAdapter(Context context, int textViewResourceId,ArrayList<SportClass> sports) {
        super(context, textViewResourceId,sports);
        this.sportList = sports;
        this.context = context;
        this.viewRes = textViewResourceId;
        this.res = context.getResources();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent,false);
        }

        TextView  title = view.findViewById(R.id.title);
        title.setText(sportList.get(position).getSportName());

        ImageView icon = view.findViewById(R.id.icon);
        icon.setImageResource(sportList.get(position).getImgRes());

        return view;

    }
}
