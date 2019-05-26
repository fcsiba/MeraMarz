package com.example.meramarz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Medicines> {

    int groupid;
    ArrayList<Medicines> records;
    Context context;

    public CustomAdapter(Context context, int vg, int id, ArrayList<Medicines>
            records) {
        super(context, vg, id, records);
        this.context = context;
        groupid = vg;
        this.records = records;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(groupid, parent, false);

        TextView textName = (TextView) itemView.findViewById(R.id.pro_name);

        textName.setText(records.get(position).getMedicine());

        TextView textPrice = (TextView) itemView.findViewById(R.id.pro_uprice);

        textPrice.setText(records.get(position).getQuantity());

        return itemView;

    }

}

