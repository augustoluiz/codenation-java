package br.com.classe;

import br.com.annotation.Somar;
import br.com.annotation.Subtrair;

import javax.xml.ws.soap.MTOM;
import java.math.BigDecimal;

public class Teste {

    private String nome;

    private String nome1;

    @Somar
    private BigDecimal numero;
    @Somar
    protected BigDecimal num2 = BigDecimal.ONE;
    //11


    @Subtrair
    private BigDecimal num3 = BigDecimal.ONE;

    @Subtrair
    private BigDecimal num4 = new BigDecimal(4);
    //5

    //6
    public void mostrarNome(){
        System.out.println(nome);
    }

    private BigDecimal getNumero(){
        return this.numero;
    }

    public void setNumero(BigDecimal numero){
        this.numero = numero;
    }

}
