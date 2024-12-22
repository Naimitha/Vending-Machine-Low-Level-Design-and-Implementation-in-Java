import java.util.*;

// Main class for running the vending machine system
public class Solution {
    public static void main(String[] args) {
        // Initialize the stock manager and vending machine
        StockManager stockManager = new StockManager();
        VendingMachine vendingMachine = new SnacksVendingMachine(stockManager);
        Scanner scanner = new Scanner(System.in);

        // Main loop to interact with the vending machine
        while (true) {
            vendingMachine.displayProducts();  // Display available products

            List<String> cart = new ArrayList<>();
            System.out.print("Enter product IDs (comma-separated) or 'done' to finish: ");
            String input = scanner.nextLine().toUpperCase();

            // Exit loop if user types "done"
            if ("DONE".equals(input)) break;

            // Add selected products to the cart
            cart.addAll(Arrays.asList(input.split(",")));

            // Calculate the total price for the products
            float totalPrice = stockManager.calculateTotalPrice(cart);
            System.out.println("Total Price: $" + totalPrice);

            // Prompt for payment method
            System.out.print("Enter payment method (cash/coin/creditcard): ");
            String paymentMethod = scanner.nextLine().toLowerCase();
            Payment payment = null;

            // Handle different payment methods
            if ("cash".equals(paymentMethod)) {
                payment = new CashPayment();
            } else if ("coin".equals(paymentMethod)) {
                payment = new CoinPayment();
            } else if ("creditcard".equals(paymentMethod)) {
                System.out.print("Enter credit card number: ");
                String cardNumber = scanner.nextLine();
                payment = new CreditCardPayment(cardNumber);
            } else {
                System.out.println("Invalid payment method.");
                continue;
            }

            // Process the purchase
            if (vendingMachine.purchaseProducts(cart, payment)) {
                System.out.println("Purchase successful!");
            } else {
                System.out.println("Purchase failed. Try again.");
            }

            // Refill stock logic
            System.out.print("Do you want to refill stock? (yes/no): ");
            String refillChoice = scanner.nextLine().toLowerCase();
            if ("yes".equals(refillChoice)) {
                System.out.print("Enter product ID to refill: ");
                String refillId = scanner.nextLine().toUpperCase();
                System.out.print("Enter quantity to refill: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                vendingMachine.refillStock(refillId, quantity);
            }

            // Ask if the user wants to continue shopping
            System.out.print("Continue shopping? (yes/no): ");
            String continueChoice = scanner.nextLine().toLowerCase();
            if (!"yes".equals(continueChoice)) {
                break;  // Exit the loop if the user does not want to continue
            }
        }

        scanner.close();  // Close the scanner when done
    }
}
