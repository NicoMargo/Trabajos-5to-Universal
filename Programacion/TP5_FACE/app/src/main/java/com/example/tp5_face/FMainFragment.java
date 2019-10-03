package com.example.tp5_face;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FMainFragment extends Fragment {

    View rootView;
    Button btnCamera;
    Button btnStorage;

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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        if(requestCode == CODE_PERMISSION_REQUEST);
        boolean boolPermissionsGranted = true;
        int i = 0;
        while(i < permissions.length && boolPermissionsGranted){
            boolPermissionsGranted &= (grantResults[i] != PackageManager.PERMISSION_GRANTED);
            i++;
        }
        if(boolPermissionsGranted){
            btnCamera.setEnabled(true);
        }
    }

    private void getReferences(){
        btnCamera = rootView.findViewById(R.id.btnCamera);
        btnStorage = rootView.findViewById(R.id.btnStorage);
    }

    private void setListeners(){
        btnCamera.setOnClickListener(btnCamera_Click);
        btnStorage.setOnClickListener(btnStorage_Click);
    }

    public View.OnClickListener btnCamera_Click = new View.OnClickListener(){
        public void onClick(View v){
            startCameraActivity();
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
}