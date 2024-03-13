package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.getRandomNumber;

public class GCD {
    public static final String TASK_OF_GAME = "Find the greatest common divisor of given numbers.";
    public static void startGCDGame() {
        String[][] statements = new String[Engine.COUNT_TRY_TO_FINISH][Engine.MAX_ARRAY_SIZE];
        for (var i = 0; i < Engine.COUNT_TRY_TO_FINISH; i++) {
            var questionStatement = getQuestionStatement();
            var correctAnswer = getCorrectAnswerText(questionStatement);
            statements[i][0] = questionStatement;
            statements[i][1] = correctAnswer;
        }
        Engine.startGame(TASK_OF_GAME, statements);
    }
    private static String getQuestionStatement() {
        return getRandomNumber() + " " + getRandomNumber();
    }
    private static String getCorrectAnswerText(String statement) {
        String[] numbers = statement.split(" ");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        return Integer.toString(getGCD(a, b));

    }
    private static int getGCD(int a, int b) {
        if (a == 0) {
            return b;
        }
        while (b != 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}
