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
            var expression = Engine.getExpression(gameName);
            System.out.println("Question: " + expression);
            System.out.print("Your answer: ");
            var userAnswer = scanner.next();
            var correctAnswerText = Engine.getCorrectAnswerText(gameName, expression);
            userAnswerIsTrue = (userAnswer.equalsIgnoreCase(correctAnswerText));
            if (userAnswerIsTrue) {
                System.out.println("Correct!");
                if (indexUserTry == Engine.countTryToFinish) {
                    System.out.println("Congratulations, " + userName + "!");
                }
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                                    + correctAnswerText + "'.");
                System.out.println("Let's try again, " + userName + "!");
            }
        } while (userAnswerIsTrue && (indexUserTry < Engine.countTryToFinish));
    }


}
