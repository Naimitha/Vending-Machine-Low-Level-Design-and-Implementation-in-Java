import java.util.List;

// Implementation of the VendingMachine interface for a snack vending machine
public class SnacksVendingMachine implements VendingMachine {
    private final StockManager stockManager;

    // Constructor initializing the stock manager
    public SnacksVendingMachine(StockManager stockManager) {
        this.stockManager = stockManager;
    }

    // Method to display the available products
    @Override
    public void displayProducts() {
        stockManager.displayProducts();
    }

    // Method to purchase products
    @Override
    public boolean purchaseProducts(List<String> productIds, Payment payment) {
        float totalPrice = stockManager.calculateTotalPrice(productIds);

        // Check if all selected products are available in stock
        for (String productId : productIds) {
            if (!stockManager.isProductAvailable(productId)) {
                System.out.println("Product ID " + productId + " is out of stock or invalid.");
                return false;
            }
        }

        // Process the payment if all products are available
        if (payment.makePayment(totalPrice)) {
            for (String productId : productIds) {
                stockManager.decreaseStock(productId);
            }
            return true;
        }

        return false;
    }

    // Method to refill the stock of a product
    @Override
    public void refillStock(String id, int quantity) {
        stockManager.refillStock(id, quantity);
    }
}
