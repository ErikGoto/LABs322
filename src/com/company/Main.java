//Respostas
/**3.1.1 A estratégia abordada será a utilização de Classe Abstrata.
 * Esta implementação foi escolhida, pois "GrupoPrivado" e "GrupoPublico" são tipos específicos de "Grupo", portanto
 * nada mais justo que ambos os grupos herdarem da Classe "grupo".
 * Outro motivo para "Grupo" ser classe abstrata é que usamos métodos em suas classes filhas que modificam o estado do
 * objeto ao qual pertencem.
 * Caso optássemos por usar Intefaces não seria possível usar atributos não estáticos e não finais apropriadamente. 
 *
 *3.1.4 Em uma abordagem diferente poderíamos usar Usuário como uma interface caso expandíssemos o intuito do projeto,
 * criando, assim, várias classes sem uma relação entre si. Um exemplo: um usuário de um app de conversas, e um usuário
 * de um serviço público, como o SUS; ambos podem implementar a classe Usuário, pois precisam de métodos semelhantes.
 *      As alterações necessárias seriam especificar os métodos nas classes que implementam "Usuário".
 */

package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        //Instanciando os objetos
        Perfil perfilAdm = new Perfil(Sexo.MASCULINO, new GregorianCalendar(), "Cidadezinha", Estado.ACRE,
                "12321654", "Descrição do Perfil Admin", "foto.png");
        Perfil perfilUserC = new Perfil(Sexo.FEMININO, new GregorianCalendar(), "Cidadezona", Estado.AMAZONAS,
                "12321654", "Descrição do Perfil Admin", "foto.png");

        Admin admin = new Admin(1, "Admin", "Email", "Senha", new GregorianCalendar(), true,
                perfilAdm);
        Admin admin2 = new Admin(2, "Admin2", "Email2", "Senhaaaa", new GregorianCalendar(), true,
                perfilAdm);
        UsuarioComum userComum1 = new UsuarioComum(2, "Usuario Comum", "emailcommumuser.com",
                "Senha", new GregorianCalendar(), true, perfilUserC);
        UsuarioComum userComum2 = new UsuarioComum(3, "Usuario Comum2", "emailcommumuser.com",
                "Senha", new GregorianCalendar(), true, perfilUserC);
        UsuarioConvidado userConvid = new UsuarioConvidado(4, "Usuario Convidado", "emailcommumuser.com",
                "Senha", new GregorianCalendar(), true, new GregorianCalendar(), perfilUserC);


        //Testes em Grupo Privado--------------------------------------------------------------------------------------
        Grupo grupoPrivado = admin.criarGrupo(admin, "GrupoAdmin1", "Descrição do Grupo",
                true);

        grupoPrivado.adicionaMembro(admin, userComum1, new ArrayList<>());
        grupoPrivado.adicionaMembro(admin, userComum2, new ArrayList<>());
        grupoPrivado.adicionaMembro(admin, admin2, new ArrayList<>());
        grupoPrivado.adicionaMembro(admin, userConvid, new ArrayList<>());

        //Criando os cartões
        admin.criarCartao(0, 1, "Fazer lab de MC", admin, true, new GregorianCalendar(),
                "Terminar o lab de MC", userComum1, 1);
        admin.criarCartao(0, 1, "Estudar para a Prova de Estática", admin, true,
                new GregorianCalendar(),"Estudar", userComum1, 4);
        admin.criarCartao(0, 1, "Estudar para a Prova de Termodinamica", admin, true,
                new GregorianCalendar(),"Estudar", userComum1, 1);
        admin.criarCartao(0, 1, "Estudar para a Prova de AlgeLin", admin, true,
                new GregorianCalendar(),"Estudar", userComum1, 2);
        admin.criarCartao(0, 1, "Estudar para a Prova de MC", admin, true,
                new GregorianCalendar(),"Estudar", userComum1, 3);
        admin.criarCartao(0, 1, "Estudar para a Prova de alguma matéria", admin, true,
                new GregorianCalendar(),"Estudar", userComum1, 3);

        System.out.println("Cartoes criados no grupo Privado");
        System.out.println(grupoPrivado.getCartoesAFazer());


        //Testes em Grupo Publico--------------------------------------------------------------------------------------
        Grupo grupoPublico = admin.criarGrupo(admin, "GrupoPublico", "Descrição do Grupo",
                false);

        grupoPublico.adicionaMembro(admin, userComum1, new ArrayList<>());
        grupoPublico.adicionaMembro(admin, userComum2, new ArrayList<>());
        grupoPublico.adicionaMembro(admin, admin2, new ArrayList<>());
        grupoPublico.adicionaMembro(admin, userConvid, new ArrayList<>());

        //Criando os cartões
        admin.criarCartao(1, 1, "Fazer comida", admin, true, new GregorianCalendar(),
                "Comida", userComum2, 1);
        admin.criarCartao(1, 1, "Aprender a cozinhar", admin, true,
                new GregorianCalendar(),"Comida", userComum2, 4);
        admin.criarCartao(1, 1, "Comprar um aquário", admin, true,
                new GregorianCalendar(),"Adotar um peixe dourado", userComum2, 1);
        admin.criarCartao(1, 1, "Dar um banho no meu novo peixe dourado", admin, true,
                new GregorianCalendar(),"Peixe", userComum2, 2);
        admin.criarCartao(1, 1, "Levar meu peixinho pra passear", admin, true,
                new GregorianCalendar(),"Dar uma caminhada. OBS: Não colocar uma coleira no peixe, levá-lo " +
                        "dentro do aquário", userComum2, 3);
        admin.criarCartao(1, 1, "Comprar um Ganso", admin, true,
                new GregorianCalendar(),"Compra um aquário maior pro ganso. OBS: Não deixar o ganso comer o " +
                        "peixinho dourado", userComum2, 3);


        System.out.println("--------------------------------------------------------------------------------------\n" +
                "Cartoes criados no grupo Publico");
        System.out.println(grupoPublico.getCartoesAFazer());


        System.out.println("--------------------------------------------------------------------------------------\n" +
                "Execução de alguns cartões de userComum1");
        userComum1.executarTarefaDeMaiorPrioridade();
        userComum1.executarTarefaDeMaiorPrioridade();
        userComum1.executarTarefaDeMaiorPrioridade();
        userComum1.executarTarefaDeMaiorPrioridade();

        System.out.println("--------------------------------------------------------------------------------------\n" +
                "Execução de alguns cartões de userComum2");
        userComum2.executarTarefaDeMaiorPrioridade();
        userComum2.executarTarefaDeMaiorPrioridade();
        userComum2.executarTarefaDeMaiorPrioridade();
        userComum2.executarTarefaDeMaiorPrioridade();

        //System.out.println(grupoPrivado.getCartoesFeitos());

    }
}