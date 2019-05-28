package com.example.tp2juegodefusibles;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.security.PublicKey;
import java.util.Random;
import java.util.concurrent.Executor;


public class MainActivity extends AppCompatActivity {

    public static final String PAREMETER1 = "com.example.tp2juegodefusibles.PARAMETRO1";
    Random RandomNum = new Random();
    public int iNum1 = RandomNum.nextInt(9);
    public int iNum2 = RandomNum.nextInt(9);
    private EditText edtUser;
    private Button btnStart;
    private EditText edtCaptcha;
    private  TextView txtCaptcha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReferences();
        Random();
        btnStart.setOnClickListener(btnStart_Click);
    }
    private void getReferences(){
        btnStart = (Button) findViewById(R.id.btnStart);
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtCaptcha = (EditText) findViewById(R.id.edtCaptcha);
        edtUser = (EditText) findViewById(R.id.edtUser);
        txtCaptcha = (TextView) findViewById(R.id.txtCaptcha);
    }



    private View.OnClickListener btnStart_Click = new View.OnClickListener() {

        public void onClick(View v) {

            String sUsername = edtUser.getText().toString();
            int ValueUser;

            if (edtCaptcha.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "Ingrese el resultado de la suma", Toast.LENGTH_LONG).show();
            }else {
                try {
                    ValueUser = Integer.parseInt(edtCaptcha.getText().toString());
                    if (sUsername.matches("")){
                        Toast.makeText(getApplicationContext(), "Ingrese un Nombre de usuario", Toast.LENGTH_LONG).show();
                    }else if(ValueUser != (iNum1 + iNum2)){
                        Toast.makeText(getApplicationContext(), "Suma de verificacion erronea", Toast.LENGTH_LONG).show();
                    }else{
                        IniciarGame();
                    }
                }
                catch (NumberFormatException nfe){
                    Toast.makeText(getApplicationContext(), "Ingrese solamente numeros", Toast.LENGTH_LONG).show();
                }
            }
        }

    };
	public void IniciarGame() {


		Intent NewActivity = new Intent(MainActivity.this, GameActivity.class);
		Bundle datos = new Bundle();
		datos.putString(MainActivity.PAREMETER1, edtUser.getText().toString());
		NewActivity.putExtras(datos);
		startActivity(NewActivity);
	}
    public void Random(){

        txtCaptcha.setText("Ingrese la suma de " + iNum1 + " + " + iNum2);
    }
}