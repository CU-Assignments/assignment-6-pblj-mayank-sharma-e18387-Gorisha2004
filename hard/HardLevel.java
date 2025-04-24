import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}

public class HardLevel {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200),
            new Product("Phone", "Electronics", 800),
            new Product("Shoes", "Footwear", 50),
            new Product("Shirt", "Clothing", 25),
            new Product("Washing Machine", "Home Appliances", 400)
        );

        // Group products by category
        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Products grouped by category: " + groupedByCategory);

        // Find the most expensive product in each category
        Map<String, Product> mostExpensiveProduct = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)), Optional::get)));

        System.out.println("Most expensive product in each category: " + mostExpensiveProduct);

        // Calculate the average price of all products
        double averagePrice = products.stream()
            .mapToDouble(Product::getPrice)
            .average()
            .orElse(0.0);

        System.out.println("Average price of products: " + averagePrice);
    }
}
