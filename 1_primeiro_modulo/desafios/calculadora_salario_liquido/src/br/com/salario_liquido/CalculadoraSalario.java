package br.com.salario_liquido;

public class CalculadoraSalario {

    public long calcularSalarioLiquido(double salarioBase) {
        double salarioLiquido = 0.00;
        if (salarioBase >= 1039) {
            salarioLiquido = calcularInss(salarioBase);
            salarioLiquido = calcularIrrf(salarioLiquido);
        }
        return Math.round(salarioLiquido);
    }

    private double calcularInss(double salarioBase) {
        if(salarioBase <= 1500){
            salarioBase -= salarioBase * 0.08;
        } else if (salarioBase < 4000) {
            salarioBase -= salarioBase * 0.09;
        } else {
            salarioBase -= salarioBase * 0.11;
        }
        return salarioBase;
    }

    private double calcularIrrf(double salarioLiquidoSemIrrf){
        if (salarioLiquidoSemIrrf > 6000){
            salarioLiquidoSemIrrf -= salarioLiquidoSemIrrf * 0.15;
        } else if (salarioLiquidoSemIrrf > 3000){
            salarioLiquidoSemIrrf -= salarioLiquidoSemIrrf * 0.075;
        }
        return salarioLiquidoSemIrrf;
    }
}
