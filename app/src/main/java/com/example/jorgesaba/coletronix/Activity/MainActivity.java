package com.example.jorgesaba.coletronix.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jorgesaba.coletronix.R;
import com.google.firebase.database.DatabaseReference;

import Config.ConfiguracaoFirebase;
import Model.Deposito;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference firebaseref = ConfiguracaoFirebase.getFirebaseDatabase();
        DatabaseReference depositos = firebaseref.child("depositos");
        Deposito d2 = new Deposito("Rua joão lennon", "88 99876271", "Até as 22:00", "Lixão do jorge");
        Deposito d3 = new Deposito("Rua Neto Siqueira", "88 99876271", "Até as 21:00", "Bar do cabeludin");
        Deposito d4 = new Deposito("CEDRO", "88 99876271", "Até as 22:00", "Lixão da UFC");
        Deposito d5 = new Deposito("CEDRO", "88 99876271", "Até as 22:00", "Lixão da IFCE");

        depositos.push().setValue(d3);
        depositos.push().setValue(d4);
        depositos.push().setValue(d2);
        depositos.push().setValue(d5);


        //getSupportActionBar().hide();
    }


    @Override
    protected void onStart() {
        super.onStart();

    }

    public void abrirTelaLogin(View view){
        startActivity(new Intent(this, LoginActivity.class));

    }

    public void abrirTelaCadastro(View view){
        startActivity(new Intent(this, CadastroActivity.class));
    }
}
