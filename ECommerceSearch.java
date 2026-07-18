import java.util.*;

class Product {
    int id;
    String name;
    double price;
    String category;

    Product(int id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String toString() {
        return id + ". " + name + " - Rs." + price + " (" + category + ")";
    }
}

public class ECommerceSearch {

    static List<Product> products = new ArrayList<>();

    static void loadProducts() {
        products.add(new Product(1, "Wireless Mouse", 599, "Electronics"));
        products.add(new Product(2, "Bluetooth Headphones", 1499, "Electronics"));
        products.add(new Product(3, "Running Shoes", 2499, "Footwear"));
        products.add(new Product(4, "Cotton T-Shirt", 399, "Clothing"));
        products.add(new Product(5, "Leather Wallet", 899, "Accessories"));
        products.add(new Product(6, "Smart Watch", 3999, "Electronics"));
        products.add(new Product(7, "Yoga Mat", 699, "Fitness"));
        products.add(new Product(8, "Laptop Bag", 1299, "Accessories"));
    }

    static List<Product> search(String query) {
        List<Product> result = new ArrayList<>();
        String lower = query.toLowerCase();
        for (Product p : products) {
            if (p.name.toLowerCase().contains(lower) || p.category.toLowerCase().contains(lower)) {
                result.add(p);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        loadProducts();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter search query: ");
        String query = sc.nextLine();

        List<Product> results = search(query);
        if (results.isEmpty()) {
            System.out.println("No products found");
        } else {
            for (Product p : results) {
                System.out.println(p);
            }
        }
        sc.close();
    }
}