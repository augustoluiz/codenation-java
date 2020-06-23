import br.com.salario_liquido.CalculadoraSalario;

public class Principal {
    public static void main(String[] args) {
        CalculadoraSalario cs = new CalculadoraSalario();
        System.out.println("Salario base: R$ 1.039,00 -> "+cs.calcularSalarioLiquido(1500.00));
    }
}
