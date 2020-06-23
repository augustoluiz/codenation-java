import br.com.fibonacci.Fibonacci;

public class Principal {

    public static void main(String[] args) {

        Fibonacci f = new Fibonacci();
        System.out.println("Sequência de Fibonacci até 350");
        for(Integer i: f.fibonacci()){
            System.out.print(" "+i+" ");
        }
        System.out.println("\n");
        System.out.println("O número "+1+" está na sequência? "+f.isFibonacci(1));
        System.out.println("O número "+2+" está na sequência? "+f.isFibonacci(2));
        System.out.println("O número "+3+" está na sequência? "+f.isFibonacci(3));
        System.out.println("O número "+4+" está na sequência? "+f.isFibonacci(4));
        System.out.println("O número "+5+" está na sequência? "+f.isFibonacci(5));
        System.out.println("O número "+350+" está na sequência? "+f.isFibonacci(350));

    }

}
