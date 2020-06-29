package br.com.model;

import br.com.exceptions.EstacionamentoException;

import java.util.Objects;

public class Motorista {

    private final String nome;
    private final int idade;
    private final int pontos;
    private final String habilitacao;

    private Motorista(String nome, int idade, int pontos, String habilitacao) {
        validaMotorista(nome, habilitacao);
        this.nome = nome;
        this.idade = idade;
        this.pontos = pontos;
        this.habilitacao = habilitacao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    private void validaMotorista(String nome, String habilitacao){
        if (habilitacao == null || nome == null){
            throw new NullPointerException("O motorista não possui habilitação e/ou nome");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return Objects.equals(habilitacao, motorista.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(habilitacao);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontos=" + pontos +
                ", habilitacao='" + habilitacao + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }


    public static class MotoristaBuilder {

        private String nome;
        private int idade;
        private int pontos;
        private String habilitacao;
        private final int PONTUACAO_MAX = 20;

        private MotoristaBuilder() {
        }

        public MotoristaBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public MotoristaBuilder withIdade(int idade) {
            if (idade < 0){
                throw new IllegalArgumentException("O motorista não pode possuir a idade negativa");
            } else if (idade < 18){
                throw new EstacionamentoException("O motorista não pode ser menor de idade");
            }
            this.idade = idade;
            return this;
        }

        public MotoristaBuilder withPontos(int pontos) {
            if(pontos < 0){
                throw new IllegalArgumentException("O motorista não pode possuir a quantidade de pontos negativa");
            } else if(pontos > PONTUACAO_MAX){
                throw new EstacionamentoException("O motorista não pode ter a carteira suspensa");
            }
            this.pontos = pontos;
            return this;
        }

        public MotoristaBuilder withHabilitacao(String habilitacao) {
            this.habilitacao = habilitacao;
            return this;
        }


        public Motorista build() {
            return new Motorista(nome, idade, pontos, habilitacao);
        }
    }

}
