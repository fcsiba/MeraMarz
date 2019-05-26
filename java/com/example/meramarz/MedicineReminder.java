package com.example.meramarz;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MedicineReminder extends Fragment {

    RadioGroup radioGroup;
    RadioButton radioButton;
    Button button;
    String radioselect, medicinename, number, morning = "false", afternoon = "false", night = "false";
    EditText medicine;
    String ServerURL = "http://meramarz.000webhostapp.com/setReminder.php" ;
    CheckBox morningcheck, afternooncheck, nightcheck;

    public MedicineReminder() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_medicine_reminder, container, false );
        medicine = (EditText) view.findViewById(R.id.medicinename);
        radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        button = (Button) view.findViewById(R.id.remindme);
        morningcheck = (CheckBox) view.findViewById(R.id.checkBox);
        afternooncheck = (CheckBox) view.findViewById(R.id.checkBox1);
        nightcheck = (CheckBox) view.findViewById(R.id.checkBox2);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioButton:
                        // do operations specific to this selection
                        radioButton = (RadioButton) view.findViewById(R.id.radioButton);
                        radioselect = radioButton.getText().toString();
                        break;
                    case R.id.radioButton1:
                        // do operations specific to this selection
                        radioButton = (RadioButton) view.findViewById(R.id.radioButton1);
                        radioselect = radioButton.getText().toString();
                        break;
                    case R.id.radioButton2:
                        // do operations specific to this selection
                        radioButton = (RadioButton) view.findViewById(R.id.radioButton2);
                        radioselect = radioButton.getText().toString();
                        break;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                    medicinename = medicine.getText().toString();

                    if(morningcheck.isChecked()){
                        morning = "true";
                    }

                    if(afternooncheck.isChecked()){
                        afternoon = "true";
                    }

                    if(nightcheck.isChecked()){
                        night = "true";
                    }

                    number = ((MeriAdwiyaat)getActivity()).getNumer();

                    InsertData(number, medicinename, radioselect,morning, afternoon, night );
                }




        });
        return view;
    }

    public void InsertData(final String number, final String medicinename, final String radioselect, final String morning, final String afternoon,  final String night ){

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String NumberHolder = number ;
                String NameHolder = medicinename ;
                String QuantityHolder = radioselect;
                String MorningHolder = morning;
                String AfternoonHolder = afternoon;
                String NightHolder = night;

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("number", NumberHolder));
                nameValuePairs.add(new BasicNameValuePair("medicinename", NameHolder));
                nameValuePairs.add(new BasicNameValuePair("radioselect", QuantityHolder));
                nameValuePairs.add(new BasicNameValuePair("morning", MorningHolder));
                nameValuePairs.add(new BasicNameValuePair("afternoon", AfternoonHolder));
                nameValuePairs.add(new BasicNameValuePair("night", NightHolder));

                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(ServerURL);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse httpResponse = httpClient.execute(httpPost);

                    HttpEntity httpEntity = httpResponse.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "Data Inserted Successfully";
            }

            @Override
            protected void onPostExecute(String result) {

                super.onPostExecute(result);

                Toast.makeText(getActivity(), "Your reminder has been set!!", Toast.LENGTH_LONG).show();


            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        sendPostReqAsyncTask.execute(number, medicinename, radioselect, morning, afternoon, night);
    }

}
