package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.getRandomDigit;
import static hexlet.code.Utils.getRandomNumber;

public class Progression {
    public static final String TASK_OF_GAME = "What number is missing in the progression?";
    public static final String HIDDEN_POSITION = "..";
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
        final int countSteps = 10;
        final int minValueStep = 2;
        final int maxValueStep = 9;
        final int minValueSecretPosition = 1;
        final int maxValueSecretPosition = 9;
        var statement = new StringBuilder();
        var startProgression = getRandomNumber();
        var stepProgression = getRandomDigit(minValueStep, maxValueStep);
        var secretPosition = getRandomDigit(minValueSecretPosition, maxValueSecretPosition);
        for (var i = 1; i <= countSteps; i++) {
            var number = (i == secretPosition) ? HIDDEN_POSITION : (startProgression + stepProgression * i);
            statement.append(number);
            statement.append(" ");
        }
        return statement.toString().trim();
    }
    private static String getCorrectAnswerText(String statement) {
        String[] numbers = statement.split(" ");
        var skipNumber = 0;
        var skipPosition = 0;
        for (var i = 0; i < numbers.length; i++) {
            if (HIDDEN_POSITION.equals(numbers[i])) {
                skipPosition = i;
                break;
            }
        }
        if ((skipPosition > 0) && (skipPosition < numbers.length - 1)) {
            var numberFirst = Integer.parseInt(numbers[skipPosition - 1]);
            var numberSecond = Integer.parseInt(numbers[skipPosition + 1]);
            skipNumber = (numberFirst + numberSecond) / 2;
        } else if (skipPosition == 0) {
            var numberFirst = Integer.parseInt(numbers[skipPosition + 1]);
            var numberSecond = Integer.parseInt(numbers[skipPosition + 2]);
            skipNumber = numberFirst - (numberSecond - numberFirst);
        } else if (skipPosition == numbers.length - 1) {
            var numberFirst = Integer.parseInt(numbers[skipPosition - 2]);
            var numberSecond = Integer.parseInt(numbers[skipPosition - 1]);
            skipNumber = numberSecond + (numberSecond - numberFirst);
        }
        return Integer.toString(skipNumber);
    }
}
