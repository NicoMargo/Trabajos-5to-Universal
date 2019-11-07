package com.example.tp6_light2;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.hardware.Camera;

public class MainActivity extends AppCompatActivity {

    Button btnPower;
    ImageView imgFlashlight;
    CheckBox chkClock;
    SeekBar skbSeekBar;
    Camera camera;
    private boolean state = false;
    private boolean hasFlash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hasFlash = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        getReference();
        setListeners();

    }

    private void getReference(){
        btnPower = findViewById(R.id.btnPower);
        imgFlashlight = findViewById(R.id.imgFlashlight);
        chkClock = findViewById(R.id.chkClock);
        skbSeekBar = findViewById(R.id.skbSeekBar);
    }
    private void setListeners(){
        btnPower.setOnClickListener(btnPower_Click);
        skbSeekBar.setOnClickListener(skbSeekBar_click);
    }

    private void turnOnLight(){
        camera = Camera.open();
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
        camera.startPreview();
    }
    private void turnOffLight(){
        camera = Camera.open();
        Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameters);
        camera.stopPreview();
        camera.release();
    }

    private View.OnClickListener  btnPower_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!state){
                btnPower.setBackgroundResource(R.drawable.btnon);
                imgFlashlight.setImageResource(R.drawable.lighton);
                turnOnLight();
                state = true;
            }else{
                imgFlashlight.setImageResource(R.drawable.lightoff);
                btnPower.setBackgroundResource(R.drawable.btnoff);
                turnOffLight();
                state = false;
            }
        }
    };

    private View.OnClickListener  skbSeekBar_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };





}
