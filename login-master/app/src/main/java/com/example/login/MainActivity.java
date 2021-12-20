package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText txtusuario;
    private EditText txtpassword;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtusuario = (EditText) findViewById(R.id.txtusuario);
        txtpassword = (EditText) findViewById(R.id.txtpassword);

        preferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
        editor = preferences.edit();

        if (preferences.contains("userP")){
            Intent intent = new Intent(this, Bienvenida.class);
            startActivity(intent);
            finish();
        }
    }
    public void guardarDatos(View view){
        String Usuario = txtusuario.getText().toString();
        String Pass = txtpassword.getText().toString();

        editor.putString("userP", Usuario);
        editor.putString("passP", Pass);
        editor.commit();

        Intent intent = new Intent(this, Bienvenida.class);
        startActivity(intent);
        finish();

    }
}