package com.example.feedback3_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaRecorder rec;
    String archivoSalida = null;
    Button botonRec;
    Chronometer crono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crono = (Chronometer) findViewById(R.id.crono);
        botonRec = (Button) findViewById(R.id.botonrec);
        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.RECORD_AUDIO)!= PackageManager.PERMISSION_GRANTED)
        {ActivityCompat.requestPermissions(MainActivity.this, new String[]
                {Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO}, 1000);}
    }
    public void grabar (View view){
        if (rec == null){
            archivoSalida = getExternalFilesDir(null).getAbsolutePath() + "/Grabacion.mp3";
            rec = new MediaRecorder();
            rec.setAudioSource(MediaRecorder.AudioSource.MIC);
            rec.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            rec.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
            rec.setOutputFile(archivoSalida);
        try {
            rec.prepare();
            rec.start();
        } catch(IOException e) {
            System.out.println("Error en la grabación del audio");
        }
        botonRec.setBackgroundResource(R.drawable.rec);
            crono.setBase(SystemClock.elapsedRealtime());
            crono.start();
        }else if(rec != null){
            rec.stop();
            rec.release();
            rec = null;
            botonRec.setBackgroundResource(R.drawable.stop_rec);
            crono.stop();
            crono.setBase(SystemClock.elapsedRealtime());
        }
    }
    public void reproducir(View view){
        MediaPlayer play = new MediaPlayer();
        try{
            play.setDataSource(archivoSalida);
            play.prepare();
        }catch (IOException e){
            System.out.println("Error en la reproducción del audio");
        }
            play.start();
    }

}


