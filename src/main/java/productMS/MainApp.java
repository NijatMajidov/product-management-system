package productMS;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Laptop", "Electronics", 1200, 4.5, true));
        productList.add(new Product("Smartphone", "Electronics", 800, 4.7, true));
        productList.add(new Product("T-Shirt", "Clothing", 20, 4.2, true));
        productList.add(new Product("Blender", "Appliances", 50, 3.8, false));
        productList.add(new Product("Desk", "Furniture", 150, 4.0, true));
        productList.add(new Product("Chair", "Furniture", 75, 3.9, true));

        ProductManager manager = new ProductManager(productList);

        System.out.println("Products sorted by price (ascending):");
        manager.sortProductsByPriceAscending();
        manager.sortProductsByPriceDescending();
        manager.printInStockProducts();


    }
}
