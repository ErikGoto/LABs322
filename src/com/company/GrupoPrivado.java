package com.company;


import java.awt.image.AreaAveragingScaleFilter;
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
        getPermissaoCriarCartao().add(dono);
    }
    //Métodos-----------------------------------------------------------------------------------------------
    public boolean adicionaMembro(Usuario user_chamou, Usuario usuario, ArrayList<Permissoes> permissoesList){
        if (isStatus() && getPermissaoAdicionar().contains(user_chamou)){
            getMembros().add(usuario);
            usuario.getGrupos().add(this);

            //Dá apenas as permissões passadas pela lista do parâmetro
            adicionarPermissao(this.getDono(), usuario, permissoesList);
            return true;
        }
        else return false;
    }

    public boolean removeMembro(Usuario user_chamou, Usuario usuario){
        if (isStatus() && getPermissaoRemover().contains(user_chamou)){
            getMembros().remove(usuario);
            usuario.getGrupos().remove(this);

            //todo aprimorar a lógica de remoção de permissões
            getPermissaoAdicionar().remove(usuario);
            getPermissaoRemover().remove(usuario);
            getPermissaoAlterar().remove(usuario);
            getPermissaoVizualizar().remove(usuario);
            getPermissaoCriarCartao().remove(usuario);
            return true;
        }
        return false;
    }

    public void adicionarPermissao(Usuario user_chamou, Usuario user2, ArrayList<Permissoes> permissao){
        if (this.getPermissaoAlterar().contains(user_chamou)){
            if (permissao.contains(Permissoes.ADICIONAR_USUARIO)){
                getPermissaoAdicionar().add(user2);
            }
            if (permissao.contains(Permissoes.REMOVER_USUARIO)){
                getPermissaoRemover().add(user2);
            }
            if (permissao.contains(Permissoes.ALTERAR_USUARIO)){
                getPermissaoAlterar().add(user2);
            }
            if (permissao.contains(Permissoes.VISUALIZAR_INFO)){
                getPermissaoVizualizar().add(user2);
            }
            if (permissao.contains(Permissoes.CRIAR_CARTAO)){
                getPermissaoCriarCartao().add(user2);
            }
        }
    }
    public void removerPermissao(Usuario user_chamou, Usuario user2, ArrayList<Permissoes> permissao){
        if (this.getPermissaoAlterar().contains(user_chamou)){
            if (permissao.contains(Permissoes.ADICIONAR_USUARIO)){
                getPermissaoAdicionar().remove(user2);
            }
            if (permissao.contains(Permissoes.REMOVER_USUARIO)){
                getPermissaoRemover().remove(user2);
            }
            if (permissao.contains(Permissoes.ALTERAR_USUARIO)){
                getPermissaoAlterar().remove(user2);
            }
            if (permissao.contains(Permissoes.VISUALIZAR_INFO)){
                getPermissaoVizualizar().remove(user2);
            }
            if (permissao.contains(Permissoes.CRIAR_CARTAO)){
                getPermissaoCriarCartao().remove(user2);
            }
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
