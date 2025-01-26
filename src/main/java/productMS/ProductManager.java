package productMS;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

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
    }

    public void sortProductsByPriceDescending(){
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
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




}

