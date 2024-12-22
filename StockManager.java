import java.util.HashMap;
import java.util.Map;
import java.util.List;

// Helper class for managing the stock in the vending machine
public class StockManager {
    private final Map<String, Product> productMap;
    private final Map<String, Integer> inventoryMap;
    private final int REORDER_THRESHOLD = 3;
    private final int REFILL_QUANTITY = 5;

    // Constructor initializing the product inventory
    public StockManager() {
        this.productMap = new HashMap<>();
        this.inventoryMap = new HashMap<>();
        initializeProducts();
    }

    // Method to initialize some products in the stock
    private void initializeProducts() {
        addProduct("A1", new ConcreteProduct("Water", 1.0f), 10);
        addProduct("A2", new ConcreteProduct("Coke", 2.0f), 10);
        addProduct("A3", new ConcreteProduct("Juice", 1.5f), 10);
        addProduct("A4", new ConcreteProduct("Snack", 1.2f), 10);
    }

    // Method to add a product to the inventory
    private void addProduct(String id, Product product, int stock) {
        productMap.put(id, product);
        inventoryMap.put(id, stock);
    }

    // Method to get a product by its ID
    public Product getProductById(String productId) {
        return productMap.get(productId);
    }

    // Method to check if a product is available in stock
    public boolean isProductAvailable(String productId) {
        return inventoryMap.containsKey(productId) && inventoryMap.get(productId) > 0;
    }

    // Method to decrease the stock after a purchase
    public void decreaseStock(String productId) {
        if (inventoryMap.containsKey(productId)) {
            inventoryMap.put(productId, inventoryMap.get(productId) - 1);
            if (inventoryMap.get(productId) <= REORDER_THRESHOLD) {
                refillStock(productId, REFILL_QUANTITY);
            }
        }
    }

    // Method to refill the stock of a specific product
    public void refillStock(String productId, int quantity) {
        if (inventoryMap.containsKey(productId)) {
            inventoryMap.put(productId, inventoryMap.get(productId) + quantity);
            System.out.println("Refilled " + quantity + " of " + productMap.get(productId).getName());
        } else {
            System.out.println("Invalid product ID.");
        }
    }

    // Method to display available products
    public void displayProducts() {
        System.out.println("Available Products:");
        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            String id = entry.getKey();
            Product product = entry.getValue();
            System.out.println("ID: " + id + ", Name: " + product.getName() +
                               ", Price: $" + product.getPrice() +
                               ", Stock: " + inventoryMap.get(id));
        }
    }

    // Method to calculate the total price of selected products
    public float calculateTotalPrice(List<String> productIds) {
        float totalPrice = 0;
        for (String productId : productIds) {
            Product product = getProductById(productId);
            if (product != null) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }
}
