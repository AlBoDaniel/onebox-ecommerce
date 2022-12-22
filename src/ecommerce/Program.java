package ecommerce;

import classes.Cart;
import static ecommerce.MainActions.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static List<Cart> cart_list = new ArrayList();

    //ONEBOX E-Commerce program starts here
    public static void main(String[] args) throws InterruptedException, IOException {

        //Displays the load animation (fancy message)
        printFancyMessageAnimation();

        //Do while loop program execution
        do {
            //Display program options (HUD)
            printInformation();

            //Read the next line prompt by user
            String input_text = System.console().readLine();

            //Attempt to parse to int
            int input_number = 0;
            try {
                //Parse input text to int
                input_number = Integer.parseInt(input_text);

                /*
                It's a valid number, let's check if its a number of a real option:
                 1- Create new cart
                 2- Get cart information
                 3- Add products to a cart
                 4- Delete cart
                 5- Stop E-Commerce program
                 */
                switch (input_number) {
                    case 1:
                        //Creating new cart and obtaining ID
                        CreateCart.createCart();

                        break;
                    case 2:
                        //Get cart information
                        ViewCart.viewCart();

                        break;
                    case 3:
                        //Opening update cart menu
                        UpdateCart.updateCartProductList();

                        break;
                    case 4:
                        //Delete cart
                        DeleteCart.deleteCart();
                        break;
                    case 5:
                        //Stop E-Commerce program
                        System.exit(0);
                        break;
                    default:
                        System.out.println("The option prompted does not exist.");
                }
                //Returning main menu
                System.out.println("Returning to main menu, press Enter in order to be able selecting an option again...");
                ConsoleActions.EnterToContinueAction();
                //Clear the console and display fancy message
                printFancyMessage();

            } catch (Exception e) {
                System.out.println("The option prompted does not exist.");
                //Returning main menu
                System.out.println("Returning to main menu, press Enter in order to be able selecting an option again...");
                ConsoleActions.EnterToContinueAction();
                //Clear the console and display fancy message
                printFancyMessage();
            }
        } while (true);

    }

}
