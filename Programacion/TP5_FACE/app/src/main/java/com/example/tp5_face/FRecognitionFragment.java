package com.example.tp5_face;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.microsoft.projectoxford.face.FaceServiceRestClient;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class FRecognitionFragment extends Fragment {

    private View rootView;
    private FaceServiceRestClient ImageProcessor;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private Bitmap _img;
    public void setImg(Bitmap img){
        _img = img;
    }
    public FRecognitionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_frecognition, container, false);
        getReferences();
        setListeners();


        String strApiEndPoint = "https://brazilsouth.api.cognitive.microsoft.com/face/v1.0";
        String strSubscriptionKey = "ac23ad7228cc4b6fa251703fe91ded44";
        ImageProcessor = new FaceServiceRestClient(strApiEndPoint,strSubscriptionKey);
        processImage();

        return rootView;
    }

    private void getReferences() {
    }

    private void setListeners() {
    }

    private void processImage(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        _img.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        AsyncProcessImage async = new AsyncProcessImage(ImageProcessor);
        async.execute(inputStream);
    }
}
