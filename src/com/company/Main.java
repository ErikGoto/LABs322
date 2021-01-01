//Respostas
/**3.1.1 A estratégia abordada será a utilização de Classe Abstrata.
 * Esta implementação foi escolhida, pois "GrupoPrivado" e "GrupoPublico" são tipos específicos de "Grupo", portanto
 * nada mais justo que ambos os grupos herdarem da Classe "grupo".
 * Outro motivo para "Grupo" ser classe abstrata é que usamos métodos em suas classes filhas que modificam o estado do
 * objeto ao qual pertencem.
 * Caso optássemos por usar Intefaces não seria possível usar atributos não estáticos e não finais apropriadamente. 
 *
 *3.1.4
 */

package com.company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Cartao cartao1 = new Cartao();
        Cartao cartao2 = new Cartao();

        cartao1.setPrioridade(5);
        cartao2.setPrioridade(4);


        System.out.println(cartao1.compareTo(cartao2));
    }
}