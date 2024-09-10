// Sergio Prestegui
// Final Project
// 05/17/2024
public class Sandwich {
	private String bread;
    private String vegetables;
    private String meat;
    private double price;

    /**
    * This constructs a new Chemical
    * @param theCode The code number for the chemical
    * @param theName The name, or description, of the chemical
    * @param theCost The cost for one pound of the chemical
    */
    public Sandwich() {
        this.vegetables = "";
        this.price = 0.0;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread, double price) {
        this.bread = bread;
        this.price += price;
    }

    public String getVegetables() {
        return vegetables;
    }

    public void addVegetable(String vegetable, double price) {
        if (!this.vegetables.isEmpty()) {
            this.vegetables += ", ";
        }
        this.vegetables += vegetable;
        this.price += price;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat, double price) {
        this.meat = meat;
        this.price += price;
    }

    public double getPrice() {
        return price;
    }

}
