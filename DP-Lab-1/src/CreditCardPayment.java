public class CreditCardPayment implements PaymentMethod{
    @Override
    public void processPayment(double amount) {
        System.out.println("Paying with credit card: $" + amount);
    }
}
