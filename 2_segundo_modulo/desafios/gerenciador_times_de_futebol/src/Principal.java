import br.com.controller.Controladora;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Principal {

    public static void main(String[] args) {

        Controladora c = new Controladora();
        List<Long> idJogadoresPorHabilidade = new ArrayList<>();
        idJogadoresPorHabilidade = c.buscarTopJogadores(3);
        System.out.println(idJogadoresPorHabilidade.size());
        idJogadoresPorHabilidade.forEach(j -> System.out.println(j));

        System.out.println("A: "+c.buscarTimes());
        c.incluirTime(001L, "Corinthians", LocalDate.of(1910, 9, 1), "Branco", "Preto");
        c.incluirTime(002L, "Palmeiras", LocalDate.of(1914, 8, 26), "Verde", "Branco");
        c.incluirTime(003L, "São Paulo", LocalDate.of(1930, 1, 25), "Branco", "Tricolor(Vermelho, Preto e Branco)");
        c.incluirTime(004L, "Santos", LocalDate.of(1912, 4, 14), "Branco com Preto", "Branco");
        c.incluirTime(005L, "Flamengo", LocalDate.of(1895, 11, 17), "Preto e Vermelho", "Branco");
        //c.incluirTime(005L, "Flamengo1", LocalDate.of(1895, 11, 17), "Preto e Vermelho", "Branco");

        c.incluirJogador(354L, 001L, "Cássio", LocalDate.of(1999, 8, 12), 8, new BigDecimal("800000.00"));
        c.incluirJogador(001L, 001L, "Fágner", LocalDate.of(2000, 9, 1), 7, new BigDecimal("900000.00"));


        List<Long> idTimes = c.buscarTimes();
        idTimes.stream().forEach(id -> System.out.println(id));
        c.definirCapitao(001L);
        //c.definirCapitao(002L);
        c.definirCapitao(001L);
        //c.definirCapitao(002L);
        System.out.println("Id do Capitão: "+c.buscarCapitaoDoTime(001L));
        //System.out.println("Id do Capitão: "+c.buscarCapitaoDoTime(005L));
        System.out.println("Nome do jogador: "+c.buscarNomeJogador(001L));
        System.out.println("Nome do time: "+c.buscarNomeTime(005L));
        System.out.println("Maior Salário: "+c.buscarJogadorMaiorSalario(001L));
        System.out.println("Salário do Jogador: "+c.buscarSalarioDoJogador(001L));
        System.out.println("Ids ordenado dos jogadores do time");
        List<Long> idJogadores = c.buscarJogadoresDoTime(001L);
        idJogadores.forEach(i -> System.out.println(i));
        System.out.println("Melhor jogador do Time: "+c.buscarMelhorJogadorDoTime(001L));
        System.out.println("Jogador mais velho: "+c.buscarJogadorMaisVelho(001L));
        //List<Long> idJogadoresPorHabilidade = new ArrayList<>();
        //idJogadoresPorHabilidade = c.buscarTopJogadores(3);
        //idJogadoresPorHabilidade.forEach(j -> System.out.println(j));
        //c.buscarTopJogadores(1);
    }

}
