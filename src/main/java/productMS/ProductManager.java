package productMS;

import java.util.Comparator;
import java.util.List;

public class ProductManager implements Comparator<Product> {
    List<Product> products;

    public ProductManager(List<Product> products) {
        this.products = products;
    }

    public static void sortProductsByPriceAscending(){

    }

    @Override
    public int compare(Product o1, Product o2) {
        return 0;
    }
}

