package br.com.controller;

import br.com.exceptions.CapitaoNaoInformadoException;
import br.com.exceptions.IdentificadorUtilizadoException;
import br.com.exceptions.JogadorNaoEncontradoException;
import br.com.exceptions.TimeNaoEncontradoException;
import br.com.interfaces.MeuTimeInterface;
import br.com.jogador.Jogador;
import br.com.time.Time;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Controladora implements MeuTimeInterface {

    private List<Jogador> jogadores = new ArrayList<>();
    private List<Time> times = new ArrayList<>();

    @Override
    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        List<Long> idTimes = buscarTimes();
        if (idTimes.contains(id)){
            throw new IdentificadorUtilizadoException("Já existe um time cadastrado com o id: "+id);
        }
        Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
        times.add(time);
    }

    @Override
    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        jogadorExiste(id);
        Time time = buscarTime(idTime);

        Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
        time.addJogadorNovo(jogador);

        jogadores.add(jogador);
        times.forEach(t -> t = t.getId() == time.getId() ? time : t);
    }

    @Override
    public void definirCapitao(Long idJogador) {
        Jogador jogador = buscarJogador(idJogador);
        Time time = buscarTime(jogador.getIdTime());
        time.setIdCapitado(idJogador);
    }

    @Override
    public Long buscarCapitaoDoTime(Long idTime) {
        Time time = buscarTime(idTime);
        Long idCapitao = time.getIdCapitado();
        if(idCapitao != null){
            return idCapitao;
        }
        throw new CapitaoNaoInformadoException("Este time não possui um capitão! idTime: "+idTime);
    }

    @Override
    public String buscarNomeJogador(Long idJogador) {
        Jogador jogador = buscarJogador(idJogador);
        return jogador.getNome();
    }

    @Override
    public String buscarNomeTime(Long idTime) {
        Time time = buscarTime(idTime);
        return time.getNome();
    }

    @Override
    public Long buscarJogadorMaiorSalario(Long idTime) {
        Time time = buscarTime(idTime);
        return time.getJogadores().stream()
                    .reduce((anterior, atual) -> {
                          atual = anterior.getSalario().compareTo(atual.getSalario()) == 1 ||
                                  anterior.getSalario().compareTo(atual.getSalario()) == 0 &&
                                  anterior.getId() < atual.getId() ? anterior : atual;
                          return atual;
                     })
                    .get()
                    .getId();
    }

    @Override
    public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        Jogador jogador = buscarJogador(idJogador);
        return jogador.getSalario();
    }

    @Override
    public List<Long> buscarJogadoresDoTime(Long idTime) {
        Time time = buscarTime(idTime);
        return time.getJogadores()
                   .stream()
                   .map(jogador -> jogador.getId())
                   .sorted()
                   .collect(Collectors.toList());
    }

    @Override
    public Long buscarMelhorJogadorDoTime(Long idTime) {
        Time time = buscarTime(idTime);
        return time.getJogadores().stream()
                   .reduce((anterior, atual) -> {
                        atual = anterior.getNivelHabilidade() > atual.getNivelHabilidade() ? anterior : atual;
                        return atual;
                   })
                   .get()
                   .getId();
    }

    @Override
    public Long buscarJogadorMaisVelho(Long idTime) {
        Time time = buscarTime(idTime);
        return time.getJogadores()
                   .stream()
                   .reduce((anterior, atual) -> {
                        atual = anterior.getDataNascimento().isBefore(atual.getDataNascimento()) ||
                                anterior.getDataNascimento().isEqual(atual.getDataNascimento()) &&
                                anterior.getId() < atual.getId() ? anterior : atual;
                        return atual;
                   })
                   .get()
                   .getId();
    }

    @Override
    public List<Long> buscarTimes() {
        return times.stream()
                    .map(time -> time.getId())
                    .collect(Collectors.toList());
    }

    @Override
    public List<Long> buscarTopJogadores(Integer top) {
        Comparator<Jogador> comparaId = Comparator.comparing(Jogador::getId).reversed();
        Comparator<Jogador> comparaHabilidade = Comparator.comparing(Jogador::getNivelHabilidade)
                                                          .thenComparing(comparaId);
        List<Jogador> jogadoresPorHabilidade = jogadores;
        jogadoresPorHabilidade.sort(comparaHabilidade.reversed());

        return jogadoresPorHabilidade.stream()
                                     .map(j -> j.getId())
                                     .limit(top)
                                     .collect(Collectors.toList());
    }

    private Jogador buscarJogador(Long idJogador){
        return jogadores.stream()
                        .filter(jogadorStream -> jogadorStream.getId().equals(idJogador))
                        .findFirst()
                        .orElseThrow(() -> new JogadorNaoEncontradoException("O Jogador não existe! idJogador informado: "+idJogador));
    }

    private void jogadorExiste(Long idJogador){
        try {
            buscarJogador(idJogador);
            throw new IdentificadorUtilizadoException("Já existe um jogador cadastrado com o id: "+idJogador);
        } catch (JogadorNaoEncontradoException jne){
            return;
        }
    }

    private Time buscarTime(Long idTime){
        return times.stream()
                    .filter(t -> t.getId() == idTime)
                    .findFirst()
                    .orElseThrow(() -> new TimeNaoEncontradoException("O time informado não existe! idTime informado: "+idTime));
    }

}
