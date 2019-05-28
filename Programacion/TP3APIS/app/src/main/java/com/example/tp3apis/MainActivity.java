package com.example.tp3apis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnByCat;
    Button btnByName;
    Button btnByGeo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void getReferences(){
        btnByCat  = (Button) findViewById(R.id.btnByCat);
        btnByName = (Button) findViewById(R.id.btnByName);;
        btnByGeo  = (Button) findViewById(R.id.btnByGeo);;
    }

    void setListeners(){
        btnByCat.setOnClickListener(btnByCat_Click);
        btnByName.setOnClickListener(btnByName_Click);
        btnByGeo.setOnClickListener(btnByGeo_Click);
    }

    View.OnClickListener btnByCat_Click = new View.OnClickListener(){
        public void onClick(View v){

        }
    };

    View.OnClickListener btnByName_Click = new View.OnClickListener(){
        public void onClick(View v){

        }
    };

    View.OnClickListener btnByGeo_Click = new View.OnClickListener(){
        public void onClick(View v){

        }
    };

    void StartNewActivity(AppCompatActivity activity){
        Intent newIntent = new Intent(MainActivity.this,activity.getClass());
        Bundle data = new Bundle();
        newIntent.putExtra(data);
        StartNewActivity(newIntent);
    }
}
