import paymentmethods.PaymentMethod;

public class Order {

    private Double price;
    private PaymentMethod paymentMethod;

    public Order(Double price, PaymentMethod paymentMethod) {
        this.price = price;
        this.paymentMethod = paymentMethod;
    }

    public Double getPrice() {
        return price;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
