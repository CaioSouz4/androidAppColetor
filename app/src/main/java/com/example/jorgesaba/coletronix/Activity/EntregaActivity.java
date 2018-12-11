package com.example.jorgesaba.coletronix.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jorgesaba.coletronix.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import Config.ConfiguracaoFirebase;
import Model.Deposito;
import Model.Entrega;

public class EntregaActivity extends AppCompatActivity {

    private ImageView im;
    private Entrega entrega;
    private Deposito deposito;
    private EditText editQuantidadeLixo;
    DatabaseReference firebaseref = ConfiguracaoFirebase.getFirebaseDatabase();
    DatabaseReference entregas = firebaseref.child("entregas");

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrega);

        this.editQuantidadeLixo = findViewById(R.id.quantidadeLixo);

        Bundle extras = getIntent().getExtras();
        deposito = (Deposito) extras.getSerializable("deposito");

        this.im = findViewById(R.id.foto);
        this.entrega = new Entrega();
        this.entrega.setTipo("plastico");
        this.entrega.setId_usuario(FirebaseAuth.getInstance().getCurrentUser().getUid());
        this.entrega.setId_deposito(deposito.getId());
        this.entrega.setNomeDeposito(deposito.getNome());
    }

    public void entregarLixo(View view){

        String quantidadeDeLixo = this.editQuantidadeLixo.getText().toString();
        if(quantidadeDeLixo.isEmpty()){
            Toast.makeText(EntregaActivity.this, "Digite uma quantidade",
                    Toast.LENGTH_SHORT).show();
        }else{
            Double quantidade = Double.parseDouble(quantidadeDeLixo);
            this.entrega.setQuantidade(quantidade);

            this.entregas.push().setValue(this.entrega);
            Intent intent = new Intent();
            intent.setAction("com.example.jorgesaba.coletronix.Activity.VERIFICA_RANK");
            sendBroadcast(intent);
            startActivity(new Intent(EntregaActivity.this, Historico.class));
        }
    }

    public void plastico(View view){

        this.im.setImageResource(R.drawable.plastico);
        this.entrega.setTipo("plastico");
    }

    public void papel(View view){

        this.im.setImageResource(R.drawable.papel);
        this.entrega.setTipo("papel");
    }

    public void vidro(View view){

        this.im.setImageResource(R.drawable.vidro);
        this.entrega.setTipo("vidro");
    }

    public void organico(View view){

        this.im.setImageResource(R.drawable.organico);
        this.entrega.setTipo("organico");
    }

    public void metal(View view){

        this.im.setImageResource(R.drawable.metal);
        this.entrega.setTipo("metal");
    }

    public void bateria(View view){

        this.im.setImageResource(R.drawable.bateria);
        this.entrega.setTipo("bateria");
    }
}
