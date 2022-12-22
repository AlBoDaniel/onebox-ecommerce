package classes;

public class Product {

    //Product variables
    private int id;
    private String description;
    private int amount;

    //Cart constructors
    public Product() {
        this.id = 0;
        this.description = "";
        this.amount = 0;
    }

    public Product(int id, String description, int amount) {
        this.id = id;
        this.description = description;
        this.amount = amount;
    }

    //Cart functions (get/set)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
