package ecommerce;

public class ConsoleActions {

    /**
     * Clear the console for next print
     */
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Waits for a user Enter input before continue the program execution
     */
    public static void EnterToContinueAction() {
        try {
            System.console().readLine();
        } catch (Exception e) {
        }
    }

}
