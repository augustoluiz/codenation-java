package paymentmethods;

public class TransferStrategy implements PriceStrategy{

    private final double DESCONTO = 0.92;

    @Override
    public Double calculate(Double price) {
        return price * DESCONTO;
    }
}
