public class DigitalWalletPayment implements PaymentMethod{
    @Override
    public void processPayment(double amount) {
        System.out.println("Paying with Digital Wallet: $" + amount);
    }
}
