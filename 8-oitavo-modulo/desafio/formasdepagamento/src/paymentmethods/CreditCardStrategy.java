package paymentmethods;

public class CreditCardStrategy implements PriceStrategy{

    private final double DESCONTO = 0.98;

    @Override
    public Double calculate(Double price) {
        return price * DESCONTO;
    }
}
