package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int COUNT_TRY_TO_FINISH = 3;
    public static final int MAX_ARRAY_SIZE = 2;
    public static void startGame(String taskOfGame, String[][] statements) {
        Scanner scanner = new Scanner(System.in);
        var userName = Cli.greeting(scanner);
        System.out.println(taskOfGame);

        var indexUserTry = 0;
        boolean userAnswerIsTrue;
        do {
            String questionStatement = statements[indexUserTry][0];
            String correctAnswerText = statements[indexUserTry][1];

            System.out.println("Question: " + questionStatement);
            System.out.print("Your answer: ");
            var userAnswer = scanner.next();
            userAnswerIsTrue = (userAnswer.equalsIgnoreCase(correctAnswerText));
            if (userAnswerIsTrue) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswerText + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
            indexUserTry++;
        } while (indexUserTry < Engine.COUNT_TRY_TO_FINISH);
        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }
}
