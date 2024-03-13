package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.getRandomDigit;
import static hexlet.code.Utils.getRandomNumber;

public class Progression {
    public static final String TASK_OF_GAME = "What number is missing in the progression?";
    public static final String HIDDEN_POSITION = "..";
    public static final int MAX_STEPS = 10;
    public static final int MIN_VALUE_STEP = 2;
    public static final int MAX_VALUE_STEP = 9;
    public static final int MIN_INDEX_SECRET_POSITION = 1;
    public static final int MAX_INDEX_SECRET_POSITION = 9;
    public static void startProgressionGame() {
        String[][] statements = new String[Engine.COUNT_TRY_TO_FINISH][Engine.MAX_ARRAY_SIZE];
        for (var i = 0; i < Engine.COUNT_TRY_TO_FINISH; i++) {
            var statementProgression = new StringBuilder();
            var startProgression = getRandomNumber();
            var stepProgression = getRandomDigit(MIN_VALUE_STEP, MAX_VALUE_STEP);
            var secretPosition = getRandomDigit(MIN_INDEX_SECRET_POSITION, MAX_INDEX_SECRET_POSITION);
            String secretNumber = null;
            String[] progression = new String[MAX_STEPS];
            for (var index = 0; index < MAX_STEPS; index++) {
                progression[index] = String.valueOf(startProgression + stepProgression * index);
                if (index == secretPosition) {
                    secretNumber = progression[index];
                    progression[index] = HIDDEN_POSITION;
                }
                statementProgression.append(progression[index]);
                statementProgression.append(" ");
            }
            var questionStatement = statementProgression.toString().trim();
            statements[i][0] = questionStatement;
            statements[i][1] = secretNumber;
        }
        Engine.startGame(TASK_OF_GAME, statements);
    }
}
