package paymentmethods;

public class DebitCardStrategy implements PriceStrategy{

    private final double DESCONTO = 0.95;

    @Override
    public Double calculate(Double price) {
        return price * DESCONTO;
    }
}
