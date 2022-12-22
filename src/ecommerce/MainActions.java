package ecommerce;

import java.util.concurrent.TimeUnit;

public class MainActions {

    //ConsoleActions variables
    //Welcome message
    static String fancy_line = "****************************************";
    static String fancy_space = "*                                      *";
    static String fancy_message = "*     Welcome to ONEBOX E-Commerce     *";
    static String fancy_message_space = "                                       *";

    /**
     * Displays the loading animation fancy message
     */
    public static void printFancyMessageAnimation() throws InterruptedException {
        //Loop through all "fancy_message" characters printing an animated fancy message
        for (int i = 0; i < 41; i++) {
            //Clear console
            ConsoleActions.clearConsole();

            //Display fancy message
            System.out.println(fancy_line);
            System.out.println(fancy_space);
            System.out.println(fancy_message.substring(0, i) + fancy_message_space.substring(i, fancy_message_space.length()));
            System.out.println(fancy_space);
            System.out.println(fancy_line);

            //Set delay between characters
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }

    /**
     * Displays the fancy message without any animation
     */
    public static void printFancyMessage() {
        //Clear console
        ConsoleActions.clearConsole();

        //Display fancy message
        System.out.println(fancy_line);
        System.out.println(fancy_space);
        System.out.println(fancy_message);
        System.out.println(fancy_space);
        System.out.println(fancy_line);
    }

    /**
     * Displays information about the main program functionality
     */
    public static void printInformation() {
        System.out.println("");
        System.out.println("");
        System.out.println("Select your desired option: ");
        System.out.println(" 1- Create new cart");
        System.out.println(" 2- Get cart information");
        System.out.println(" 3- Add products to a cart");
        System.out.println(" 4- Delete cart");
        System.out.println(" 5- Stop E-Commerce program");
        System.out.println("");
        System.out.println("Write your option number and then press Enter to continue: ");
    }
}
