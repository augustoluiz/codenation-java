package br.com.fibonacci;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    //o método deve retornar uma lista java.util.List com os primeiros números Integer da série de Fibonacci até 350
    //A série de Fibonacci é a seguinte: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, etc...
    public List<Integer> fibonacci(){
        List<Integer> sequenciaFibonacci = new ArrayList<Integer>();
        int aux = 0;

        do{
            sequenciaFibonacci.add(aux);
            aux = aux == 0 ? aux + 1 : aux + sequenciaFibonacci.get(sequenciaFibonacci.size() -2);
        }while(!(sequenciaFibonacci.get(sequenciaFibonacci.size() -1) > 350));

        return sequenciaFibonacci;
    }

    public boolean isFibonacci(Integer num){
        return fibonacci().contains(num);
    }

}
