//Respostas
/*
1. Ambos os atributos não podem ser modificados depois de definidos seus respectivos valores. Podemos considerar os tipos
enum como objetos estaticos:
    public static final Sexo Masculino = new Sexo("M", "Masculino");
Sendo mais prático trabalhar com enum se tivermos um numero finito de opções para variáveis.

2. Ao tentar instanciar o enum permissões temos o seguitne retorno;
    enum types may not be instantiated
Isso ocorre pois os atributos enum são objetos por sua essência, sendo impossível instanciar o mesmo objeto duas vezes.

3.Relaçao entre Grupo, GrupoPublico e GrupoPrivado -> Composição, se a classe Grupo for removida as outras duas classes
filhas deixam de existir;

Relação entre Grupo e Usuário -> Associação, o Grupo possui Usuario e um Usuario é referente a um Grupo

Relação entre Usuario e Sala -> Agregação, a Sala possui um usuário, mas se a Sala for excluida o Usuário ainda pode ser
usado em outros lugares.

4. Em todas as relações a multiplicidade é de muitos para ambas as extremidades. Pois, Grupo possui diversos usuarios,
usuarios estão em varios grupos. Usuarios podem estar em várias salas, e salas podem ter vários usuarios

 */

package com.company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        Perfil perfil = new Perfil(Sexo.FEMININO, new GregorianCalendar(), "Cidade", Estado.PARAIBA, "Telefone", "Descricao", "Foto");

        //Cria os usuarios e grupo
        Admin admin1 = new Admin(1, "Login do Admin1", "Email do Admin1", "SenhaDoAdmin1", new GregorianCalendar(), true);
        Admin admin2 = new Admin(2, "Login do Admin2", "Email do Admin2", "SenhaDoAdmin2", new GregorianCalendar(), true);
        //Grupo publico
        admin1.criarGrupo(admin1,"Este grupo é um Grupo Publico", "Descricao do grupo Publico", false);
        GrupoPublico grupoPub = (GrupoPublico) admin1.getGrupos().get(0);
        //Grupo privado
        admin2.criarGrupo(admin2,"Este é um Grupo Privado", "Descricao do grupo privado", true);
        GrupoPrivado grupoPriv = (GrupoPrivado) admin2.getGrupos().get(0);

        Usuario user1_priv = new Usuario(1, "Login_priv", "Email", "Senha", new GregorianCalendar(), true);
        Usuario user2_priv = new Usuario(2, "Login2_priv", "Email2", "Senha2", new GregorianCalendar(), true);
        Usuario user3_priv = new Usuario(3, "Login3_priv", "Email3", "Senha3", new GregorianCalendar(), true);
        Usuario user4_priv = new Usuario(4, "Login4_priv", "Email4", "Senha4", new GregorianCalendar(), true);

        Usuario user1_pub = new Usuario(5, "Login_pub", "Email", "Senha", new GregorianCalendar(), true);
        Usuario user2_pub = new Usuario(6, "Login2_pub", "Email2", "Senha2", new GregorianCalendar(), true);
        Usuario user3_pub = new Usuario(7, "Login3_pub", "Email3", "Senha3", new GregorianCalendar(), true);
        Usuario user4_pub = new Usuario(8, "Login4_pub", "Email4", "Senha4", new GregorianCalendar(), true);

        //Adcionando os usuarios em seus respectivos grupos
        grupoPriv.adicionaMembro(admin2, user1_priv);
        grupoPriv.adicionaMembro(admin2, user2_priv);
        grupoPriv.adicionaMembro(admin2, user3_priv);
        grupoPriv.adicionaMembro(admin2, user4_priv);

        grupoPub.adicionaMembro(admin1, user1_pub);
        grupoPub.adicionaMembro(admin1, user2_pub);
        grupoPub.adicionaMembro(admin1, user3_pub);
        grupoPub.adicionaMembro(admin1, user4_pub);

//Testes com o grupo publico----------------------------------------------------------------------------------------------------
        /*Vamos testar as permissões de user1_pub e user2_pub. Note que, user1_pub terá todas as permissões, mas user2_pub
        só terá permissão para vizualizar:*/

        //Primeiramente, removendo todas as permissões de user2_pub:
        ArrayList listaPermissoes = new ArrayList();
        listaPermissoes.add(Permissoes.ADICIONAR_USUARIO);
        listaPermissoes.add(Permissoes.REMOVER_USUARIO);
        listaPermissoes.add(Permissoes.ALTERAR_USUARIO);
        grupoPub.removerPermissao(user1_pub, user2_pub, listaPermissoes);

        //Adicionar membros:
        grupoPub.adicionaMembro(user1_pub, user1_priv);
        grupoPub.adicionaMembro(user2_pub, user2_priv);
        System.out.println("\nNovos membros adicionados no grupo público:");
        System.out.println(grupoPub.getMembros());

        //Removendo membros:
        grupoPub.removeMembro(user1_pub, user1_priv);
        grupoPub.removeMembro(user2_pub, user1_pub);
        System.out.println("\nMembros removidos do grupo público:");
        System.out.println(grupoPub.getMembros());

        //Alterando permissão de membros:
        grupoPub.removerPermissao(user1_pub, user3_pub, listaPermissoes);
        grupoPub.removerPermissao(user2_pub, user1_pub, listaPermissoes);
        System.out.println("\nArray List PermissaoRemover contem user2_pub?:");
        System.out.println(grupoPub.getPermissaoRemover().contains(user2_pub));
        System.out.println("Array List PermissaoRemover contem user1_pub?:");
        System.out.println(grupoPub.getPermissaoRemover().contains(user1_pub));

        //Vizualizando os dados do grupo
        System.out.println("\nVizualizando os dados do grupo:");
        System.out.println(grupoPub.vizualizarInfos(user1_pub));

        //Lista de usuarios de cada permissão:
        System.out.println("\nLista de usuarios com permissão de remover");
        System.out.println(grupoPub.getPermissaoRemover());
        System.out.println("\nLista de usuarios com permissão de adicionar");
        System.out.println(grupoPub.getPermissaoAdicionar());
        System.out.println("\nLista de usuarios com permissão de alterar");
        System.out.println(grupoPub.getPermissaoAlterar());
        System.out.println("\nLista de usuarios com permissão de vizualizar");
        System.out.println(grupoPub.getPermissaoVizualizar());

//Testes com o grupo privado----------------------------------------------------------------------------------------------------
        System.out.println("\nTestes com o grupo privado----------------------------------------------------------------------------------------------------");
        System.out.println("\nVizualização dos dados do grupo");
        System.out.println(grupoPriv.vizualizarInfos(admin2));

        //Alterando permissões de user1_priv e user2_priv:
        grupoPriv.adicionarPermissao(admin2, user1_priv, listaPermissoes);
        grupoPriv.adicionarPermissao(admin2, user2_priv, listaPermissoes);
        System.out.println("\nAlterando permissões de user1_priv e user2_priv:");
        System.out.println("Array List Permissao contem user1_priv?:");
        System.out.println(grupoPriv.getPermissaoRemover().contains(user1_priv));
        System.out.println("Array List Permissao contem user2_priv?:");
        System.out.println(grupoPriv.getPermissaoRemover().contains(user2_priv));

        //Tetando as permissões:
        grupoPriv.adicionaMembro(user1_priv, user1_pub);
        grupoPriv.adicionaMembro(user3_priv, user3_pub);//Não possui permissão de adicionar
        System.out.println("\nLista de membros após o Usuario DONO dar a permissão de adicionar membros");
        System.out.println(grupoPriv.getMembros());

        grupoPriv.removeMembro(user1_priv, user1_pub);
        grupoPriv.removeMembro(user3_priv, user1_priv);//Não possui permissão de remover
        System.out.println("\nLista de membros após o Usuario DONO dar a permissão de remover membros");
        System.out.println(grupoPriv.getMembros());

        //Lista de usuarios de cada permissão:
        System.out.println("\nLista de usuarios com permissão de remover");
        System.out.println(grupoPriv.getPermissaoRemover());
        System.out.println("\nLista de usuarios com permissão de adicionar");
        System.out.println(grupoPriv.getPermissaoAdicionar());
        System.out.println("\nLista de usuarios com permissão de alterar");
        System.out.println(grupoPriv.getPermissaoAlterar());
        System.out.println("\nLista de usuarios com permissão de vizualizar");
        System.out.println(grupoPriv.getPermissaoVizualizar());
    }
}