package ecommerce;

import classes.Cart;
import java.util.concurrent.TimeUnit;

public class DeleteCartTask implements Runnable {

    int saved_new_cart_id = 0;

    //Parsing cart_id to the task that will remove the cart in 10 minutes after creation
    public DeleteCartTask(int new_cart_id) throws InterruptedException {
        saved_new_cart_id = new_cart_id;
    }

    public void run() {
        try {
            //First, we are linking thread id to cart
            long threadId = Thread.currentThread().getId();

            //Add new cart to cart_list variable
            Cart new_cart = new Cart();
            new_cart.setId(saved_new_cart_id);
            new_cart.setThread_id(threadId);
            Program.cart_list.add(new_cart);

            //Waiting 10 minutes before deleting
            TimeUnit.MINUTES.sleep(10);
            //Delete cart
            for (int i = 0; i < Program.cart_list.size(); i++) {
                if (Program.cart_list.get(i).getId() == saved_new_cart_id) {
                    //Then, let's delete the cart
                    Program.cart_list.remove(i);
                    return;
                }
            }

        } catch (InterruptedException ex) {
            //Logger.getLogger(DeleteCartTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
