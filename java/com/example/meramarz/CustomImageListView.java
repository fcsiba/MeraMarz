package com.example.meramarz;


import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomImageListView extends ArrayAdapter<String> {
        private String[] urls;
        private Bitmap[] bitmaps;
        private Activity context;

        public CustomImageListView(Activity context, String[] urls, Bitmap[] bitmaps) {
            super(context, R.layout.activity_customlistview, urls);
            this.context = context;
            this.urls= urls;
            this.bitmaps= bitmaps;
        }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_customlistview, null, true);
        TextView textViewURL = (TextView) listViewItem.findViewById(R.id.textViewURL);
        ImageView image = (ImageView) listViewItem.findViewById(R.id.imageDownloaded);

        textViewURL.setText(urls[position]);
        image.setImageBitmap(Bitmap.createScaledBitmap(bitmaps[position],100,50,false));
        return  listViewItem;
    }


}
