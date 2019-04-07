package com.example.karla.emergencycase;

import android.content.Intent;
import android.support.design.internal.NavigationMenu;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.karla.emergencycase.R.id.contactos;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final MenuItem contact = findViewById(R.id.contactos);

        TextView registro = findViewById(R.id.registroLogin);
        Button btnLogin = findViewById(R.id.btnLogin);
        final EditText usuarioT = findViewById(R.id.usuarioLogin);
        final EditText claveT = findViewById(R.id.claveLogin);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent(Login.this, Registro.class);
                Login.this.startActivity(registro);
                finish();

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String usuario = usuarioT.getText().toString();
                final String clave = claveT.getText().toString();
                Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("success");
                            if(ok = true){
                                String nombre = jsonRespuesta.getString("nombre");
                                int edad = jsonRespuesta.getInt("edad");
                                Intent bienvenido = new Intent(Login.this, MainActivity.class);
                                bienvenido.putExtra("nombre", nombre);
                                bienvenido.putExtra("edad",edad);

                                Login.this.startActivity(bienvenido);
                                Login.this.finish();


                            }else{
                                AlertDialog.Builder alerta = new AlertDialog.Builder(Login.this);
                                alerta.setMessage("Fallo en el registro")
                                        .setNegativeButton("Reintentar", null)
                                        .create()
                                        .show();
                            }
                        }catch (JSONException e){
                            e.getMessage();
                        }
                    }
                };
                LoginRequest r = new LoginRequest(usuario,clave,respuesta);
                RequestQueue cola = Volley.newRequestQueue(Login.this);
                cola.add(r);

            }
        });


    }
}
