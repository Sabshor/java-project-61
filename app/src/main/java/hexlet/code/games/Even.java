package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_ARRAY_SIZE;
import static hexlet.code.Engine.COUNT_TRY_TO_FINISH;

public class Even {
    private static final String TASK_OF_GAME = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void startEvenGame() {
        String[][] statements = new String[COUNT_TRY_TO_FINISH][MAX_ARRAY_SIZE];
        for (var i = 0; i < COUNT_TRY_TO_FINISH; i++) {
            int numberCheck = Utils.getRandomNumber();

            var questionStatement = Integer.toString(numberCheck);
            var correctAnswer = getCorrectAnswerText(numberCheck) ? "yes" : "no";

            statements[i][0] = questionStatement;
            statements[i][1] = correctAnswer;
        }
        Engine.startGame(TASK_OF_GAME, statements);
    }

    private static boolean getCorrectAnswerText(int number) {
        return number % 2 == 0;
    }
}
