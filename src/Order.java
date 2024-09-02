// Sergio Prestegui
// Final Project
// 05/17/2024
import java.text.DateFormat;
import java.util.Date;

public class Order {
    private String customerName;
    private Sandwich sandwich;
    private String time;

    public Order(String customerName, Sandwich sandwich) {
        this.customerName = customerName;
        this.sandwich = sandwich;
        Date now = new Date();
        DateFormat defaultDate = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        this.time = defaultDate.format(now);
    }

    public String getCustomerName() {
        return customerName;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public String getTime() {
        return time;
    }
}
