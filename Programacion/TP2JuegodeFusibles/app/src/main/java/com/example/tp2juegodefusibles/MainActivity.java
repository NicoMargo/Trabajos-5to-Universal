package com.example.tp2juegodefusibles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(btnStart_Click);
    }

    private View.OnClickListener btnStart_Click = new View.OnClickListener() {
        public void onClick(View v) {
            EditText edtUser = (EditText) findViewById(R.id.edtUser);
            String sUsername = edtUser.getText().toString();
            if (sUsername.matches("")){
                Toast.makeText(getApplicationContext(), "Ingrese un Nombre de usuario", Toast.LENGTH_LONG).show();
            }

        }
    };
}