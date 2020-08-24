package paymentmethods;

public class CashStrategy implements PriceStrategy{

    private final double DESCONTO = 0.9;

    @Override
    public Double calculate(Double price) {
        return price * DESCONTO;
    }
}
