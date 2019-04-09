package com.example.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private Button btnVolver;

    private void ToastLLamada(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ObtenerReferencias();

        SetearListeners();

        Intent elIntent = getIntent();
        Bundle Datos = elIntent.getExtras();
        String MensajeParametro = Datos.getString(MainActivity.PARAMTEXTO);
        ToastLLamada(MensajeParametro);
    }
    private void SetearListeners() {
        btnVolver.setOnClickListener(btnVolver_Click);
    }

    private View.OnClickListener btnVolver_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };//Fin de la funcion onClickListener

    private void ObtenerReferencias() {
        btnVolver = (Button)findViewById(R.id.btnVolver);
    }

}
