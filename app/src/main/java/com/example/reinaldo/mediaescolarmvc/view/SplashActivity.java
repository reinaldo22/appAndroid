package com.example.reinaldo.mediaescolarmvc.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.reinaldo.mediaescolarmvc.R;
import com.example.reinaldo.mediaescolarmvc.controller.MediaEscolarController;
import com.example.reinaldo.mediaescolarmvc.model.MediaEscolar;

public class SplashActivity extends AppCompatActivity {

    //Tempo de apresentação da tela Splash
    private static final int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        apresentarTelaSplash();

    }


    private void apresentarTelaSplash(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                MediaEscolar obj = new MediaEscolar();


                obj.setMateria("Matematica");
                obj.setBimestre("2º Bimestre");
                obj.setNotaProva(2);
                obj.setNotaMateria(2);
                obj.setMediaFinal(2);
                obj.setSituacao("Reprovado");

                MediaEscolarController mediaEscolarController = new MediaEscolarController(getBaseContext());

                obj.setId(4);
                mediaEscolarController.alterar(obj);


                Intent telaPrincipal
                        = new Intent(SplashActivity.this,
                        MainActivity.class);

                startActivity(telaPrincipal);

                finish();

            }
        },SPLASH_TIME_OUT);


    }

}
