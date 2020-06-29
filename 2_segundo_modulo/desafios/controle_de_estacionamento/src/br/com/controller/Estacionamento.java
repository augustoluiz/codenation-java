package br.com.controller;

import br.com.exceptions.EstacionamentoException;
import br.com.model.Carro;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private final int VAGAS = 10;
    private List<Carro> carros = new ArrayList<>();
    private List<Carro> carrosEstacionados = new ArrayList<>();

    public void estacionar(Carro carro) {
        if(carrosEstacionados() == VAGAS){
            retiraPrimeiro(carro);
        }
        if(!carroCadastrado(carro)){
            carros.add(carro);
        }
        if(!carroEstacionado(carro)){
            carrosEstacionados.add(carro);
        }
    }

    public int carrosEstacionados() {
        return carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carrosEstacionados.stream()
                                 .anyMatch(c -> c.hashCode() == carro.hashCode());
    }

    private boolean carroCadastrado(Carro carro){
        return carros.stream()
                     .anyMatch(c -> c.hashCode() == carro.hashCode());
    }

    private void retiraPrimeiro(Carro carro){
       carrosEstacionados.remove(carrosEstacionados.stream()
                                .filter(c -> c.getMotorista().getIdade() < 55)
                                .findFirst()
                                .orElseThrow(() -> new EstacionamentoException("Não é possível estacionar no momento. " +
                                        "Último carro a tentar estacionar: "+carro.toString())));
    }
}
