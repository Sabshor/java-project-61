package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.COUNT_TRY_TO_FINISH;
import static hexlet.code.Engine.MAX_ARRAY_SIZE;

public class Progression {
    private static final String TASK_OF_GAME = "What number is missing in the progression?";
    private static final String HIDDEN_POSITION_VALUE = "..";
    private static final int MAX_STEPS = 10;
    private static final int MIN_VALUE_STEP = 2;
    private static final int MAX_VALUE_STEP = 9;
    private static final int MIN_INDEX_SECRET_POSITION = 1;
    private static final int MAX_INDEX_SECRET_POSITION = 9;

    public static void startProgressionGame() {
        String[][] statements = new String[COUNT_TRY_TO_FINISH][MAX_ARRAY_SIZE];
        for (var i = 0; i < COUNT_TRY_TO_FINISH; i++) {
            var startProgression = Utils.getRandomNumber();
            var stepProgression = Utils.getRandomDigit(MIN_VALUE_STEP, MAX_VALUE_STEP);
            var secretPosition = Utils.getRandomDigit(MIN_INDEX_SECRET_POSITION, MAX_INDEX_SECRET_POSITION);

            var progression = createProgression(startProgression, stepProgression);
            var questionStatement = getPrintQuestionProgression(progression, secretPosition);
            var correctAnswer = Integer.toString(progression[secretPosition]);

            statements[i][0] = questionStatement;
            statements[i][1] = correctAnswer;
        }
        Engine.startGame(TASK_OF_GAME, statements);
    }

    private static int[] createProgression(int startPosition, int stepPosition) {
        var progression = new int[MAX_STEPS];
        for (var index = 0; index < MAX_STEPS; index++) {
            progression[index] = startPosition + stepPosition * index;
        }
        return progression;
    }

    private static String getPrintQuestionProgression(int[] progression, int secretPosition) {
        String[] viewProgression = new String[progression.length];
        for (var i = 0; i < progression.length; i++) {
            viewProgression[i] = Integer.toString(progression[i]);
        }
        viewProgression[secretPosition] = HIDDEN_POSITION_VALUE;
        String question = String.join(" ", viewProgression);
        return question;
    }
}
