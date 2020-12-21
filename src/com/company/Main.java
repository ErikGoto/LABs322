//Respostas
/**
 *1. O polimorfismo acontece quando duas ou mais classes herdam métodos com a mesma estrutura da superclasse, mas
 * que possuem comportamentos diferentes para cada classe filha. O método em cada classe herdeira é especializada
 * É muito importante que os métodos possuam a mesma identidicação tanto na superclasse quanto nas classes filhas.
 *
 * 2. Na linguagem Java o polimorfismo ocorre quando precisamos executar funções com a mesma assinatura, estas são
 * definidas em vários níveis da hierarquia. Cada função possui um método de funcionamento diferentes.
 *  Ao fazer isso garantimos que as subclasses tenham uma interface em comum, ddeclarada na super classe
 *
 * 3. Usuario userConvidado = new UsuarioConvidado();
 * userConvidado.getDataExpiracao();
 *
 *Ao tentar chamar um método que não foi implementado na superclasse(getDataExpiração, por exemplo) teremos um
 * erro, pois userConvidado é do tipo usuario, e a classe usuario não possui nenhum método com assinatura
 * "getDataExpiracao".
 *
 * Para contornar este problema podemos realizar um casting a userConvidado, desta forma garantimos ao sistema
 * que userConvidado é do tipo UsuarioConvidado:
 * ((UsuarioConvidado)userConvid).getDataExpiracao();
 *
 */

package com.company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Usuario user1 = new Usuario(1, "Login", "Email.com", "654646546", new GregorianCalendar(),
                true);
        Usuario userConvid = new UsuarioConvidado(2, "LoginConvid", "emial.com", "654",
                new GregorianCalendar(), true, new GregorianCalendar());

        Admin admin = new Admin(3, "Login Admin", "Eamil.com", "842132", new GregorianCalendar(),
                true);
        Usuario user2 = new Usuario(4, "Login4", "Email.com", "654646546", new GregorianCalendar(),
                true);

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= \n Tentando criar grupos " +
                "para cada Usuário");
        System.out.println("\nuser1:");
        System.out.println(user1.criarGrupo(user1, "Grupo de user1", "Descrição do grupo",
                true));

        System.out.println("\nuser2:");
        System.out.println(user1.criarGrupo(user2, "Grupo de user2", "Descrição do grupo",
                true));

        System.out.println("\nuserConvid:");
        System.out.println(userConvid.criarGrupo(userConvid, "Grupo de user2", "Descrição do grupo",
                true));

        System.out.println("\nadmin:");
        //Grupo privado
        Grupo adminGroup_1 = admin.criarGrupo(admin, "Grupo de user2", "Descrição do grupo",
                true);
        System.out.println(adminGroup_1);

        //Testes nos grupos-------------------------------------------------------------------------------
        //Grupo privado
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\nGrupo privado 1");
        System.out.println("\nAntes de adicionar membro");
        System.out.println(adminGroup_1.getMembros());
        System.out.println("\nDepois de adicionar membros");
        adminGroup_1.adicionaMembro(admin, user1, new ArrayList<Permissoes>());
        adminGroup_1.adicionaMembro(admin, user2, new ArrayList<Permissoes>());
        System.out.println(adminGroup_1.getMembros());

        System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\nImprimindo as permissões de " +
                "cada membro:");
        System.out.println("\nAdmin:");
        System.out.println(admin.getPermissoesNoGrupo(0));
        System.out.println("\nuser1:");
        System.out.println(user1.getPermissoesNoGrupo(0));
        System.out.println("\nuser2:");
        System.out.println(user2.getPermissoesNoGrupo(0));

        System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\nVamos conceder todos os " +
                "acessos para user1 e fazer alguns testes");
        ArrayList permissoes = new ArrayList();
        permissoes.add(Permissoes.CRIAR_CARTAO);
        permissoes.add(Permissoes.ADICIONAR_USUARIO);
        permissoes.add(Permissoes.REMOVER_USUARIO);
        permissoes.add(Permissoes.VISUALIZAR_INFO);
        permissoes.add(Permissoes.ALTERAR_USUARIO);

        adminGroup_1.adicionarPermissao(admin, user1, permissoes);
        System.out.println("\nuser1:");
        System.out.println(user1.getPermissoesNoGrupo(0));

        System.out.println("Adicionar Membros:");
        adminGroup_1.adicionaMembro(user1, userConvid, new ArrayList<Permissoes>());
        System.out.println(adminGroup_1.getMembros());
        System.out.println("\nRemover Membros:");
        adminGroup_1.removeMembro(user1, userConvid);
        System.out.println(adminGroup_1.getMembros());

        System.out.println("\nAltera permissões de user2:");
        permissoes.remove(Permissoes.ALTERAR_USUARIO);
        permissoes.remove(Permissoes.REMOVER_USUARIO);
        adminGroup_1.adicionarPermissao(user1, user2, permissoes);
        System.out.println(user2.getPermissoesNoGrupo(0));

        System.out.println("\nVisualiza as infos do grupo:");
        System.out.println(adminGroup_1.vizualizarInfos(user1));

        System.out.println("\nLista de usuarios de ADICIONAR_USUARIO:");
        System.out.println(adminGroup_1.getPermissaoAdicionar());
        System.out.println("\nLista de usuarios de REMVOER_USUARIO:");
        System.out.println(adminGroup_1.getPermissaoRemover());
        System.out.println("\nLista de usuarios de ALTERAR_USUARIO:");
        System.out.println(adminGroup_1.getPermissaoAlterar());
        System.out.println("\nLista de usuarios de VISUALIZAR_INFOS:");
        System.out.println(adminGroup_1.getPermissaoVizualizar());
        System.out.println("\nLista de usuarios de CRIAR_CARTAO:");
        System.out.println(adminGroup_1.getPermissaoCriarCartao());

        //--------------------------------------------------------------------------------------------------
        //Grupo publico
        Grupo adminGroup_2 = admin.criarGrupo(admin, "Grupo publico de admin2", "Descricao",
                false);

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\nGrupo publico");
        System.out.println("\nAntes de adicionar membro");
        System.out.println(adminGroup_2.getMembros());
        System.out.println("\nDepois de adicionar membros");
        adminGroup_2.adicionaMembro(admin, user1, new ArrayList<Permissoes>());
        adminGroup_2.adicionaMembro(admin, user2, new ArrayList<Permissoes>());
        System.out.println(adminGroup_2.getMembros());

        System.out.println("\n\nImprimindo as permissões de cada membro:");
        System.out.println("\nAdmin:");
        System.out.println(admin.getPermissoesNoGrupo(1));
        System.out.println("\nuser1:");
        System.out.println(user1.getPermissoesNoGrupo(1));
        System.out.println("\nuser2:");
        System.out.println(user2.getPermissoesNoGrupo(1));

        System.out.println("\nuser1:");
        System.out.println(user1.getPermissoesNoGrupo(1));
        System.out.println("\nuser2:");
        System.out.println(user2.getPermissoesNoGrupo(1));

        System.out.println("Adicionar Membros:");
        adminGroup_2.adicionaMembro(user1, userConvid, new ArrayList<Permissoes>());
        System.out.println(adminGroup_2.getMembros());
        System.out.println("\nRemover Membros:");
        adminGroup_2.removeMembro(user1, userConvid);
        System.out.println(adminGroup_2.getMembros());

        System.out.println("\nAltera permissões de user2:");
        adminGroup_2.removerPermissao(user1, user2, permissoes);
        System.out.println(user2.getPermissoesNoGrupo(1));

        System.out.println("\nVisualizar as infos do grupo:");
        System.out.println(adminGroup_2.vizualizarInfos(user1));

        System.out.println("\nLista de usuarios de ADICIONAR_USUARIO:");
        System.out.println(adminGroup_2.getPermissaoAdicionar());
        System.out.println("\nLista de usuarios de REMVOER_USUARIO:");
        System.out.println(adminGroup_2.getPermissaoRemover());
        System.out.println("\nLista de usuarios de ALTERAR_USUARIO:");
        System.out.println(adminGroup_2.getPermissaoAlterar());
        System.out.println("\nLista de usuarios de VISUALIZAR_INFOS:");
        System.out.println(adminGroup_2.getPermissaoVizualizar());
        System.out.println("\nLista de usuarios de CRIAR_CARTAO:");
        System.out.println(adminGroup_2.getPermissaoCriarCartao());


        //Criando Cartões
        permissoes.add(Permissoes.CRIAR_CARTAO);
        adminGroup_2.adicionaMembro(admin, userConvid, permissoes);
        adminGroup_2.adicionarPermissao(admin, user2, permissoes);

        admin.criarCartao(0);
        user1.criarCartao(1);
        user2.criarCartao(1);
        userConvid.criarCartao(0);

        System.out.println("\n\nCartões Criados");
        System.out.println("Grupo Privado");
        System.out.println(adminGroup_1.getListaCartoes());
        System.out.println("Grupo Publico");
        System.out.println(adminGroup_2.getListaCartoes());

    }
}