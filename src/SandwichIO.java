// Sergio Prestegui
// Final Project
// 05/17/2024
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SandwichIO {
    public static void writeOrderToFile(Order order) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("order.txt", true))) {
            writer.print(order.getTime());
            writer.print("\t");
            writer.print(order.getCustomerName());
            writer.print("\t");
            writer.print(order.getSandwich().getBread());
            writer.print("\t");
            writer.print(order.getSandwich().getVegetables());
            writer.print("\t");
            writer.print(order.getSandwich().getMeat());
            writer.print("\t");
            writer.printf("$%.2f", order.getSandwich().getPrice());
            writer.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

