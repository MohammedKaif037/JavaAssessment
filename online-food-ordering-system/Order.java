import java.util.ArrayList;
import java.util.List;

class Order {
    private List<FoodItem> cart;
    private String specialInstructions;
    private final double TAX_RATE = 0.10;
    private final double DELIVERY_CHARGE = 5.0;

    public Order() {
        cart = new ArrayList<>();
    }

    public void addItem(FoodItem item) {
        cart.add(item);
        System.out.println(item.getName() + " added to cart.");
    }

    public void setSpecialInstructions(String instructions) {
        this.specialInstructions = instructions;
    }

    public double calculateTotal() {
        double subtotal = 0;
        for (FoodItem item : cart) {
            subtotal += item.getPrice();
        }
        double tax = subtotal * TAX_RATE;
        return subtotal + tax + DELIVERY_CHARGE;
    }

    public void displayOrder() {
        System.out.println("\n--- Your Order ---");
        for (FoodItem item : cart) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Special Instructions: " + (specialInstructions == null
                ? "None"
                : specialInstructions));
        System.out.println("Total (incl. tax + delivery): $" + calculateTotal());
    }
}