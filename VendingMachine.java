// Interface for vending machine functionality
import java.util.List;

public interface VendingMachine {
    // Method to display available products
    void displayProducts();

    // Method to handle the purchase of products
    boolean purchaseProducts(List<String> productIds, Payment payment);

    // Method to refill stock of a specific product
    void refillStock(String id, int quantity);
}
