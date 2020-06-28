package br.com.exceptions;

public class JogadorNaoEncontradoException extends RuntimeException{
    public JogadorNaoEncontradoException(String message) {
        super(message);
    }
}
