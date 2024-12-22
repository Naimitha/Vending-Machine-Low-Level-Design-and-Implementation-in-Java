// Concrete implementation of the Product interface
public class ConcreteProduct implements Product {
    private String name;
    private float price;

    // Constructor to initialize the product with a name and price
    public ConcreteProduct(String name, float price) {
        this.name = name;
        this.price = price;
    }

    // Method to return the product name
    @Override
    public String getName() {
        return name;
    }

    // Method to return the product price
    @Override
    public float getPrice() {
        return price;
    }
}
