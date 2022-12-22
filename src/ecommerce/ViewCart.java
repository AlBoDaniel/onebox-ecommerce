package ecommerce;

public class ViewCart {

    /**
     * "Main" function on "Get cart information" option selected
     */
    public static void viewCart() {
        //First we need to ask for the cart id
        //Clearing the console
        ConsoleActions.clearConsole();

        //Set text header for the user
        System.out.println("[1- Create new cart]");
        System.out.println("");
        System.out.println("Please, input the cart id: ");

        //Read the next line prompt by user
        String input_cart_id_text = System.console().readLine();
        //Attempt to parse to int
        int input_cart_id_number = 0;
        try {
            //Parse input text to int
            input_cart_id_number = Integer.parseInt(input_cart_id_text);
        } catch (Exception e) {
            System.out.println("The prompted information is not a valid integer. Adding products to a cart aborted...");
            return;
        }

        //Check for the cart id if exists
        for (int i = 0; i < Program.cart_list.size(); i++) {
            if (Program.cart_list.get(i).getId() == input_cart_id_number) {
                //Cart ID found, displaying cart id and product list
                System.out.println("Cart id: " + input_cart_id_number);
                System.out.println("Product list: ");
                for (int j = 0; j < Program.cart_list.get(i).getProduct_list().size(); j++) {
                    System.out.println(" " + Program.cart_list.get(i).getProduct_list().get(j).getDescription() + " --> " + Program.cart_list.get(i).getProduct_list().get(j).getAmount() + " units");
                }
                //Filter for empty list
                if (Program.cart_list.get(i).getProduct_list().size() == 0) {
                    System.out.println("This cart product list is empty.");
                }
                System.out.println("All information about cart id " + input_cart_id_number + " has been displayed.");
                return;
            }
        }

        //Cart ID doesn't match to any cart
        System.out.println("Prompted cart id doesn't exists. Remember, any cart will be deleted in 10 minutes before it's creation.");
        return;
    }

}
