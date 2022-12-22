package ecommerce;

public class CreateCart {

    /**
     * "Main" function on "Create Cart" option selected
     */
    public static void createCart() {
        //Clearing the console
        ConsoleActions.clearConsole();

        //Set text header for the user
        System.out.println("[1- Create new cart]");
        System.out.println("");
        System.out.println("You are going to create a new cart, please introduce an integer ID: ");

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
                    System.out.println("The prompted cart id already exists. New cart creation aborted.");
                    return;
                }
            }

            //We are creating cart in a thread, because at time we create that cart, it will be deleted past 10 minutes from now, assigning thread_id to cart, in order to identify the thread
            Runnable r = new DeleteCartTask(cart_id_number);
            new Thread(r).start();

            //Cart created
            System.out.println("A new cart has been created. Cart id is: " + cart_id_number);

        } catch (Exception e) {
            System.out.println("The prompted information is not a valid integer. New cart creation aborted.");
        }
    }
}
