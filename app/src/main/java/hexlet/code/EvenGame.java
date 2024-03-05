package hexlet.code;

import java.util.Scanner;

public class EvenGame {
    public static void startEvenGame(Scanner scanner) {
        var userName = Cli.greeting(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        String userAnswer;
        String correctEvenText;
        var indexUserTry = 0;
        boolean userAnswerIsTrue;
        var countTryToFinish = 3;
        do {
            indexUserTry++;
            var questionNumber = getRandomNumber();
            System.out.println("Question: " + questionNumber);
            System.out.print("Your answer: ");
            userAnswer = scanner.next();
            correctEvenText = (questionNumber % 2 == 0) ? "yes" : "no";
            userAnswerIsTrue = (userAnswer.equalsIgnoreCase(correctEvenText));
            if (userAnswerIsTrue) {
                System.out.println("Correct!");
                if (indexUserTry == countTryToFinish) {
                    System.out.println("Congratulations, " + userName + "!");
                }
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                                    + correctEvenText + "'.");
                System.out.println("Let's try again, " + userName + "!");
            }
        } while (userAnswerIsTrue && (indexUserTry < countTryToFinish));
    }

    public static int getRandomNumber() {
        int number = (int) (Math.random() * 100);
        while (number == 0) {
            number = (int) (Math.random() * 100);
        }
        return number;
    }
}
