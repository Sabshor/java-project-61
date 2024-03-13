package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Utils.getRandomNumber;
import static hexlet.code.Utils.getRandomDigit;

public class Calc {
    public static final String TASK_OF_GAME = "What is the result of the expression?";
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
        final int minDigit = 1;
        final int maxDigit = 9;
        return getRandomDigit(minDigit, maxDigit) + " " + getCalcOperand() + " " + getRandomNumber();
    }
    private static String getCorrectAnswerText(String statement) {
        String[] numbers = statement.split(" ");
        int n1 = Integer.parseInt(numbers[0]);
        int n2 = Integer.parseInt(numbers[2]);
        char operand = numbers[1].charAt(0);
        var result = 0;
        switch (operand) {
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            default:
                break;
        }
        return Integer.toString(result);
    }
    private static char getCalcOperand() {
        var minValue = 1;
        var maxValue = 3;
        int chooseOperand = getRandomDigit(minValue, maxValue);
        if (chooseOperand == 1) {
            return '+';
        } else if (chooseOperand == 2) {
            return '-';
        } else {
            return '*';
        }
    }
}
