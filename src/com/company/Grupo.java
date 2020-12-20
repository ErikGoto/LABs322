package com.company;

import java.util.ArrayList;
import java.util.Calendar;

public class Grupo {
    private static int numeroGrupos = 1;
    private int id;
    private String nome;
    private String descricao;
    private final Usuario dono;
    private ArrayList<Usuario> membros;
    private boolean status = true;
    private Calendar dataCriacao;

    private ArrayList<Usuario> permissaoAdicionar;
    private ArrayList<Usuario> permissaoRemover;
    private ArrayList<Usuario> permissaoAlterar;
    private ArrayList<Usuario> permissaoVizualizar;
    private ArrayList<Usuario> permissaoCriarCartao;

    //Construtor-----------------------------------------------------------------------------------------------
    public Grupo(String nome, Usuario dono, String descricao){
        this.id = numeroGrupos;
        numeroGrupos++;
        setNome(nome);
        this.dono = dono;
        setDescricao(descricao);
        membros = new ArrayList();
        dataCriacao = Calendar.getInstance();

        permissaoAdicionar = new ArrayList();
        permissaoRemover = new ArrayList();
        permissaoAlterar = new ArrayList();
        permissaoVizualizar = new ArrayList();
    }

    //Métodos-----------------------------------------------------------------------------------------------
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getDono() {
        return dono;
    }

    public ArrayList getMembros() {
        return membros;
    }

    public static int getNumeroGrupos() {
        return numeroGrupos;
    }

    public ArrayList<Usuario> getPermissaoAdicionar() {
        return permissaoAdicionar;
    }
    public ArrayList<Usuario> getPermissaoRemover() {
        return permissaoRemover;
    }
    public ArrayList<Usuario> getPermissaoAlterar() {
        return permissaoAlterar;
    }
    public ArrayList<Usuario> getPermissaoVizualizar() {
        return permissaoVizualizar;
    }
    public ArrayList<Usuario> getPermissaoCriarCartao() {
        return permissaoCriarCartao;
    }

    public boolean isStatus() {
        return status;
    }
    //Irá mudar o status apenas se o usuário que chamou a função for do tipo Admin
    public void setStatus(Usuario user, boolean status) {
        if (user instanceof Admin){
            this.status = status;
        }
    }

    public Calendar getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Calendar dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String vizualizarInfos(Usuario user_chamou) {
        if (getPermissaoVizualizar().contains(user_chamou)) {
            String out = "(Grupo id: " + getId() + ")\n";
            out = out + "Nome: " + getNome() + "\n";
            out = out + "Dono " + getDono() + "\n";
            out = out + "Membros: \n" + getMembros() + "\n";
            out = out + "Status: " + isStatus() + "\n";

            return out;
        }
        return "";
    }

    //Métodos sobrescritos nas classes filhas
    public boolean adicionaMembro(Usuario user_chamou, Usuario usuario, ArrayList<Permissoes> permissoesList){
        return false;
    }
    public boolean removeMembro(Usuario user_chamou, Usuario usuario){
        return false;
    }
    public void adicionarPermissao(Usuario user_chamou, Usuario user2, ArrayList<Permissoes> permissao){
    }
    public void removerPermissao(Usuario user_chamou, Usuario user2, ArrayList<Permissoes> permissao){
    }

    //Função toString()-----------------------------------------------------------------------------------------------
    public String toString(){
        String out = "(Grupo id: " + getId() + ")\n";
        out = out + "Nome: " + getNome() + "\n";
        out = out + "Descricao: " + getDescricao() + "\n";
        out = out + "Membros: \n" + getMembros() + "\n";
        out = out + "Status: " + isStatus() + "\n";
        out = out + "Data de Criacao: " + getDataCriacao().getTime() + "\n";

        return out;
    }


}
