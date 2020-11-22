//Respostas
/*
1. Ao criar um setter para modificar o valor dono de um grupo, aparece a mensagem de erro "Cannot assign a value to final
variable 'dono'", ou seja, por ser uma variável final só é possível atribuir valor a ela uma única vez e não é possível
mais modificá-la.

2. Mesmo com a variável final de grupo é possível alterar os atributos do grupo. Isso é possível, pois estamos alterando
atributos internos da variável, e não ela como um todo.

3. Se tivessemos usado um array ao invés de um ArrayList o tamanho do array deve ser definido ao criar a variável array.
E caso esse limite de elementos fosse alcançado não seria possível adicionar mais membros como fizemos com o ArrayList.
Concluindo, se usarmos o array teríamos que saber o número exato de elementos que seriam adicionados, e caso este limite
for excedido não será possível adicionar mais elementos.

4. O principal benefício de usar herança é a reutilização de código por meio do relacionamento entre classes pai e filhas.
Além disso, ao usar heranças conseguimos tornar o código mais organizado e fácil de interpretar.

5. Quando adicionamos final diretamente na classe grupo inutilizamos todo o conceito de herança, pois GrupoPrivado e
GrupoPublico não conseguem acessar e modificar os atributos herdados de Grupo. Isso ocorreu justamente porque definimos
que a classe grupo tem um valor final, que impossibilita novas modificações, e heranças. O mesmo não ocorre com GrupoPú_
blico, pois esta classe não é pai de nenhuma outra classe

6. Definimos adicionaMembro e removeMembro nas classes filhas, pois estes métodos são específicos de cada classe.
A implementação deles varia dependendo do grupo que chama o método. O adicionaMembro e removeMembro de GrupoPrivado deve
ter uma condição de adicionar membros(ou remover) apenas se o usuário que chamou o método for o dono do grupo. Já nos mé_
todos adicionaMembro e removeMembro de GrupoPublico qualquer usuário pode adicoinar e remover novos membros.

 */

package com.company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        Perfil perfil = new Perfil(Sexo.FEMININO, new GregorianCalendar(), "Cidade", Estado.PARAIBA, "Telefone", "Descricao", "Foto");

        //Cria os usuarios e grupo
        Usuario user1 = new Usuario(1, "Login", "Email", "Senha", new GregorianCalendar(), true);
        Usuario user2 = new Usuario(2, "Logi2", "Emai2", "Senh2", new GregorianCalendar(), true);
        //Grupo publico
        user1.criarGrupo("Nome Grupo Public", "Descricao do grupo Publico", false);
        GrupoPublico grupoPub = (GrupoPublico) user1.getGrupos().get(0);
        //Grupo privado
        user1.criarGrupo("Nome Grupo Privado", "Descricao do grupo privado", true);
        GrupoPrivado grupoPriv = (GrupoPrivado) user1.getGrupos().get(1);

        ArrayList<Permissoes> permissoes_teste;
        permissoes_teste = new ArrayList();
        permissoes_teste.add(Permissoes.ADICIONAR_USUARIO);
        permissoes_teste.add(Permissoes.REMOVER_USUARIO);
        permissoes_teste.add(Permissoes.VISUALIZAR_INFO);
        grupoPriv.adicionarPermissao(user2, user2, permissoes_teste);

        ((GrupoPublico) user1.getGrupos().get(0)).adicionaMembro(user2);
        System.out.println(((GrupoPublico) user1.getGrupos().get(0)).getMembros());

    }
}