package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Utils.getRandomNumber;

public class Prime {
    private static final String TASK_OF_GAME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static void startPrimeGame() {
        String[][] statements = new String[Engine.COUNT_TRY_TO_FINISH][Engine.MAX_ARRAY_SIZE];
        for (var i = 0; i < Engine.COUNT_TRY_TO_FINISH; i++) {
            var questionStatement = Integer.toString(getRandomNumber());
            var correctAnswer = getCorrectAnswerText(questionStatement) ? "yes" : "no";

            statements[i][0] = questionStatement;
            statements[i][1] = correctAnswer;
        }
        Engine.startGame(TASK_OF_GAME, statements);
    }
    private static boolean getCorrectAnswerText(String statement) {
        int number = Integer.parseInt(statement);
        for (var i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
