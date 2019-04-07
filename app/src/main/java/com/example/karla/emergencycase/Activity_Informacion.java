package com.example.karla.emergencycase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Activity_Informacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__informacion);


        WebView view = findViewById(R.id.webView);
        view.getSettings().setJavaScriptEnabled(true); //permite que las paginas funcionen
        view.getSettings().setBuiltInZoomControls(true); // permite el zoom si la pagina no es respons
        view.loadUrl("http://proyectoec.herokuapp.com/");


        view.setWebViewClient(new WebViewClient(){
            public boolean shouldOverriceUrlLoading(WebView view, String url){
                return  false;
            }

        });

    }
}
