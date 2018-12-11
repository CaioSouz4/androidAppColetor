package com.example.jorgesaba.coletronix.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.jorgesaba.coletronix.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import Config.ConfiguracaoFirebase;
import Model.Deposito;

public class infoDep extends AppCompatActivity {

    DatabaseReference firebaseref = ConfiguracaoFirebase.getFirebaseDatabase();
    DatabaseReference depositos = firebaseref.child("depositos");
    Deposito meuDeposito = null;
    String nomeDeposito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        nomeDeposito = (String) extras.get("nome");

        depositos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot data : dataSnapshot.getChildren()){
                    if(data.exists()){
                        Deposito umDeposito = data.getValue(Deposito.class);
                        if(umDeposito.getNome().equals(nomeDeposito)){
                            meuDeposito = umDeposito;
                            mandaDeposito(umDeposito);
                        }
                        //depositosCadastrados.add(umDeposito);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void mandaDeposito(Deposito deposito){
        Intent i = new Intent(infoDep.this, EntregaActivity.class);
        i.putExtra("deposito", deposito);
        startActivity(i);
    }

}
