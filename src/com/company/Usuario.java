package com.company;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Usuario {
    private int id;
    private String login;
    private String email;
    private String senha;
    private Calendar data_ativacao;
    private boolean status;
    private String descricao;
    private ArrayList<Grupo> grupos;
    private Perfil perfil;

    //Construtor-----------------------------------------------------------------------------------------------
        public Usuario(int id, String login, String email, String senha, Calendar data_ativacao, boolean status, Perfil
                       perfil){
        this.id = id;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.data_ativacao = data_ativacao;
        this.status = status;
        this.perfil = perfil;

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

    public abstract Grupo criarGrupo(Usuario user_chamou, String nomeGrupo, String descricao, boolean Visibilidade);
    public void removerGrupo(Usuario user_chamou, Grupo grupo){
        //Apenas usuarios admin podem remover grupos
        if (user_chamou instanceof Admin){
            this.grupos.remove(grupo);
        }

    }

    public boolean criarCartao(int id, int visibilidade, String nome, Usuario dono, boolean invitation, Calendar data,
                               String assunto, Usuario responsavel, int prioridade) {
        if(grupos.get(id).getPermissaoCriarCartao().contains(this) && responsavel.getGrupos().contains(id)){
            ArrayList label = new ArrayList();
            label.add(Label.TO_DO);

            Cartao cartao = new Cartao(visibilidade, nome, dono, invitation, data,
                    label, assunto, responsavel, prioridade);

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

    private boolean executarTarefa(Cartao cartao, Grupo grupo){
        ArrayList<Label> label = new ArrayList();
        label.add(Label.DONE);
        cartao.setLabel(label);

        grupo.getCartoesAFazer().remove(cartao);
        grupo.getCartoesFeitos().add(cartao);

        return true;
    }
    public boolean executarTarefaDeMaiorPrioridade(){
        

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