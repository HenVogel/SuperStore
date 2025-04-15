// SuperStore Exercise: Access Modifiers & Object Modeling Focus

// TODO: Define a class called Product with:
// - A protected String field called name
// - A protected double field called price
// - A private final int productId
// - A public static int nextId to help generate unique IDs
// - A constructor that sets name, price, and assigns a unique ID
// - Public getters for all fields
// - Override toString() to return formatted product details
// - Override equals(Object o) to compare name and productId

class Product {
    protected String name;
    protected double price;
    private final int productId;
    public static int nextId = 1;

    // Sets the variables name, price, and productId
    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
        this.productId = nextId++;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "Product: " + this.name + " Price: " + this.price + " ID: " + this.productId;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Product other) {
            return this.name.equals(other.name) && this.productId == other.productId;
        }
        return false;
    }
}

// TODO: Define a subclass Electronics that extends Product
// - Add a private String field called brand
// - Add a private boolean field called hasBattery
// - Constructor takes all fields and uses super for shared ones
// - Override toString() to include brand and battery status

class Electronics extends Product {
    private final String brand;
    private final boolean hasBattery;

    // Sets the variables name, price, brand, and hasBattery
    public Electronics(String name, double price, String brand, boolean hasBattery) {
        super(name, price);
        this.brand = brand;
        this.hasBattery = hasBattery;
    }

    @Override
    public String toString() {
        return super.toString() + ", Brand=" + brand + ", Battery=" + (hasBattery ? "Yes" : "No");
    }

    // Warranty Info
    public final String warrantyInfo() {
        return "1000000 Yeah Warranty";
    }
}

// TODO: Define a subclass Grocery that extends Product
// - Add a private double field called weight (in kg)
// - Add a private boolean field called isPerishable
// - Constructor takes all fields and uses super for shared ones
// - Override toString() to include weight and perishability

class Grocery extends Product {
    private final Double weight;
    private final boolean isPerishable;

    // Sets the variables name, price, weight, and isPerishable
    public Grocery(String name, double price, double weight, boolean isPerishable) {
        super(name, price);
        this.weight = weight;
        this.isPerishable = isPerishable;
    }

    @Override
    public String toString() {
        return super.toString() + ", Weight=" + weight + ", isPerishable=" + (isPerishable ? "Yes" : "No");
    }
}

// TODO: Define a final class Toy that extends Product
// - Add a private int field called minAge
// - Constructor takes all fields and uses super for shared ones
// - Override toString() to include minAge

final class Toy extends Product {
    private final int minAge;

    // Sets the variables name, price, and minAge
    public Toy(String name, double price, int minAge) {
        super(name, price);
        this.minAge = minAge;
    }

    @Override
    public String toString() {
        return super.toString() + "MinAge: " + minAge;
    }
}

// TODO: Coupon Class
class Coupon {
    private final double discountRate;

    public Coupon(double discountRate) {
        this.discountRate = discountRate;
    }

    // Create final discountRate and apply it to a Product
    public double apply(Product p) {
        return p.getPrice() * (discountRate); 
    }
}

// TODO: Define class SuperStoreTest with a main method
// - Create at least one instance of each subclass
// - Store them in a Product[] array
// - Loop through and print each item
// - Call equals() to compare two products with the same ID and name

public class SuperStoreTest {
    public static void main(String[] args) {
        // One instance of each of the subclasses
        Product p1 = new Electronics("Phone", 99999.99, "Tech", true);
        Product p2 = new Electronics("Computer", 99999.99, "Tech", true);
        Product p3 = new Grocery("Pizza", 9.99, 4.5, true);
        Product p4 = new Toy("Football", 12.00, 5);
        Product[] imventory = {p1, p2, p3, p4};

        // Loops and prints each item
        for (Product p : imventory) {
            System.out.println(p.toString());
        }

        // Compares p1 and p2
        System.out.println("Comparing Product");
        System.out.println("p1 = p2 " + p1.equals(p2));

        // Gives pizza a discount
        Coupon coupon = new Coupon(0.50);
        System.out.println("Discounted Price: $" + coupon.apply(p3));

        // Final method thing
        if (p1 instanceof Electronics electronics) {
            System.out.println(electronics.warrantyInfo());
        }
    }
}

// Additional TODOs:
// 1. Try to extend Toy — what happens and why?
//    When I tried to extend Toy I got the error that cannot find the subclass Toy        <---    <---    <---

// 2. Make a class Coupon with a final discountRate and apply it to a Product
// 3. Add a method to Electronics called warrantyInfo() and mark it final
// 4. Use access modifiers appropriately and explain your choices in comments
