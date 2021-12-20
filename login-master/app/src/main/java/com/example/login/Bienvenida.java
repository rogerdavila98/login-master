package com.example.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Bienvenida extends AppCompatActivity {
    private TextView tvBienvenida;
    private SharedPreferences preferences_2;
    private SharedPreferences.Editor editor_2;

    @Override
    public void onCreate(Bundle savedInstanceState ){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layaout_bienvenida);

        tvBienvenida = (TextView) findViewById(R.id.datos);
        preferences_2 = getSharedPreferences("Login", Context.MODE_PRIVATE);
        editor_2 = preferences_2.edit();

        mostrarDatos();
    }
    private void mostrarDatos(){
        String userP_2 = preferences_2.getString("userP", "null");
        String passP_2 = preferences_2.getString("passP", "null");

        tvBienvenida.setText("USUARIO : "+userP_2+"\n PASSWORD : "+passP_2);

    }
    public void finalizarSesion(View view){
        editor_2.clear();
        editor_2.commit();

    }
}
