package com.company;

import java.util.Calendar;

public class UsuarioComum extends Usuario{
    public UsuarioComum(int id, String login, String email, String senha, Calendar data_ativacao, boolean status, Perfil
                        perfil){
        super(id, login, email, senha, data_ativacao, status, perfil);
    }

    public  Grupo criarGrupo(Usuario user_chamou, String nomeGrupo, String descricao, boolean Visibilidade){
        return null;
    }

}
