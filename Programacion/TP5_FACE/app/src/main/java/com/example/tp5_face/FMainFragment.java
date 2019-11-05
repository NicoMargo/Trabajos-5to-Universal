package com.example.tp5_face;


import android.Manifest;
import android.app.FragmentManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class FMainFragment extends Fragment {


    View rootView;
    Button btnAnalyze;
    Button btnCamera;
    Button btnStorage;
    ImageView imgResult;
    Bitmap imageResult;
    private final int CODE_CAMERA_ACTIVITY = 1;
    private final int CODE_STORAGE_ACTIVITY = 2;
    private final int CODE_PERMISSION_REQUEST = 3;
    public FMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_fmain, container, false);
        getReferences();
        setListeners();
        checkPermissions();
        // Inflate the layout for this fragment
        return rootView;
    }

    void checkPermissions(){
        if(ContextCompat.checkSelfPermission(rootView.getContext(), Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            btnCamera.setEnabled(false);
            ActivityCompat.requestPermissions( this.getActivity() ,new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},CODE_PERMISSION_REQUEST);
        }else{
            btnCamera.setEnabled(true);
        }
    }

    private void getReferences(){
        btnCamera = rootView.findViewById(R.id.btnCamera);
        btnStorage = rootView.findViewById(R.id.btnStorage);
        imgResult = rootView.findViewById(R.id.imgResult);
        btnAnalyze = rootView.findViewById(R.id.btnAnalize);
    }

    private void setListeners(){
        btnCamera.setOnClickListener(btnCamera_Click);
        btnStorage.setOnClickListener(btnStorage_Click);
        btnAnalyze.setOnClickListener(btnAnalyze_Click);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        if(requestCode == CODE_PERMISSION_REQUEST) {
            boolean boolPermissionsGranted = true;
            int i = 0;
            while (i < permissions.length && boolPermissionsGranted) {
                boolPermissionsGranted &= (grantResults[i] != PackageManager.PERMISSION_GRANTED);
                i++;
            }
            if (boolPermissionsGranted) {
                btnCamera.setEnabled(true);
            }
        }
        Log.d("hola","xd");
    }


    public View.OnClickListener btnCamera_Click = new View.OnClickListener(){
        public void onClick(View v){
            startCameraActivity();
        }
    };
    public View.OnClickListener btnAnalyze_Click = new View.OnClickListener(){
        public void onClick(View v){
            if (imageResult != null) {
                FragmentManager adminFragment;
                FragmentTransaction transacFragment;
                FRecognitionFragment fragmentResults = new FRecognitionFragment();
                ((FRecognitionFragment) fragmentResults).setImg(imageResult);
                adminFragment = getFragmentManager();
                transacFragment = adminFragment.beginTransaction();
                transacFragment.replace(R.id.lytMain, fragmentResults);
                Log.d("Main Fragment 2", "Main Fragment 2");
                transacFragment.commit();
            }else{
                Toast.makeText(rootView.getContext(), "Seleccione una foto", Toast.LENGTH_LONG).show();
            }
        }
    };
    public View.OnClickListener btnStorage_Click = new View.OnClickListener(){
        public void onClick(View v){
            startStorageActivity();
        }
    };

    private void startCameraActivity(){
        Intent intentCamera = new   Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentCamera,CODE_CAMERA_ACTIVITY);
    }

    private void startStorageActivity(){
        Intent intentStorage = new   Intent(Intent.ACTION_GET_CONTENT);
        intentStorage.setType("image/*");
        startActivityForResult(Intent.createChooser(intentStorage,"Seleccione foto"),CODE_STORAGE_ACTIVITY);
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode, Intent intent ){
        super.onActivityResult( requestCode, resultCode, intent);
        if(requestCode == CODE_CAMERA_ACTIVITY){
            imageResult = (Bitmap) intent.getExtras().get("data");
            imgResult.setImageBitmap(imageResult);
        }else if(requestCode ==CODE_STORAGE_ACTIVITY && intent!=null  ){
            Uri location = intent.getData();
            ContentResolver resolver = getActivity().getContentResolver();
            try {
                imageResult = MediaStore.Images.Media.getBitmap(resolver,location);
                imgResult.setImageBitmap(imageResult);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
