/*
    É possível escrever uma classe sem escrever nenhum construtor? Por quê?
É possível, pois por padrão o Java cria um construtor automaticamente para todas as classes. Entretanto, o construtor
não recebe nenhum parâmetro, é o equivalente a escrever a linha de código: public Cartao(){}

    Um método estático pode acessar uma variável (atributo) não estático da classe? Por quê?
Não, pois as variáveis estáticas estão relacionadas com as instâncias criadas. Ao tentar acessar diretamente uma variável
não estática da classe o método estático não consegue saber de qual objeto é a variável que estamos querendo acessar.
Portanto, não faz sentido um método estático acessar uma variável não estática da classe.

    Um método não estático pode acessar uma variável (atributo) estático da classe? Por quê?
Sim, pois por definição uma variável estática da classe é uma variável de classe, sempre inicializada uma única vez e seu
valor é referente a classe em si, e não a cada instância criada.
Podemos pensar nas variáveis de classe como sendo um valor global, que mostra o estado da CLASSE, podendo ser
modificado por métodos não estáticos também
 */
package com.company;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Cartao implements Comparable {
    private static int numeroCartoes = 0;
    private int id;
    private int visibilidade;
    private String nome;
    private Usuario dono;
    private boolean invitationOnly;
    private Calendar dataCriacao;
    private ArrayList<Label> label;
    private String assunto;
    private Usuario responsavel;
    private int prioridade;

    //Construtores-----------------------------------------------------------------------------------------------
    //Sem parâmetros
    public Cartao(){
        numeroCartoes++;
        this.id = numeroCartoes;
        this.visibilidade = 0;
        this.nome = "Nome";
        this.invitationOnly = true;
        this.dataCriacao = new GregorianCalendar();

        label = new ArrayList();
    }

    //Todos os atributos
    public Cartao(int visibilidade, String nome, Usuario dono, boolean invitationOnly, Calendar dataCriacao,
                  ArrayList label, String assunto, Usuario responsavel, int prioridade){
        numeroCartoes++;
        this.id = numeroCartoes;
        this.visibilidade = visibilidade;
        this.nome = nome;
        this.dono = dono;
        this.invitationOnly = invitationOnly;
        this.dataCriacao = dataCriacao;
        this.label = label;
        this.assunto = assunto;
        this.responsavel = responsavel;
        this.prioridade = prioridade;

    }
    //Preenchimento pelo input
    public Cartao(Usuario dono, boolean invitationOnly, Usuario responsavel, int prioridade){
        numeroCartoes++;
        this.id = numeroCartoes;

        Scanner input = new Scanner(System.in);
        System.out.println("Qual a visibilidade do Cartão?");
        this.visibilidade = input.nextInt();
        input.nextLine();
        System.out.println("Qual o nome do Cartão?");
        this.nome = input.nextLine();
        this.dono = dono;
        this.invitationOnly = invitationOnly;
        this.dataCriacao = new GregorianCalendar();

        label = new ArrayList();
    }

    //Métodos getters/setter-------------------------------------------------------------------------------------
    public static int getNumeroCartoes() {
        return numeroCartoes;
    }

    /*public static void setNumeroCartoes(int numeroCartoes) {
        Cartao.numeroCartoes = numeroCartoes;
    }*/

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(int visibilidade) {
        this.visibilidade = visibilidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getDono() {
        return dono;
    }

    public void setDono(Usuario dono) {
        this.dono = dono;
    }

    public boolean isInvitationOnly() {
        return invitationOnly;
    }

    public void setInvitationOnly(boolean invitationOnly) {
        this.invitationOnly = invitationOnly;
    }

    public Calendar getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Calendar dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public ArrayList<Label> getLabel() {
        return label;
    }

    public void setLabel(ArrayList<Label> label) {
        this.label = label;
    }

    //Métodos----------------------------------------------------------------------------------------------------
    public int compareTo(Cartao cartao){
        if(this.prioridade < cartao.prioridade)
            return 1;
        if(this.prioridade > cartao.prioridade)
            return -1;
        if (this.prioridade == cartao.prioridade);
            return 0;
    }

    public String toString(){
        String out = "id: " + getId() + "\n";
        out += "Visibilidade " + getVisibilidade() + "\n";
        out += "Nome: " + getNome() + "\n";
        out += "Assunto: " + getAssunto() + "\n";
        if (getDono() != null){
            out += "Dono: " + getDono().getLogin() + "\n";
        }
        out += "Iinvitation Only: " + isInvitationOnly() + "\n";
        out += "Prioridade: " + getPrioridade() + "\n";
        out += "Responsável: " + getResponsavel() + "\n";
        out += "Data de Criação: " + getDataCriacao().get(Calendar.DATE) + "/" + getDataCriacao().get(Calendar.MONTH)
                + "/" + getDataCriacao().get(Calendar.YEAR) + "\n\n";

        return out;
    }
}
