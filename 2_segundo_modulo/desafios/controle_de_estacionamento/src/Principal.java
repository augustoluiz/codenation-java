import br.com.controller.Estacionamento;
import br.com.model.Carro;
import br.com.model.Motorista;
import br.com.model.enums.Cor;

import static java.util.concurrent.ThreadLocalRandom.current;

public class Principal {

    public static void main(String[] args) {

        Motorista.builder().withNome("Ada")
                .withIdade(17)
                .withPontos(10)
                .build();

        Estacionamento e = new Estacionamento();
        Motorista ada = Motorista.builder().withNome("Ada").withIdade(60)
                .withPontos(3)
                .withHabilitacao("1231")
                .build();

        Carro carroBranco = Carro.builder().withCor(Cor.BRANCO).
                withPlaca("123")
                .withMotorista(ada)
                .build();

        e.estacionar(carroBranco);

        for (int indice = 1; indice <= 10; indice++) {

            Motorista motorista = Motorista.builder()
                    .withNome("Motorista " + indice)
                    .withIdade(60)
                    .withPontos(3)
                    .withHabilitacao(Long.toString(current().nextLong()))
                    .build();

            Carro carro = Carro.builder().withCor(Cor.BRANCO).
                    withPlaca("123")
                    .withMotorista(motorista)
                    .build();

            e.estacionar(carro);
        }
        System.out.println(e.carrosEstacionados());
        System.out.println(e.carroEstacionado(carroBranco));
    }
}
