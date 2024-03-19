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
            int number = getNumber();
            String[] expressions = getPrintStatementsEven(number);

            var questionStatement = expressions[0];
            var correctAnswer = expressions[1];
            statements[i][0] = questionStatement;
            statements[i][1] = correctAnswer;
        }
        Engine.startGame(TASK_OF_GAME, statements);
    }
    private static int getNumber() {
        return Utils.getRandomNumber();
    }
    private static String[] getPrintStatementsEven(int number) {
        String question = Integer.toString(number);
        String correctAnswer = (number % 2 == 0) ? "yes" : "no";
        return new String[]{question, correctAnswer};
    }
}
