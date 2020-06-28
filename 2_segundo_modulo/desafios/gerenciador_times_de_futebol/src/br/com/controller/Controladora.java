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
        Jogador jogador = buscarJogador(id);
        Time time = buscarTime(idTime);

        if(jogador != null){
            throw new IdentificadorUtilizadoException("Já existe um jogador cadastrado com o id: "+id);
        }
        if(time == null){
            throw new TimeNaoEncontradoException("O time informado não existe! idTime informado: "+idTime);
        }
        Jogador novoJogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
        time.addJogadorNovo(novoJogador);

        jogadores.add(novoJogador);
        times.forEach(t -> {
            if (t.getId() == time.getId()){
                t = time;
            }
        });
    }

    @Override
    public void definirCapitao(Long idJogador) {
        Jogador jogador = buscarJogador(idJogador);
        if(jogador != null){
            Time time = buscarTime(jogador.getIdTime());
            if(time.getIdCapitado() != idJogador){
                time.setIdCapitado(idJogador);
            }
        } else {
            throw new JogadorNaoEncontradoException("O Jogador não existe! idJogador informado: "+idJogador);
        }
    }

    @Override
    public Long buscarCapitaoDoTime(Long idTime) {
        Time time = buscarTime(idTime);
        if(time != null){
            Long idCapitao = time.getIdCapitado();
            if(idCapitao != null){
                return idCapitao;
            }
            throw new CapitaoNaoInformadoException("Este time não possui um capitão! idTime: "+idTime);
        }
        throw new TimeNaoEncontradoException("O time informado não existe! idTime informado: "+idTime);
    }

    @Override
    public String buscarNomeJogador(Long idJogador) {
        Jogador jogador = buscarJogador(idJogador);
        if(jogador != null){
            return jogador.getNome();
        }
        throw new JogadorNaoEncontradoException("O Jogador não existe! idJogador informado: "+idJogador);
    }

    @Override
    public String buscarNomeTime(Long idTime) {
        Time time = buscarTime(idTime);
        if(time != null){
            return time.getNome();
        }
        throw new TimeNaoEncontradoException("O time informado não existe! idTime informado: "+idTime);
    }

    @Override
    public Long buscarJogadorMaiorSalario(Long idTime) {
        Time time = buscarTime(idTime);
        if(time != null) {
            return time.getJogadores().stream()
                        .reduce((anterior, atual) -> {
                            if (anterior.getSalario().compareTo(atual.getSalario()) == 1 ||
                                anterior.getSalario().compareTo(atual.getSalario()) == 0 &&
                                anterior.getId() < atual.getId()) {
                                    atual = anterior;
                                }
                            return atual;
                        })
                        .get()
                        .getId();
        }
        throw new TimeNaoEncontradoException("O time informado não existe! idTime informado: "+idTime);
    }

    @Override
    public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        Jogador jogador = buscarJogador(idJogador);
        if(jogador != null){
            return jogador.getSalario();
        }
        throw new JogadorNaoEncontradoException("O Jogador não existe! idJogador informado: "+idJogador);
    }

    @Override
    public List<Long> buscarJogadoresDoTime(Long idTime) {
        Time time = buscarTime(idTime);
        if(time != null){
            List<Jogador> jogadores = time.getJogadores();
            return jogadores.stream()
                            .map(jogador -> jogador.getId())
                            .sorted()
                            .collect(Collectors.toList());
        }
        throw new TimeNaoEncontradoException("O time informado não existe! idTime informado: "+idTime);
    }

    @Override
    public Long buscarMelhorJogadorDoTime(Long idTime) {
        Time time = buscarTime(idTime);
        if(time != null){
            List<Jogador> jogadores = time.getJogadores();
            return jogadores.stream()
                            .reduce((anterior, atual) -> {
                                atual = anterior.getNivelHabilidade() > atual.getNivelHabilidade() ? anterior : atual;
                                return atual;
                            })
                            .get()
                            .getId();
        }
        throw new TimeNaoEncontradoException("O time informado não existe! idTime informado: "+idTime);
    }

    @Override
    public Long buscarJogadorMaisVelho(Long idTime) {
        Time time = buscarTime(idTime);
        if(time != null){
            List<Jogador> jogadores = time.getJogadores();
            return jogadores.stream()
                    .reduce((anterior, atual) -> {
                        atual = anterior.getDataNascimento().isBefore(atual.getDataNascimento()) || anterior.getDataNascimento().isEqual(atual.getDataNascimento()) && anterior.getId() < atual.getId() ? anterior : atual;
                        return atual;
                    })
                    .get()
                    .getId();
        }
        throw new TimeNaoEncontradoException("O time informado não existe! idTime informado: "+idTime);
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
        Collections.sort(jogadoresPorHabilidade, comparaHabilidade.reversed());
        return jogadoresPorHabilidade.stream().map(j -> j.getId()).limit(top).collect(Collectors.toList());
    }

    private Jogador buscarJogador(Long idJogador){
        Jogador jogador;
        try {
            jogador = jogadores.stream()
                               .filter(jogadorStream -> jogadorStream.getId().equals(idJogador))
                               .findFirst()
                               .get();
        } catch (NoSuchElementException nse){
            jogador = null;
        }

        return jogador;
    }

    private Time buscarTime(Long idTime){
        Time time;
        try {
            time = times.stream()
                        .filter(t -> t.getId() == idTime)
                        .findFirst()
                        .get();
        } catch (NoSuchElementException nse){
            time = null;
        }

        return time;
    }
}
