package com.example.meramarz;


import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TableRow.LayoutParams;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewMedicine extends Fragment {

    Activity context;
    HttpPost httppost;
    StringBuffer buffer;
    HttpResponse response;
    HttpClient httpclient;
    ProgressDialog pd;
    CustomAdapter adapter;
    ListView listProduct;
    ArrayList<Medicines> records;

    public ViewMedicine() {
        // Required empty public constructor
    }



    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_view_medicine, container, false );
        context = getActivity();
        records=new ArrayList<Medicines>();
        listProduct=(ListView)view.findViewById(R.id.product_list);
        adapter=new CustomAdapter(context, R.layout.medicinelist,R.id.pro_name,
                records);
        listProduct.setAdapter(adapter);

        onStart();

        return view;

    }

    public void onStart(){

        super.onStart();
        //execute background task
        BackTask bt=new BackTask();
        bt.execute();
    }

    private class BackTask extends AsyncTask<Void,Void,Void> {

        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(context);
            pd.setTitle("Retrieving data");
            pd.setMessage("Please wait.");
            pd.setCancelable(true);
            pd.setIndeterminate(true);
            pd.show();


        }

        protected Void doInBackground(Void... params) {


            InputStream is = null;

            String result = "";

            try {


                httpclient = new DefaultHttpClient();

                httppost = new HttpPost("http://meramarz.000webhostapp.com/getMedicines.php");

                response = httpclient.execute(httppost);

                HttpEntity entity = response.getEntity();

                // Get our response as a String.

                is = entity.getContent();


            } catch (Exception e) {


                if (pd != null)

                    pd.dismiss(); //close the dialog if error occurs

                Log.e("ERROR", e.getMessage());


            }

            try {

                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"), 8);

                StringBuilder sb = new StringBuilder();

                String line = null;

                while ((line = reader.readLine()) != null) {

                    sb.append(line + "\n");

                }

                is.close();

                result = sb.toString();

            } catch (Exception e) {

                Log.e("ERROR", "Error converting result " + e.toString());


            }

            try {

                // Remove unexpected characters that might be added to beginning of the


                result = result.substring(result.indexOf("["));

                JSONArray jArray = new JSONArray(result);

                for (int i = 0; i < jArray.length(); i++) {

                    JSONObject json_data = jArray.getJSONObject(i);

                    Medicines p = new Medicines();

                    p.setMedicine(json_data.getString("medicine"));

                    p.setQuantity(json_data.getString("quantity"));


                    records.add(p);


                }


            } catch (Exception e) {

                Log.e("ERROR", "Error pasting data " + e.toString());


            }

            return null;

        }


        protected void onPostExecute(Void result) {


            if (pd != null) pd.dismiss(); //close dialog

            Log.e("size", records.size() + "");

            adapter.notifyDataSetChanged(); //notify the ListView to get new records


        }

    }






        }
