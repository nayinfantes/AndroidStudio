package com.example.feedback22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.lv);
        TextView tv = findViewById(R.id.tv);

        String [] pais = new String[] {"ESPAÑA", "URUGUAY", "UGANDA", "TANZANIA", "MEXICO",
                                        "KOREA", "SUDÁFRICA", "BRASIL", "FRANCIA", "ITALIA"};
        String [] hab = new String[] {"47.435.597", "3.485.152", "42.460.000", "61.498.438", "130.262.220",
                                    "51.628.117", "60.143.000", "213.993.441", "67.800.000", "59.236.213"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.list_item_pais, pais);

        lv.setAdapter(adaptador);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                tv.setText(lv.getItemAtPosition(i).toString());

                return true;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent in = new Intent(MainActivity.this, MainActivity2.class);

                in.putExtra("data", lv.getItemAtPosition(i).toString());

                in.putExtra("data2", hab[i]);

                startActivity(in);
            }
        });
    }
}




