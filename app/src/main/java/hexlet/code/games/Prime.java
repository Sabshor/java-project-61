package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Utils.getRandomNumber;

public class Prime {
    private static final String TASK_OF_GAME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startPrimeGame() {
        String[][] statements = new String[Engine.COUNT_TRY_TO_FINISH][Engine.MAX_ARRAY_SIZE];
        for (var i = 0; i < Engine.COUNT_TRY_TO_FINISH; i++) {
            var numberCheck = getRandomNumber();
            var questionStatement = Integer.toString(numberCheck);
            var correctAnswer = getCorrectAnswerText(numberCheck) ? "yes" : "no";

            statements[i][0] = questionStatement;
            statements[i][1] = correctAnswer;
        }
        Engine.startGame(TASK_OF_GAME, statements);
    }

    private static boolean getCorrectAnswerText(int num) {
        if (num <= 1) {
            return false;
        }
        for (var i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
