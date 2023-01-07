package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    EditText user, pass;
    ImageButton btnAcceso, btnRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText) findViewById(R.id.User);
        pass=(EditText) findViewById(R.id.Pass);
        btnAcceso=(ImageButton) findViewById(R.id.acceso);
        btnRegistro=(ImageButton) findViewById(R.id.registro);
    }

    public void pagRegistro(View view){
        Intent i= new Intent(MainActivity.this,registro.class);
        startActivity(i);
    }
    //Metodo de acceso a la app
    public void acceso(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase Database = admin.getWritableDatabase();

        String usuario = user.getText().toString();
        String password = pass.getText().toString();
        String [] usuarios= {user.getText().toString()};
        if(!usuario.isEmpty()&&!password.isEmpty()){
            Cursor consulta = Database.rawQuery("select * from usuarios where usuario=?", usuarios);

            if(consulta.moveToFirst()){
                if(consulta.getString(1).equals(usuario)&&consulta.getString(2).equals(password)){
                    Intent i2= new Intent(MainActivity.this,bienvenida.class);
                    i2.putExtra("username",usuario);
                    startActivity(i2);
                    Database.close();
                }
                else{
                    Toast.makeText(this,"No existe el usuario", Toast.LENGTH_SHORT).show();
                    Database.close();
                }
            }
        } else {
            Toast.makeText(this, "Debes introducir el usuario o contraseña", Toast.LENGTH_SHORT).show();
        }
    }
}