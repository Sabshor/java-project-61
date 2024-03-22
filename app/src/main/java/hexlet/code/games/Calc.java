package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_ARRAY_SIZE;
import static hexlet.code.Engine.COUNT_TRY_TO_FINISH;

public class Calc {
    private static final String TASK_OF_GAME = "What is the result of the expression?";
    private static final int MIN_DIGIT = 1;
    private static final int MAX_DIGIT = 9;
    private static final char[] LIST_OPERATORS = {'+', '-', '*'};

    public static void startCalcGame() {
        String[][] statements = new String[COUNT_TRY_TO_FINISH][MAX_ARRAY_SIZE];
        for (var i = 0; i < COUNT_TRY_TO_FINISH; i++) {
            var firstNumber = Utils.getRandomDigit(MIN_DIGIT, MAX_DIGIT);
            var secondNumber = Utils.getRandomNumber();
            var indexOperand = Utils.getRandomDigit(MIN_DIGIT, LIST_OPERATORS.length);
            var operand = LIST_OPERATORS[indexOperand - 1];

            var questionStatement = firstNumber + " " + operand + " " + secondNumber;
            var correctAnswer = getCorrectAnswerText(firstNumber, secondNumber, operand);

            statements[i][0] = questionStatement;
            statements[i][1] = Integer.toString(correctAnswer);
        }
        Engine.startGame(TASK_OF_GAME, statements);
    }

    private static Integer getCorrectAnswerText(int firstNumber, int secondNumber, char operand) {
        switch (operand) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            default:
                return null;
        }
    }
}
