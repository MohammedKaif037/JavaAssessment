class Employee {
    private String name;
    private double hourlyRate;
    private double weeklyHours;

    public Employee(String name, double hourlyRate, double weeklyHours) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.weeklyHours = weeklyHours;
    }

    public double calculateWeeklySalary() {
        double regularHours = Math.min(weeklyHours, 40);
        double overtimeHours = Math.max(weeklyHours - 40, 0);
        double regularPay = regularHours * hourlyRate;
        double overtimePay = overtimeHours * hourlyRate * 1.5;
        return regularPay + overtimePay;
    }

    public double calculateMonthlySalary() {
        double grossMonthly = calculateWeeklySalary() * 4; // 4 weeks in a month
        double tax = grossMonthly * 0.10;
        return grossMonthly - tax;
    }

    public void displaySalarySlip() {
        System.out.println("\n--- Salary Slip ---");
        System.out.println("Employee: " + name);
        System.out.println("Weekly Hours: " + weeklyHours);
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Monthly Salary (after 10% tax): $" +
                calculateMonthlySalary());
    }
}
