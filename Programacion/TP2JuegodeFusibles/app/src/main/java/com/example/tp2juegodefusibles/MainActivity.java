package com.example.tp2juegodefusibles;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.concurrent.Executor;


public class MainActivity extends AppCompatActivity {

    public static final String PAREMETER1 = "com.example.tp2juegodefusibles.PARAMETRO1";
    private static final String SITE_KEY_CAPTCHA = "6LeHRp4UAAAAACz1xdU6fay3zBWCq-IHlGjEo6nR";
    private static final String SECRET_KEY_CAPTCHA = "6LeHRp4UAAAAAM8oAU9gMdbcH2ThsImfAnraIe7G";
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
            }else {
                IniciarGame();
                /*
                SafetyNet.getClient(this).verifyWithRecaptcha(SITE_KEY_CAPTCHA)
                        .addOnSuccessListener((Executor) this,
                                new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {

                                    public void onSuccess(SafetyNetApi.RecaptchaTokenResponse response) {
                                        // Indicates communication with reCAPTCHA service was
                                        // successful.
                                        String userResponseToken = response.getTokenResult();
                                        if (!userResponseToken.isEmpty()) {
                                            // Validate the user response token using the
                                            // reCAPTCHA siteverify API.
                                        }
                                    }
                                })
                        .addOnFailureListener((Executor) this, new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                if (e instanceof ApiException) {
                                    // An error occurred when communicating with the
                                    // reCAPTCHA service. Refer to the status code to
                                    // handle the error appropriately.
                                    ApiException apiException = (ApiException) e;
                                    int statusCode = apiException.getStatusCode();

                                } else {
                                    // A different, unknown type of error occurred.

                                }
                            }
                        });*/
            }

        }

        public void IniciarGame() {

            EditText edtUser = (EditText) findViewById(R.id.edtUser);
            Intent NewActivity = new Intent(MainActivity.this, GameActivity.class);
            Bundle datos = new Bundle();
            datos.putString(MainActivity.PAREMETER1, edtUser.getText().toString());
            NewActivity.putExtras(datos);
            startActivity(NewActivity);
        }
    };
}