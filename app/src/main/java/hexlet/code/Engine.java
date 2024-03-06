package hexlet.code;

public class Engine {
    public static final int COUNT_TRY_TO_FINISH = 3;
    public static final String HIDDEN_POSITION = "..";
    public static String getTaskGame(String gameName) {
        var task = "";
        switch (gameName.toLowerCase()) {
            case "even":
                task = "Answer 'yes' if the number is even, otherwise answer 'no'.";
                break;
            case "calc":
                task = "What is the result of the expression?";
                break;
            case "nod":
                task = "Find the greatest common divisor of given numbers.";
                break;
            case "progression":
                task = "What number is missing in the progression?";
                break;
            case "prime":
                task = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
                break;
            default:
                break;
        }
        return task;
    }
    public static String getStatement(String gameName) {
        var statement = "";
        switch (gameName.toLowerCase()) {
            case "even", "prime":
                statement = Integer.toString(getRandomNumber());
                break;
            case "calc":
                final int minDigit = 1;
                final int maxDigit = 9;
                statement = getRandomDigit(minDigit, maxDigit) + " " + getCalcOperand() + " " + getRandomNumber();
                break;
            case "nod":
                statement = getRandomNumber() + " " + getRandomNumber();
                break;
            case "progression":
                statement = getProgressionStatement();
                break;
            default:
                break;
        }
        return statement;
    }
    public static String getCorrectAnswerText(String gameName, String expression) {
        var correctAnswerText = "";
        switch (gameName.toLowerCase()) {
            case "even":
                correctAnswerText = (Integer.parseInt(expression) % 2 == 0) ? "yes" : "no";
                break;
            case "calc":
                correctAnswerText = Integer.toString(getCorrectResultCalculate(expression));
                break;
            case "nod":
                correctAnswerText = Integer.toString(getCorrectResultGCD(expression));
                break;
            case "progression":
                correctAnswerText = Integer.toString(getCorrectResultProgression(expression));
                break;
            case "prime":
                correctAnswerText = isPrime(expression) ? "yes" : "no";
                break;
            default:
                break;
        }
        return correctAnswerText;
    }
    public static String getProgressionStatement() {
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
    public static int getCorrectResultGCD(String expression) {
        String[] numbers = expression.split(" ");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        return getGCD(a, b);
    }
    public static int getGCD(int a, int b) {
        if (a == 0) {
            return b;
        }
        while (b != 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
    public static int getCorrectResultCalculate(String expression) {
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
    public static int getCorrectResultProgression(String expression) {
        String[] numbers = expression.split(" ");
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
        return skipNumber;
    }
    public static boolean isPrime(String expression) {
        int number = Integer.parseInt(expression);
        boolean isPrime = true;
        for (var i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
    public static int getRandomNumber() {
        final int rank = 100;
        int number = (int) (Math.random() * rank);
        while (number == 0) {
            number = (int) (Math.random() * rank);
        }
        return number;
    }
    public static int getRandomDigit(int minValue, int maxValue) {
        final int rank = 10;
        int number = (int) (Math.random() * rank);
        while ((number < minValue) || (number > maxValue)) {
            number = (int) (Math.random() * rank);
        }
        return number;
    }
    public static char getCalcOperand() {
        var minValue = 1;
        var maxValue = 1;
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
