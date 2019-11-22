package com.example.tp6_light2;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.CheckBox;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity {

    Button btnPower;
    ImageView imgFlashlight;
    CheckBox chkClock;
    SeekBar skbSeekBar;
    private final int CAMERA_REQUEST = 50;
    private boolean state = false;
    private boolean hasFlashCamara;
    private static Timer timer = new Timer();
    private SharedPreferences myPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CAMERA}, CAMERA_REQUEST);
        hasFlashCamara = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        PackageManager pm = this.getApplicationContext().getPackageManager();
        hasFlashCamara &= pm.hasSystemFeature(PackageManager.FEATURE_CAMERA);
        if (hasFlashCamara) {
            getReference();
            setListeners();
        } else {
            Toast.makeText(MainActivity.this, "No hay flash xdd",
                    Toast.LENGTH_SHORT).show();
        }

    }

    private void getReference(){
        myPreferences = getSharedPreferences("MyPreferences",Context.MODE_PRIVATE);
        btnPower = findViewById(R.id.btnPower);
        imgFlashlight = findViewById(R.id.imgFlashlight);
        chkClock = findViewById(R.id.chkClock);
        boolean checked = myPreferences.getBoolean("checked",false);
        chkClock.setChecked(checked);
        chkClock_click.onCheckedChanged(chkClock,chkClock.isChecked());
        skbSeekBar = findViewById(R.id.skbSeekBar);
        int time = myPreferences.getInt("time",1);
        skbSeekBar.setProgress(time);
        skbSeekBar.incrementProgressBy(1);
        skbSeekBar.setMax(10);
    }
    private void setListeners(){
        btnPower.setOnClickListener(btnPower_Click);
        chkClock.setOnCheckedChangeListener(chkClock_click);
        skbSeekBar.setOnSeekBarChangeListener(skbSeekBar_onChange);
    }

    public void MyTimer() {
        TimerTask task;
        task = new TimerTask() {
            private int tics = 0;
            @Override
            public void run() {
                if(chkClock.isChecked()){
                    if(tics % myPreferences.getInt("time",1) ==0 && tics>0) {
                        if (!state){
                            imgFlashlight.setImageResource(R.drawable.lighton);
                            turnOnLight();
                            state = true;
                        }else{
                            imgFlashlight.setImageResource(R.drawable.lightoff);
                            turnOffLight();
                            state = false;
                        }
                        tics = 0;
                    }else{
                        tics++;
                    }
                }else{
                    cancel();
                }
            }
        };
        timer.schedule(task,0,500);
    }

    public void turnOnLight(){
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
            MediaPlayer mp = MediaPlayer.create(this, R.raw.ora);
            mp.start();
        } catch (CameraAccessException e) {
        }
    }

    public void turnOffLight(){
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
        } catch (CameraAccessException e) {
        }
    }
    public SeekBar.OnSeekBarChangeListener skbSeekBar_onChange = new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            SharedPreferences.Editor editor;
            editor = myPreferences.edit();
            editor.putInt("time", progress+1);
            editor.commit();
        }
    };
    private CheckBox.OnCheckedChangeListener chkClock_click = new CheckBox.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            SharedPreferences.Editor editor;
            editor = myPreferences.edit();
            editor.putBoolean("checked", isChecked);
            editor.commit();
            if(isChecked){MyTimer();}
        }
    };

    private View.OnClickListener  btnPower_Click = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onClick(View v) {
            if (!state){
                imgFlashlight.setImageResource(R.drawable.lighton);
                btnPower.setBackgroundResource(R.drawable.btnon);
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

}
