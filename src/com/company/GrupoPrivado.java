package com.company;


import java.util.ArrayList;

public class GrupoPrivado extends Grupo{
    //Construtor-----------------------------------------------------------------------------------------------
    public GrupoPrivado(String nome, Usuario dono, String descricao){
        super(nome, dono, descricao);
        //Adiciona o "dono" para os grupos de membros
        getMembros().add(dono);

        //Habilita todas as permissões para o membro "dono"
        getPermissaoAdicionar().add(dono);
        getPermissaoRemover().add(dono);
        getPermissaoAlterar().add(dono);
        getPermissaoVizualizar().add(dono);
    }
    //Métodos-----------------------------------------------------------------------------------------------
    public boolean adicionaMembro(Usuario usuario, Usuario dono){
        if (isStatus() && getDono() == dono){
            getMembros().add(usuario);
            usuario.getGrupos().add(this);

            getPermissaoVizualizar().add(usuario);
            return true;
        }
        else return false;
    }

    public boolean removeMembro(Usuario usuario, Usuario dono){
        if (isStatus() && getDono() == dono){
            getMembros().remove(usuario);
            usuario.getGrupos().remove(this);

            getPermissaoVizualizar().remove(this);
            return true;
        }
        else return false;
    }

    public void adicionarPermissao(Usuario user_chamou, Usuario user2, ArrayList<Permissoes> permissao){
        if (permissao.contains(Permissoes.ADICIONAR_USUARIO) && (user_chamou == getDono())){
            getPermissaoAdicionar().add(user2);
        }
        if (permissao.contains(Permissoes.REMOVER_USUARIO) && (user_chamou == getDono())){
            getPermissaoRemover().add(user2);
        }
        if (permissao.contains(Permissoes.ALTERAR_USUARIO) && (user_chamou == getDono())){
            getPermissaoAlterar().add(user2);
        }
        if (permissao.contains(Permissoes.VISUALIZAR_INFO) && (user_chamou == getDono())){
            getPermissaoVizualizar().add(user2);
        }
    }
    public void removerPermissao(Usuario user_chamou, Usuario user2, ArrayList<Permissoes> permissao){
        if (permissao.contains(Permissoes.ADICIONAR_USUARIO) && (user_chamou == getDono())){
            getPermissaoAdicionar().remove(user2);
        }
        if (permissao.contains(Permissoes.REMOVER_USUARIO) && (user_chamou == getDono())){
            getPermissaoRemover().remove(user2);
        }
        if (permissao.contains(Permissoes.ALTERAR_USUARIO) && (user_chamou == getDono())){
            getPermissaoAlterar().remove(user2);
        }
        if (permissao.contains(Permissoes.VISUALIZAR_INFO) && (user_chamou == getDono())){
            getPermissaoVizualizar().remove(user2);
        }
    }
        //Função toString()-----------------------------------------------------------------------------------------------
    public String toString(){
        String out = "(Grupo Privado id: " + getId() + ")\n";
        out = out + "Nome: " + getNome() + "\n";
        out = out + "Descricao: " + getDescricao() + "\n";
        out = out + "Membros: \n" + getMembros() + "\n";
        out = out + "Status: " + isStatus() + "\n";
        out = out + "Data de Criacao: " + getDataCriacao().getTime() + "\n";

        return out;
    }
}
