package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class registro extends AppCompatActivity {
    EditText us, pas, pas2;
    ImageButton btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        us = (EditText) findViewById(R.id.Us);
        pas = (EditText) findViewById(R.id.Pas);
        pas2 = (EditText) findViewById(R.id.Pas2);
        btnGuardar = (ImageButton) findViewById(R.id.guardar);
    }

    //Método para dar de alta usuarios
    public void Registrar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase Database = admin.getWritableDatabase();

        String usuario = us.getText().toString();
        String pass = pas.getText().toString();
        String pass2 = pas2.getText().toString();

        if (!usuario.isEmpty() && !pass.isEmpty() && !pass2.isEmpty()) {
          if (pass.equals(pass2)) {
            ContentValues registro = new ContentValues();

            registro.put("usuario", usuario);
            registro.put("pass", pass);

            Database.insert("usuarios", null, registro);

            Database.close();
            us.setText("");
            pas.setText("");
            pas2.setText("");

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
              Intent i= new Intent(registro.this,MainActivity.class);
              startActivity(i);
        } else {
              Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
          }
        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}

