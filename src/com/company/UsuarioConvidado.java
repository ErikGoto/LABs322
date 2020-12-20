package com.company;

import java.util.Calendar;

public class UsuarioConvidado extends Usuario {
    private Calendar dataExpiracao;

    //Construtor-----------------------------------------------------------------------------------------------
    public UsuarioConvidado(int id, String login, String email, String senha, Calendar data_ativacao, boolean status,
                            Calendar dataExpiracao){
        super(id, login, email, senha, data_ativacao, status);
        this.dataExpiracao = dataExpiracao;
    }

    public Calendar getDataExpiracao() {
        return dataExpiracao;
    }
    public void setDataExpiracao(Calendar dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public Grupo criarGrupo(Usuario user_chamou, String nomeGrupo, String descricao, boolean Visibilidade){
        return null;
    }

}
