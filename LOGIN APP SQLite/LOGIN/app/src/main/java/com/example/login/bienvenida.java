package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class bienvenida extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);
        Bundle miBundle =getIntent().getExtras();
        TextView muestraUserName = findViewById(R.id.muestrausername);
        String userNameIntent;
        userNameIntent = miBundle.getString("username");
        muestraUserName.setText(userNameIntent);
    }
}

