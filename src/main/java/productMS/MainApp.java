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

        System.out.println("\nAll products:");
        manager.printAllProducts();

        System.out.println("\nProducts sorted by price (ascending):");
        manager.sortProductsByPriceAscending();

        System.out.println("\nProducts sorted by price (descending):");
        manager.sortProductsByPriceDescending();

        System.out.println("\nIn-stock products:");
        manager.printInStockProducts();

        System.out.println("\nProducts with 'Desk' in the name:");
        manager.filterAndPrintDeskProducts();

        System.out.println("\nCheapest product:");
        manager.getAndPrintCheapestProduct();

        System.out.println("\nProducts sorted by rating (descending):");
        manager.sortProductsByRatingDescending();
    }
}