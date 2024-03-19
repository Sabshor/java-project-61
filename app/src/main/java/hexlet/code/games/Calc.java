package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_ARRAY_SIZE;
import static hexlet.code.Engine.COUNT_TRY_TO_FINISH;

public class Calc {
    private static final String TASK_OF_GAME = "What is the result of the expression?";
    private static final int MIN_DIGIT = 1;
    private static final int MAX_DIGIT = 9;
    public static void startCalcGame() {
        String[][] statements = new String[COUNT_TRY_TO_FINISH][MAX_ARRAY_SIZE];
        for (var i = 0; i < COUNT_TRY_TO_FINISH; i++) {
            var questionStatement = getCalculateStatement();
            var correctAnswer = getCorrectAnswerText(questionStatement);

            statements[i][0] = questionStatement;
            statements[i][1] = Integer.toString(correctAnswer);
        }
        Engine.startGame(TASK_OF_GAME, statements);
    }
    private static String getCalculateStatement() {
        char[] allOperators = {'+', '-', '*'};
        int chooseOperand = Utils.getRandomDigit(MIN_DIGIT, allOperators.length);
        var operand = allOperators[chooseOperand - 1];
        return Utils.getRandomDigit(MIN_DIGIT, MAX_DIGIT) + " " + operand + " " + Utils.getRandomNumber();
    }
    private static int getCorrectAnswerText(String statement) {
        String[] numbers = statement.split(" ");
        int n1 = Integer.parseInt(numbers[0]);
        int n2 = Integer.parseInt(numbers[2]);
        char operand = numbers[1].charAt(0);
        switch (operand) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            default:
                return n1 * n2;
        }
    }
}
