// Credit card payment method implementation
public class CreditCardPayment implements Payment {
    private String cardNumber;

    // Constructor to initialize the credit card payment with a card number
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    // Method to process credit card payment
    @Override
    public boolean makePayment(float amount) {
        System.out.println("Paying $" + amount + " using credit card " + cardNumber);
        return true;  // Payment is successful
    }
}
