package hexlet.code;

public class Utils {
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
}
