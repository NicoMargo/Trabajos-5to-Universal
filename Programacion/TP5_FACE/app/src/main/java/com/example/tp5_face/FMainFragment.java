package com.example.tp5_face;


import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
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

    public FMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_fmain, container, false);
        getReferences();
        setListeners();
        // Inflate the layout for this fragment
        return rootView;
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

        }
    };

    public View.OnClickListener btnStorage_Click = new View.OnClickListener(){
        public void onClick(View v){

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
