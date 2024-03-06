package hexlet.code;

import java.util.Scanner;

public class Game {
    public static void startGame(Scanner scanner, String gameName) {
        var userName = Cli.greeting(scanner);
        System.out.println(Engine.getTaskGame(gameName));

        var indexUserTry = 0;
        boolean userAnswerIsTrue;
        do {
            indexUserTry++;
            var statement = Engine.getStatement(gameName);
            System.out.println("Question: " + statement);
            System.out.print("Your answer: ");
            var userAnswer = scanner.next();
            var correctAnswer = Engine.getCorrectAnswerText(gameName, statement);
            userAnswerIsTrue = (userAnswer.equalsIgnoreCase(correctAnswer));
            if (userAnswerIsTrue) {
                System.out.println("Correct!");
                if (indexUserTry == Engine.COUNT_TRY_TO_FINISH) {
                    System.out.println("Congratulations, " + userName + "!");
                }
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                                    + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
            }
        } while (userAnswerIsTrue && (indexUserTry < Engine.COUNT_TRY_TO_FINISH));
    }


}
