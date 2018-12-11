package Model;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class Deposito implements Serializable {

    private String endereco;
    private String telefone;
    private String horarioDeFuncionamento;
    private String nome;


    public Deposito(String endereco, String telefone, String horarioDeFuncionamento, String nome) {
    }


    private String id;

    public Deposito() {}

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getHorarioDeFuncionamento() {
        return horarioDeFuncionamento;
    }

    public void setHorarioDeFuncionamento(String horarioDeFuncionamento) {
        this.horarioDeFuncionamento = horarioDeFuncionamento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
