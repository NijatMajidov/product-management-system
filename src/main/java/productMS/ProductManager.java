package productMS;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ProductManager  {
    List<Product> products;

    public ProductManager(List<Product> products) {
        this.products = products;
    }

    public void sortProductsByPriceAscending(){
       products.sort(new Comparator<Product>() {
           @Override
           public int compare(Product o1, Product o2) {
               return Double.compare(o1.getPrice(), o2.getPrice());
           }
       });
        printAllProducts();
    }

    public void sortProductsByPriceDescending(){
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
        printAllProducts();
    }

    public void printInStockProducts(){
        Consumer<Product> consumer = product -> {
            if (product.isInStock()) {
                System.out.println(product);
            }
        };
        for (Product product : products){
            consumer.accept(product);
        }
    }

    public void filterAndPrintDeskProducts(){
        Predicate<Product> predicate = name-> name.getName().equals("Desk");
        for (Product product : products) {
            if (predicate.test(product)) {
                System.out.println(product);
            }
        }
    }

    public void getAndPrintCheapestProduct(){
         Supplier<Product> supplier = () -> {
             Product cheapest = products.get(0);
             for (Product product: products){
                 if (product.getPrice()< cheapest.getPrice()){
                     cheapest=product;
                 }
             }
             return cheapest;
         };
        System.out.println("Cheapest Product: " + supplier.get());
    }

    public void sortProductsByRatingDescending(){
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o2.getRating(), o1.getRating());
            }
        });
        printAllProducts();
    }

    public void printAllProducts(){
        Runnable runnable =()->{
            for (Product product : products){
                System.out.println(product);
            }
        };
        runnable.run();
    }




}

