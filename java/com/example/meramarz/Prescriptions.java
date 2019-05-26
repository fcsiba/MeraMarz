package com.example.meramarz;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class Prescriptions extends Fragment implements View.OnClickListener {


    public Prescriptions() {
        // Required empty public constructor
    }

    public static final String UPLOAD_URL = "http://meramarz.000webhostapp.com/upload.php";
    public static final String GET_URL = "http://meramarz.000webhostapp.com/getAllImages.php";
    public static final String UPLOAD_KEY = "image";
    public static final String UPLOAD_NUM = "number";
    ImageView imageView;
    private Bitmap bitmap;
    Button saveimg,showimg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prescriptions, container, false );

        Button cameraBtn = (Button) view.findViewById(R.id.cameraBtn);
        imageView = (ImageView) view.findViewById(R.id.cameraimage);
        saveimg = (Button) view.findViewById(R.id.saveimg);
        showimg = (Button) view.findViewById(R.id.viewimg);

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });
        saveimg.setOnClickListener(this);
        showimg.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

         bitmap = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
    }

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    private void uploadImage(){
        class UploadImage extends AsyncTask<Bitmap,Void,String> {

            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(getActivity(), "Uploading...", null,true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getActivity().getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Bitmap... params) {
                Bitmap bitmap = params[0];
                String uploadImage = getStringImage(bitmap);

                HashMap<String,String> data = new HashMap<>();

                String number = ((MeriAdwiyaat)getActivity()).getNumer();
                data.put(UPLOAD_KEY, uploadImage);
                data.put(UPLOAD_NUM,number);
                String result = rh.sendPostRequest(UPLOAD_URL,data);

                return result;
            }
        }

        UploadImage ui = new UploadImage();
        ui.execute(bitmap);
    }

    @Override
    public void onClick(View v) {
        if(v == saveimg){
            uploadImage();
        }
        if(v == showimg){
            viewImage();
        }
    }

    private void viewImage() {

        Intent intentLoadNewActivity = new Intent(getActivity(), ImageListView.class);
        startActivity(intentLoadNewActivity);
    }
}
