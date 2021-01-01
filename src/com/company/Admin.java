package com.company;

import java.util.Calendar;

public class Admin extends Usuario{
    public Admin(int id, String login, String email, String senha, Calendar data_ativacao, boolean status, Perfil perfil){
        super(id, login, email, senha, data_ativacao, status, perfil);
    }

    public void desabilitarGrupo(Grupo grupo){
        //O Admin faz parte do grupo?
        if (grupo.getMembros().contains(this)){
            grupo.setStatus(this, false);
        }
    }

    public Grupo criarGrupo(Usuario user_chamou, String nomeGrupo, String descricao, boolean Visibilidade){
        if (Visibilidade == true) {
            GrupoPrivado novoGrupo = new GrupoPrivado(nomeGrupo, this, descricao);
            this.getGrupos().add(novoGrupo);

            return novoGrupo;
        }
        if (Visibilidade == false) {
            GrupoPublico novoGrupo = new GrupoPublico(nomeGrupo, this, descricao);
            this.getGrupos().add(novoGrupo);

            return novoGrupo;
        }
        return null;
    }
}
