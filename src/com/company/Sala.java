package com.company;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Sala {
    private static int numeroSalas = 0;
    private int id;
    private int capacidadeMaxima;
    private int numeroUsuarios;
    private String descricao;
    private Usuario dono;
    private boolean ingressoAutomatico;
    private Calendar dataCriacao;

    //Construtores-----------------------------------------------------------------------------------------------
    public Sala(){
        numeroSalas++;
        this.id = numeroSalas;
        this.capacidadeMaxima = 100;
        this.numeroUsuarios = 1;
        this.descricao = "Minha Nova Sala";
        this.dono = null;
        this.ingressoAutomatico = false;
        this.dataCriacao = new GregorianCalendar();
    }
    public Sala(Usuario dono, boolean ingressoAutomatico){
        numeroSalas++;
        this.id = numeroSalas;

        Scanner input = new Scanner(System.in);
        System.out.println("Qual a capacidade máxima da sala?");
        this.capacidadeMaxima = input.nextInt();;
        input.nextLine();//Sem essa linha a proxima entrada(string) fica uma string vazia
        System.out.println("Escreva uma descrição da sala:");
        this.descricao = input.nextLine();
        this.numeroUsuarios = 1;
        this.dono = dono;
        this.ingressoAutomatico = ingressoAutomatico;
        this.dataCriacao = new GregorianCalendar();
    }

    //Métodos getters/setter----------------------------------------------------------------------------------------------
    public static int getNumeroSalas() {
        return numeroSalas;
    }

    public static void setNumeroSalas(int numeroSalas) {
        Sala.numeroSalas = numeroSalas;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public int getNumeroUsuarios() {
        return numeroUsuarios;
    }

    public void setNumeroUsuarios(int numeroUsuarios) {
        this.numeroUsuarios = numeroUsuarios;
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

    public void setDono(Usuario dono) {
        this.dono = dono;
    }

    public boolean isIngressoAutomatico() {
        return ingressoAutomatico;
    }

    public void setIngressoAutomatico(boolean ingressoAutomatico) {
        this.ingressoAutomatico = ingressoAutomatico;
    }

    public Calendar getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Calendar dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    //Métodos----------------------------------------------------------------------------------------------
    public boolean adicionaUsuario(){
        if (getNumeroUsuarios() < getCapacidadeMaxima()){
            setNumeroUsuarios(getNumeroUsuarios() + 1);
            System.out.println("Usuário adicionado\n(" + getNumeroUsuarios() + "/" + getCapacidadeMaxima() + ")");
            return true;
        }else {
            System.out.println("Não foi possível adicionar o usuário, sala lotada\n(" + getNumeroUsuarios() + "/" + getCapacidadeMaxima() + ")");
            return false;
        }
    }

    public boolean removeUsuario(){
        if (getNumeroUsuarios() > 0){
            setNumeroUsuarios(getNumeroUsuarios() - 1);
            System.out.println("Usuário removido\n(" + getNumeroUsuarios() + "/" + getCapacidadeMaxima() + ")");
            return true;
        }else {
            System.out.println("Não foi possível remover o usuário, sala vazia\n(" + getNumeroUsuarios() + "/" + getCapacidadeMaxima() + ")");
            return false;
        }
    }

    public String toString(){
        String out = "id: " + getId() + "\n";
        out += "Número de Usuários: " + getNumeroUsuarios() + " de " + getCapacidadeMaxima() + "\n";
        out += "Descrição: " + getDescricao() + "\n";

        if (getDono() != null){
            out += "Dono: " + getDono().getLogin() + "\n";
        }
        out += "Ingresso Automático: " + isIngressoAutomatico() + "\n";
        out += "Data de Criação: " + getDataCriacao().get(Calendar.DATE) + "/" + getDataCriacao().get(Calendar.MONTH)
                + "/" + getDataCriacao().get(Calendar.YEAR) + "\n\n";

        return out;
    }
}
