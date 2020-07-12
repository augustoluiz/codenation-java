package br.com.classe;

import br.com.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;

public class CalculadorDeClasses implements Calculavel {

    private final String TIPO = "BIGDECIMAL";

    @Override
    public BigDecimal somar(Object obj) {
        return somaValores(obj, "Somar");
    }

    @Override
    public BigDecimal subtrair(Object obj) {
        return somaValores(obj, "Subtrair");
    }

    @Override
    public BigDecimal totalizar(Object obj) {
        return somar(obj).subtract(subtrair(obj));
    }

    private BigDecimal somaValores(Object obj, String annotation){
        Field fields[] = obj.getClass().getDeclaredFields();
        return Arrays.stream(fields).filter(f -> ehBigDecimal(f) && possuiAnnotation(f,annotation))
                .map(valor -> capturaValor(valor, obj))
                .reduce(BigDecimal.ZERO, (anterior, atual) -> atual.add(anterior));
    }

    private boolean ehBigDecimal(Field f){
        return f.getType().toString().toUpperCase().contains(TIPO);
    }

    private boolean possuiAnnotation(Field f, String annotation){
        return Arrays.stream(f.getDeclaredAnnotations()).anyMatch(an -> an.toString().contains(annotation));
    }

    private BigDecimal capturaValor(Field f, Object obj) {
        f.setAccessible(true);
        try {
            return (BigDecimal) f.get(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        } catch (NullPointerException npe){
            return BigDecimal.ZERO;
        }
    }

}