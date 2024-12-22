# Vending-Machine-Low-Level-Design-and-Implementation-in-Java
A Java-based vending machine system that allows users to view products, make purchases with various payment methods, and manage stock automatically.

## Overview

The Vending Machine System simulates the functionality of a real-world vending machine. This system allows users to view available products, purchase items, and manage inventory through a modular and object-oriented approach. It consists of several key components such as Product, Payment, StockManager, VendingMachine, and more, making it easy to maintain.

The system supports various payment methods (cash, coin, and credit card) and offers automatic stock management by replenishing items when stock levels fall below a predefined threshold.

## Key Features

- *Modular Design*: The system is built using object-oriented principles, ensuring extensibility and ease of maintenance.
- *Multiple Payment Methods*: Supports cash, coin, and credit card payments.
- *Automatic Stock Management*: Items are automatically restocked when inventory reaches a certain threshold.
- *User-Friendly Interaction*: The system allows users to interact easily, view products, purchase them, and refill stock when needed.

## Class Descriptions

### 1. Interface: Product
The Product interface represents the basic functionality of products available in the vending machine.

#### Methods:
- String getName(): Returns the name of the product.
- float getPrice(): Returns the price of the product.

### 2. Class: ConcreteProduct
ConcreteProduct is the actual implementation of the Product interface, holding details about a product's name and price.

#### Attributes:
- name: Name of the product (String).
- price: Price of the product (float).

#### Constructor:
- ConcreteProduct(String name, float price): Initializes a product with its name and price.

#### Methods:
- String getName(): Returns the name of the product.
- float getPrice(): Returns the price of the product.

### 3. Interface: Payment
The Payment interface represents different types of payment methods.

#### Method:
- boolean makePayment(float amount): Processes the payment and returns true if successful, otherwise false.

### 4. Payment Implementations
The following classes implement the Payment interface, each representing a different payment method.

#### a. Class: CashPayment
CashPayment processes payments made with cash.

##### Methods:
- boolean makePayment(float amount): Prints a message for cash payment and returns true.

#### b. Class: CoinPayment
CoinPayment handles payments made with coins.

##### Methods:
- boolean makePayment(float amount): Prints a message for coin payment and returns true.

#### c. Class: CreditCardPayment
CreditCardPayment processes payments made via credit cards.

##### Attributes:
- cardNumber: Card number (String).

##### Constructor:
- CreditCardPayment(String cardNumber): Initializes the payment method with a credit card number.

##### Methods:
- boolean makePayment(float amount): Prints a message for credit card payment and returns true.

### 5. Class: StockManager
The StockManager class manages the inventory and product availability in the vending machine.

#### Attributes:
- productMap: A map storing product IDs and their corresponding Product objects.
- inventoryMap: A map storing product IDs and their stock quantities.
- REORDER_THRESHOLD: A constant value that defines the stock threshold below which a product should be restocked.
- REFILL_QUANTITY: A constant value defining how many units of a product should be added during a restock.

#### Methods:
- void displayProducts(): Displays all available products with their prices and stock levels.
- boolean isProductAvailable(String productId): Checks if a product is in stock.
- Product getProductById(String productId): Retrieves a product by its ID.
- void decreaseStock(String productId): Decreases the stock of a product, triggering a refill if necessary.
- void refillStock(String productId, int quantity): Refills the stock of a product.
- float calculateTotalPrice(List<String> productIds): Calculates the total price for a list of products based on their IDs.

### 6. Interface: VendingMachine
The VendingMachine interface provides methods for interacting with the vending machine, such as displaying products and making purchases.

#### Methods:
- void displayProducts(): Displays the available products.
- boolean purchaseProducts(List<String> productIds, Payment payment): Facilitates the purchase process, validating stock, calculating total price, and updating inventory.
- void refillStock(String id, int quantity): Refills stock for a given product ID.

### 7. Class: SnacksVendingMachine
SnacksVendingMachine is a concrete implementation of the VendingMachine interface, providing the actual functionality for vending snacks.

#### Attributes:
- stockManager: An instance of StockManager to manage the inventory.

#### Methods:
- void displayProducts(): Delegates to the StockManager to display products.
- boolean purchaseProducts(List<String> productIds, Payment payment): Processes a purchase by validating stock, calculating the total price, and updating inventory.
- void refillStock(String id, int quantity): Refills stock using the StockManager.

### 8. Class: Solution (Main Application)
The Solution class is the entry point for the vending machine application. It orchestrates the interaction between the user and the vending machine.

#### Flow:
1. Initializes a StockManager with predefined products and stock levels.
2. Creates a SnacksVendingMachine instance with the StockManager.
3. Displays a menu for user interaction, allowing users to:
   - View available products.
   - Add items to a purchase list.
   - Choose a payment method.
   - Make purchases.
   - Refill stock if necessary.

#### Methods:
- public static void main(String[] args): Handles the user interactions and the flow of the vending machine system.

## Logic and Interaction Flow

### Initialization:
- The application initializes a StockManager with predefined products and stock levels, and a SnacksVendingMachine that uses this manager to handle inventory.

### User Interaction:
- Users can view products, select items, make payments, and optionally refill stock if products are low in stock.

### Inventory Management:
- Products are restocked automatically when their stock levels fall below the reorder threshold, ensuring that the vending machine never runs out of items.

### Payment Processing:
- The system supports multiple payment methods including CashPayment, CoinPayment, and CreditCardPayment, giving users flexibility in how they pay.

## How to Use

1. *Running the Application*:
   - Upon running the application, users are prompted with options to view products, add them to their cart, select a payment method, and finalize the purchase.
   
2. *Making a Payment*:
   - Users can choose from cash, coin, or credit card as their payment method. The appropriate Payment implementation will be used to process the transaction.

3. *Restocking Products*:
   - When products are low in stock, the system will automatically reorder the items based on the predefined thresholds.
