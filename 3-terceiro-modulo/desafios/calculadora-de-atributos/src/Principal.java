import br.com.classe.CalculadorDeClasses;
import br.com.classe.Teste;

import java.math.BigDecimal;

public class Principal {

    public static void main(String[] args) {

        Teste t = new Teste();
        t.setNumero(BigDecimal.TEN);
        CalculadorDeClasses c = new CalculadorDeClasses();
        c.somar(t);
        System.out.println("Soma: "+c.somar(t));
        System.out.println("Subtração: "+c.subtrair(t));
        System.out.println("Total: "+c.totalizar(t));
    }

}
