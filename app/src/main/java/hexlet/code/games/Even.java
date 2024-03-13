package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.getRandomNumber;

public class Even {
    public static final String TASK_OF_GAME = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static void start() {
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
        return Integer.toString(getRandomNumber());
    }
    private static String getCorrectAnswerText(String statement) {
        return (Integer.parseInt(statement) % 2 == 0) ? "yes" : "no";
    }
}
