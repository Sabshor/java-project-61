package hexlet.code;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("0 - Exit");
        System.out.println("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        int indexGame = scanner.nextInt();
        switch (indexGame) {
            case 0:
                //System.exit(0);
                break;
            case 1:
                System.out.println("Welcome to the Brain Games!");
                Cli.greeting(scanner);
                break;
            default:
                System.out.println("Введено некорректное число");
        }
        scanner.close();
    }
}
