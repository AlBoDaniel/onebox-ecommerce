package ecommerce;

import java.util.Set;

public class DeleteCart {

    /**
     * "Main" function on "Delete cart" option selected
     */
    public static void deleteCart() {
        //Clearing the console
        ConsoleActions.clearConsole();

        //Set text header for the user
        System.out.println("[4- Delete cart]");
        System.out.println("");
        System.out.println("You are going to delete existing cart, please introduce cart ID to be removed: ");

        //Read the next line prompt by user
        String cart_id_text = System.console().readLine();
        //Attempt to parse to int
        int cart_id_number = 0;
        try {
            //Parse input text to int
            cart_id_number = Integer.parseInt(cart_id_text);
        } catch (Exception e) {
            System.out.println("The prompted information is not a valid integer. Deleting cart aborted...");
        }

        //Check if the cart exists
        for (int i = 0; i < Program.cart_list.size(); i++) {
            if (Program.cart_list.get(i).getId() == cart_id_number) {
                //Cart exists, proceed to delete
                //First, we are terminating auto delete thread for the current cart
                Set<Thread> setOfThread = Thread.getAllStackTraces().keySet();
                for (Thread thread : setOfThread) {
                    if (thread.getId() == Program.cart_list.get(i).getThread_id()) {
                        thread.interrupt();
                    }
                }
                //Then, let's delete the cart
                Program.cart_list.remove(i);
                System.out.println("The cart id " + cart_id_number + " has been successfully deleted.");
                return;
            }
        }

        //Unable to find the desired cart
        System.out.println("The prompted cart id doesn't exists. Remember, any cart will be deleted in 10 minutes before it's creation.");
    }

}
