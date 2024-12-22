// Cash payment method implementation
public class CashPayment implements Payment {
    // Method to process cash payment
    @Override
    public boolean makePayment(float amount) {
        System.out.println("Paying $" + amount + " in cash.");
        return true;  // Payment is successful
    }
}
