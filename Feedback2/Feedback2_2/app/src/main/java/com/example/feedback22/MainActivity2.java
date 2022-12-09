package com.example.feedback22;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tvpais = findViewById(R.id.tvpais);
        TextView tvhab = findViewById(R.id.tvhab);

        Bundle bundle = getIntent().getExtras();

        String nPais = bundle.getString("data");
        String nHab = bundle.getString("data2");

        tvpais.setText(nPais);
        tvhab.setText(nHab);
    }
}