package ecommerce;

import classes.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductsDatabase {

    /**
     * There's no database, we are giving 3 demo products to be loaded
     *
     * @return the list of all products inside a database.
     */
    public static List<Product> getAllProducts() {
        List<Product> product_list_database = new ArrayList();

        //Apple
        Product product = new Product();
        product.setId(1);
        product.setDescription("Apple");
        product.setAmount(0);
        product_list_database.add(product);

        //Tomato
        product = new Product();
        product.setId(2);
        product.setDescription("Tomato");
        product.setAmount(0);
        product_list_database.add(product);

        //Banana
        product = new Product();
        product.setId(3);
        product.setDescription("Banana");
        product.setAmount(0);
        product_list_database.add(product);

        return product_list_database;
    }

}
