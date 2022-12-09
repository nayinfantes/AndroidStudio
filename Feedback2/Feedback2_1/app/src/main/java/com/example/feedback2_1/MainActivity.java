package com.example.feedback2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ref radiogroup
        RadioGroup RG=findViewById(R.id.rg);

        //Ref imageview

        ImageView IV=findViewById(R.id.iv);

        RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i) {

                    case R.id.es:
                        IV.setImageResource(R.drawable.espania);
                        break;
                    case R.id.ur:
                        IV.setImageResource(R.drawable.uruguay);
                        break;
                    case R.id.ug:
                        IV.setImageResource(R.drawable.uganda);
                        break;
                    case R.id.tz:
                        IV.setImageResource(R.drawable.tanzania);
                        break;
                    case R.id.mex:
                        IV.setImageResource(R.drawable.mexico);
                        break;
                    case R.id.ko:
                        IV.setImageResource(R.drawable.korea);
                        break;
                    case R.id.sa:
                        IV.setImageResource(R.drawable.safrica);
                        break;
                    case R.id.br:
                        IV.setImageResource(R.drawable.brasil);
                        break;
                    case R.id.fr:
                        IV.setImageResource(R.drawable.francia);
                        break;
                    case R.id.it:
                        IV.setImageResource(R.drawable.italia);
                        break;
                }
            }
        });
    }
}