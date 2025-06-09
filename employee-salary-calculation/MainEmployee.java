import java.util.Scanner;

public class MainEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 1; i <= numEmployees; i++) {
            System.out.println("\nEnter details for Employee #" + i);
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Hourly Rate: ");
            double hourlyRate = scanner.nextDouble();

            System.out.print("Weekly Hours: ");
            double weeklyHours = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            Employee emp = new Employee(name, hourlyRate, weeklyHours);
            emp.displaySalarySlip();
        }

        scanner.close();
    }
}