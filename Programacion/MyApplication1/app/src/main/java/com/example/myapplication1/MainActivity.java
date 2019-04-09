package com.example.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnTest;
    private EditText edtName;
    private EditText edtMail;
    private RadioGroup rgpSexo;
    private SeekBar skbSatisfaction;
    private CheckBox chkSport;
    public  static final String PARAMTEXTO = "com.example.myapplication1.Texto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ObtenerReferencias();

        SetearListeners();
    }

    private void SetearListeners() {
        btnTest.setOnClickListener(btnTest_Click);
    }

    private View.OnClickListener btnTest_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Desarrollo();
        }
    };//Fin de la funcion onClickListener

    private void ObtenerReferencias() {
        btnTest = (Button) findViewById(R.id.btnTest);
        edtName = (EditText) findViewById(R.id.edtName);
        edtMail = (EditText)  findViewById(R.id.edtMail);
        rgpSexo = (RadioGroup) findViewById(R.id.rgpSexo);
        skbSatisfaction = (SeekBar)  findViewById(R.id.skbSatisfaction);
        chkSport = (CheckBox)  findViewById(R.id.chkDeporte);
    }

    private void Desarrollo(){
        String sSexo;
        String sMsgSport;
        if(edtName.getText().toString().length()==0){
            ToastLLamada("Ingrese su Nombre");
        }else if (edtMail.getText().toString().length()==0) {
            ToastLLamada("Ingrese su Email");
        }else {

            switch (rgpSexo.getCheckedRadioButtonId()) {
                case R.id.rbtMasculino:
                    sSexo = "Masculino";
                    break;
                case R.id.rbtFemenino:
                    sSexo = "Femenino";
                    break;
                default:
                    sSexo = "Trapo";
            }
            if (chkSport.isChecked()) {
                sMsgSport = "\nSi Hace Deporte";
            } else {
                sMsgSport = "\nNo Hace Deporte";
            }
            String msg = "Nombre: " + edtName.getText().toString() + "\n Mail:" + edtMail.getText().toString() + "\n Sexo:" + sSexo + "\n Level de Satisfacchon:" + skbSatisfaction.getProgress() + sMsgSport;
            IniciarSegundaActividad(msg);
        }
    }

    private void ToastLLamada(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    private void IniciarSegundaActividad(String msg){
        Intent nuevaActividad = new Intent(this, MainActivity2.class);
        //Pasar parametros xd
        Bundle datos = new Bundle();
        datos.putString(MainActivity.PARAMTEXTO, msg);
        nuevaActividad.putExtras(datos);
        startActivity(nuevaActividad);
    }

}
