// Sergio Prestegui
// Final Project
// 05/17/2024
import java.util.Scanner;

// testing the gitpush
public class SandwichApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continueOrdering = true;
        boolean selectingVegetables = true;
        
        while (continueOrdering) {
            Sandwich sandwich = new Sandwich();

            System.out.println("=== Select Sandwich Bread: ===");
            System.out.println("1 White Bread $1.50");
            System.out.println("2 Wheat Bread $1.60");
            System.out.println("3 French Bread $1.80");
            System.out.println("4 Organic Bread $2.00");
            int breadChoice = getValidInput(scanner, 1, 4);
            switch (breadChoice) {
                case 1:
                    sandwich.setBread("White Bread", 1.5);
                    break;
                case 2:
                    sandwich.setBread("Wheat Bread", 1.6);
                    break;
                case 3:
                    sandwich.setBread("French Bread", 1.8);
                    break;
                case 4:
                    sandwich.setBread("Organic Bread", 2.0);
                    break;
            }

           
            while (selectingVegetables) {
                System.out.println("=== Select Sandwich Vegetables: ===");
                System.out.println("1 red onions $0.05");
                System.out.println("2 olives $0.10");
                System.out.println("3 pickles $0.10");
                System.out.println("4 lettuce $0.20");
                System.out.println("5 green peppers $0.25");
                System.out.println("6 tomatoes $0.30");
                System.out.println("7 cheese $0.50");
                System.out.println("8 Quit vegetable selection");
                int vegChoice = getValidInput(scanner, 1, 8);
                switch (vegChoice) {
                    case 1:
                        sandwich.addVegetable("red onions", 0.05);
                        break;
                    case 2:
                        sandwich.addVegetable("olives", 0.10);
                        break;
                    case 3:
                        sandwich.addVegetable("pickles", 0.10);
                        break;
                    case 4:
                        sandwich.addVegetable("lettuce", 0.20);
                        break;
                    case 5:
                        sandwich.addVegetable("green peppers", 0.25);
                        break;
                    case 6:
                        sandwich.addVegetable("tomatoes", 0.30);
                        break;
                    case 7:
                        sandwich.addVegetable("cheese", 0.50);
                        break;
                    case 8:
                        selectingVegetables = false;
                        break;
                }
            }

            System.out.println("=== Select Sandwich Meat: ===");
            System.out.println("1 Ham $1.00");
            System.out.println("2 Roasted Chicken Breast $1.10");
            System.out.println("3 Turkey Breast $1.20");
            System.out.println("4 Roast Beef $1.50");
            System.out.println("5 Quit meat selection");
            int meatChoice = getValidInput(scanner, 1, 5);
            switch (meatChoice) {
                case 1:
                    sandwich.setMeat("Ham", 1.0);
                    break;
                case 2:
                    sandwich.setMeat("Roasted Chicken Breast", 1.1);
                    break;
                case 3:
                    sandwich.setMeat("Turkey Breast", 1.2);
                    break;
                case 4:
                    sandwich.setMeat("Roast Beef", 1.5);
                    break;
                case 5:
                    break;
            }

            System.out.print("Enter customer's name: ");
            String customerName = scanner.nextLine();

            Order order = new Order(customerName, sandwich);

            SandwichIO.writeOrderToFile(order); //since writeOrder is static it can be called without creating object

            System.out.println(order.getTime() + "\t" + order.getCustomerName() + "\t" +
                               sandwich.getBread() + "\t" + sandwich.getVegetables() + "\t" +
                               sandwich.getMeat() + "\t" + String.format("$%.2f", sandwich.getPrice()));

            System.out.print("Continue to order more sandwich? (y/n): ");
            String continueResponse = scanner.nextLine().trim().toLowerCase();
            continueOrdering = continueResponse.equals("y");
        }
    }

    private static int getValidInput(Scanner scanner, int min, int max) {
        int choice = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print("Select an option [" + min + ", " + max + "]: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= min && choice <= max) {
                    valid = true;
                } else {
                    System.out.println("Error! Number must be between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
        }
        return choice;
    }
}
