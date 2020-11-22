package com.company;

import java.util.Calendar;

public class Admin extends Usuario{
    public Admin(int id, String login, String email, String senha, Calendar data_ativacao, boolean status){
        super(id, login, email, senha, data_ativacao, status);
    }

    public void desabilitarGrupo(Grupo grupo){
        //O Admin faz parte do grupo?
        if (grupo.getMembros().contains(this)){
            grupo.setStatus(this, false);
        }
    }
}
