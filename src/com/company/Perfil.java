package com.company;
import java.util.Calendar;

public class Perfil {
    private Sexo sexo;
    private Calendar data_nascimento;
    private String cidade;
    private Estado estado;
    private String telefone;
    private String descricao;
    private String foto;

    //Construtor-----------------------------------------------------------------------------------------------
    public Perfil(Sexo sexo, Calendar data_nascimento, String cidade, Estado estado, String telefone, String descricao, String foto){
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.descricao = descricao;
        this.foto = foto;
    }
    //Métodos-----------------------------------------------------------------------------------------------
    public Sexo getSexo(){
        return sexo;
    }
    public void setSexo(Sexo sexo){
        this.sexo = sexo;
    }

    public Calendar getData_nascimento(){
        return data_nascimento;
    }
    public void setData_nascimento(Calendar data_nascimento){
        this.data_nascimento = data_nascimento;
    }

    public String getCidade(){
        return cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public Estado getEstado(){
        return estado;
    }
    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getFoto(){
        return foto;
    }
    public void setFoto(String foto){
        this.foto = foto;
    }
    //Função toString()-----------------------------------------------------------------------------------------------
    public String toString(){
        String out = "sexo: " + (Sexo)getSexo() + "\n";
        out = out + "data_nascimento: " + getData_nascimento().getTime() + "\n";
        out = out + "cidade: " + getCidade() + "\n";
        out = out + "estado: " + getEstado() + "\n";
        out = out + "telefone: " + getTelefone() + "\n";
        out = out + "descricao: " + getDescricao() + "\n";
        out = out + "foto: " + getFoto() + "\n";

        return out;
    }


}