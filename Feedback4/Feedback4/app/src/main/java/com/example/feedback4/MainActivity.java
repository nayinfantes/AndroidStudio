package com.example.feedback4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText eT_nombre, eT_telf, eT_file, eT_mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eT_nombre = (EditText) findViewById(R.id.eT_nombre);
        eT_telf = (EditText) findViewById(R.id.eT_telf);
        eT_file = (EditText) findViewById(R.id.eT_file);
        eT_mostrar = (EditText) findViewById(R.id.eT_mostrar);
    }

    public void Guardar(View view) {
        String nombre = eT_nombre.getText().toString();
        String telf = eT_telf.getText().toString();
        String file = eT_file.getText().toString();
        String nombrefichero = file + ".txt";
        //////////////////////////////////SHARED PREFERENCES//////////////////////////
        SharedPreferences preferences = getSharedPreferences("file", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences.edit();
        obj_editor.putString(nombre, telf);
        obj_editor.commit();
        /////////////////////////////////////////////////////////////////////////////
        try{
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(nombrefichero, Activity.MODE_APPEND));
            archivo.write(nombre+" "+telf +"\n");
            archivo.flush();
            archivo.close();

            eT_nombre.setText("");
            eT_telf.setText("");
            eT_file.setText("");
        } catch(IOException e){
            System.err.print("ERROR AL ESCRIBIR EL ARCHIVO");
        }
        Toast.makeText(this, "El contacto se ha guardado correctamente en su sistema de archivos", Toast.LENGTH_SHORT).show();
    }
    public void Buscar(View view){
        String nombre = eT_nombre.getText().toString();
        String file = eT_file.getText().toString();
        //String telf = eT_telf.getText().toString();
        String nombrefichero = file + ".txt";
        //////////////////////////////////SHARED PREFERENCES//////////////////////////
        SharedPreferences preferences = getSharedPreferences("file", Context.MODE_PRIVATE);
        String datos = preferences.getString(nombre,"");
        if(datos.length() == 0){
            Toast.makeText( this, "El contacto que busca no existe", Toast.LENGTH_SHORT).show();
        }
        else{
            eT_telf.setText(datos);
        }
        /////////////////////////////////////////////////////////////////////////////
        try{
            InputStreamReader abrirArchivo = new InputStreamReader(openFileInput(nombrefichero));
            BufferedReader leerArchivo = new BufferedReader(abrirArchivo);
            String linea= leerArchivo.readLine();
            String contenidoCompleto= "";
            while(linea != null){
                contenidoCompleto=contenidoCompleto+linea+"\n";
                linea=leerArchivo .readLine();

            }
            leerArchivo.close();
            abrirArchivo.close();
            eT_mostrar.setText(contenidoCompleto);
        }catch(IOException e){
            Toast.makeText( this, "Error al leer el archivo", Toast.LENGTH_SHORT).show();
        }

    }
}