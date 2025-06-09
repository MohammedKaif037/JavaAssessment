import java.util.Scanner;

public class MainOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FoodItem[] menu = {
                new FoodItem(1, "Burger", 6.99),
                new FoodItem(2, "Pizza", 9.99),
                new FoodItem(3, "Pasta", 7.99),
                new FoodItem(4, "Salad", 4.99)
        };
        Order order = new Order();
        while (true) {
            System.out.println("\n--- MENU ---");
            for (FoodItem item : menu) {
                item.display();
            }
            System.out.print("Enter item number to add to cart (0 to finish): ");
            int choice = scanner.nextInt();
            if (choice == 0)
                break;
            boolean found = false;
            for (FoodItem item : menu) {
                if (item.getId() == choice) {
                    order.addItem(item);
                    found = true;
                    break;
                }
            }
            if (!found)
                System.out.println("Invalid item number.");
        }
        scanner.nextLine(); // Consume leftover newline
        System.out.print("Any special instructions? ");
        String instructions = scanner.nextLine();
        order.setSpecialInstructions(instructions);
        order.displayOrder();
        scanner.close();
    }
}