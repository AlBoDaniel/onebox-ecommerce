package ecommerce;

import classes.Product;
import java.util.List;

public class UpdateCart {

    /**
     * "Main" function on "Add products to a cart" option selected
     */
    public static void updateCartProductList() {
        //Clearing the console
        ConsoleActions.clearConsole();

        //Set text header for the user
        System.out.println("[3- Add products to a cart]");
        System.out.println("");
        System.out.println("You are going to add products to existing cart, please introduce cart ID: ");

        //Read the next line prompt by user
        String cart_id_text = System.console().readLine();
        //Attempt to parse to int
        int cart_id_number = 0;
        try {
            //Parse input text to int
            cart_id_number = Integer.parseInt(cart_id_text);

            //It's a valid number, let's check if this new cart id already exist
            for (int i = 0; i < Program.cart_list.size(); i++) {
                if (Program.cart_list.get(i).getId() == cart_id_number) {

                    //The cart already exists, proceeding to add items to cart menu
                    updateCartById(cart_id_number);
                    return;

                }
            }

            //Cart ID doesn't exists, display error and return main menu
            System.out.println("The prompted cart id doesn't exists or has been deleted. Adding products to a cart aborted...");

        } catch (Exception e) {
            System.out.println("The prompted information is not a valid integer. Adding products to a cart aborted...");
        }
    }

    /**
     * Displays the add items menu to specific cart given by cart id
     *
     * @param cart_id_number Identifies the id of the cart which we are adding new items
     */
    private static void updateCartById(int cart_id_number) {
        //Clearing the console
        ConsoleActions.clearConsole();

        //Set text header for the user
        System.out.println("[3- Add products to a cart]");
        System.out.println("");
        System.out.println("Adding items to cart id " + cart_id_number + ". Select an option below:");
        System.out.println(" 0- Return main menu");
        //Displaying all products
        List<Product> product_list_database = ProductsDatabase.getAllProducts();
        for (int i = 0; i < product_list_database.size(); i++) {
            System.out.println(" " + product_list_database.get(i).getId() + "- " + product_list_database.get(i).getDescription());
        }
        System.out.println("");
        System.out.println("Write your option number and then press Enter to continue: ");

        //Read the next line prompt by user
        String product_id_text = System.console().readLine();

        //Attempt to parse to int
        int product_id_number = 0;
        try {
            //Parse input text to int
            product_id_number = Integer.parseInt(product_id_text);
        } catch (Exception e) {
            System.out.println("The prompted information is not a valid integer. Adding products to a cart aborted.");
            return;
        }

        //Check if the product id selected, exists on the list. 0 is the return to menu option
        if (product_id_number == 0) {
            return;
        }
        for (int i = 0; i < product_list_database.size(); i++) {
            if (product_list_database.get(i).getId() == product_id_number) {
                System.out.println("You are going to add \"" + product_list_database.get(i).getDescription() + "\". Please write desired amount:");
                //We are asking now for the amount of the selected product
                //Read the next line prompt by user
                String amount_text = System.console().readLine();
                //Attempt to parse to int
                int amount_value = 0;
                try {
                    //Parse input text to int
                    amount_value = Integer.parseInt(amount_text);
                } catch (Exception e) {
                    System.out.println("The prompted information is not a valid integer. Adding products to a cart aborted.");
                    return;
                }

                //Check if the amount is bigger than 0
                if (amount_value <= 0) {
                    System.out.println("The amount can't be zero or negative. Adding products to a cart aborted.");
                    return;
                }

                //Note, here we can identify all products in our cart and only allow to be 1 product type per cart, but we are omitting this possibility because that's only a demo
                //Adding the product to the cart
                Product product = new Product();
                product.setId(product_id_number);
                product.setDescription(product_list_database.get(i).getDescription());
                product.setAmount(amount_value);
                //Still existing cart?
                for (int j = 0; j < Program.cart_list.size(); j++) {
                    if (Program.cart_list.get(j).getId() == cart_id_number) {
                        //Cart still existing, adding
                        Program.cart_list.get(j).getProduct_list().add(product);

                        //Product added, return to main menu
                        System.out.println("Product added successfuly to cart id " + cart_id_number + ".");
                        return;
                    }
                }
                //Cart doesn't exists or has been deleted
                System.out.println("The cart " + cart_id_number + " doesn't exists. Remember, any cart will be deleted in 10 minutes before it's creation.");
                return;
            }
        }
        //The product id prompted doesn't exists
        System.out.println("The prompted product doesn't exists. Adding products to a cart aborted.");

    }
}
