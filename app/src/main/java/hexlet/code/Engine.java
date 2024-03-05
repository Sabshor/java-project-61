package hexlet.code;

public class Engine {
    public static int countTryToFinish = 3;
    public static int getRandomNumber() {
        int number = (int) (Math.random() * 100);
        while (number == 0) {
            number = (int) (Math.random() * 100);
        }
        return number;
    }
    public static int getRandomNumber(int maxValue) {
        int number = (int) (Math.random() * 10);
        while ((number == 0) || (number > maxValue)) {
            number = (int) (Math.random() * 10);
        }
        return number;
    }
    public static char getCalcOperand() {
        return switch (getRandomNumber(3)) {
            case 1 -> '+';
            case 2 -> '-';
            case 3 -> '*';
            default -> '+';
        };
    }
    public static String getTaskGame(String gameName) {
        var task = "";
        switch (gameName.toLowerCase()) {
            case "even":
                task = "Answer 'yes' if the number is even, otherwise answer 'no'.";
                break;
            case "calc":
                task = "What is the result of the expression?";
                break;
            default:
                break;
        }
        return task;
    }
    public static String getExpression(String gameName) {
        var expression = "";
        switch (gameName.toLowerCase()) {
            case "even":
                expression = Integer.toString(getRandomNumber());
                break;
            case "calc":
                expression = getRandomNumber(10) + " " + getCalcOperand() + " " + getRandomNumber();
                break;
            default:
                break;
        }
        return expression;
    }
    public static String getCorrectAnswerText(String gameName, String expression) {
        var correctAnswerText = "";
        switch (gameName.toLowerCase()) {
            case "even":
                correctAnswerText = (Integer.parseInt(expression) % 2 == 0) ? "yes" : "no";
                break;
            case "calc":
                correctAnswerText = Integer.toString(calculateExpression(expression));
                break;
            default:
                break;
        }
        return correctAnswerText;
    }
    public static int calculateExpression(String expression) {
        String[] numbers = expression.split(" ");
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
        return result;
    }
}
