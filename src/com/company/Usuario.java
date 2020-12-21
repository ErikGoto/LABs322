package com.company;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Calendar;

public class Usuario {
    private int id;
    private String login;
    private String email;
    private String senha;
    private Calendar data_ativacao;
    private boolean status;
    private String descricao;
    private ArrayList<Grupo> grupos;

    //Construtor-----------------------------------------------------------------------------------------------
        public Usuario(int id, String login, String email, String senha, Calendar data_ativacao, boolean status){
        this.id = id;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.data_ativacao = data_ativacao;
        this.status = status;

        grupos = new ArrayList();
    }
    //Métodos-----------------------------------------------------------------------------------------------
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }

    public Calendar getData_ativacao(){
        return data_ativacao;
    }
    public void setData_ativacao(Calendar data_ativacao){
        this.data_ativacao = data_ativacao;
    }

    public boolean getStatus(){
        return status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList getGrupos() {
        return grupos;
    }

    public Grupo criarGrupo(Usuario user_chamou, String nomeGrupo, String descricao, boolean Visibilidade){
            return null;
    }
    public void removerGrupo(Usuario user_chamou, Grupo grupo){
        //Apenas usuarios admin podem remover grupos
        if (user_chamou instanceof Admin){
            this.grupos.remove(grupo);
        }

    }

    public boolean criarCartao(int id) {
        if(grupos.get(id).getPermissaoCriarCartao().contains(this)){
            Cartao cartao = new Cartao();
            grupos.get(id).adicionarCartao(cartao);

            return true;
        }

        return false;
    }

    public ArrayList<Permissoes> getPermissoesNoGrupo(int grupo){
        ArrayList<Permissoes> permissoes = new ArrayList<Permissoes>();
        if(grupos.get(grupo).getPermissaoAdicionar().contains(this)){
            permissoes.add(Permissoes.ADICIONAR_USUARIO);
        }
        if(grupos.get(grupo).getPermissaoRemover().contains(this)){
            permissoes.add(Permissoes.REMOVER_USUARIO);
        }
        if(grupos.get(grupo).getPermissaoAlterar().contains(this)){
            permissoes.add(Permissoes.ALTERAR_USUARIO);
        }
        if(grupos.get(grupo).getPermissaoVizualizar().contains(this)){
            permissoes.add(Permissoes.VISUALIZAR_INFO);
        }
        if(grupos.get(grupo).getPermissaoCriarCartao().contains(this)){
            permissoes.add(Permissoes.CRIAR_CARTAO);
        }
        return permissoes;
    }
    //Função toString()-----------------------------------------------------------------------------------------------
    public String toString(){
        String out = getLogin() + "(id: " + getId() + ")\n";
        out = out + "email: " + getEmail() + "\n";
        out = out + "senha: " + getSenha() + "\n";
        out = out + "data_ativacao: " + getData_ativacao().getTime() + "\n"; //getData_aticacao().get(Calendar.DATE)
        out = out + "status: " + getStatus() + "\n";

        return out;
    }
}