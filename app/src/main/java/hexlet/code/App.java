package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String textScanner;
        Scanner scanner = new Scanner(System.in);
        App.getStartListGames();
        textScanner = scanner.next();
        switch (textScanner) {
            case "0":
                break;
            case "1":
                Cli.greeting(scanner);
                break;
            case "2":
                Game.startGame(scanner, "even");
                break;
            case "3":
                Game.startGame(scanner, "calc");
                break;
            default:
                System.out.println("Выберите номер из списка");
        }
        scanner.close();
    }

    public static void getStartListGames() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }
}
