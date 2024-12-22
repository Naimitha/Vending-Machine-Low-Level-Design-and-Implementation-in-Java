// Coin payment method implementation
public class CoinPayment implements Payment {
    // Method to process coin payment
    @Override
    public boolean makePayment(float amount) {
        System.out.println("Paying $" + amount + " in coins.");
        return true;  // Payment is successful
    }
}
