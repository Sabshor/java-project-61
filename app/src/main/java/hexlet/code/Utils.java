package hexlet.code;

public class Utils {
    public static final int RANK_EXTENT = 100;
    public static final int RANK = 10;
    public static int getRandomNumber() {
        int number = (int) (Math.random() * RANK_EXTENT);
        while (number == 0) {
            number = (int) (Math.random() * RANK_EXTENT);
        }
        return number;
    }
    public static int getRandomDigit(int minValue, int maxValue) {
        int number = (int) (Math.random() * RANK);
        while ((number < minValue) || (number > maxValue)) {
            number = (int) (Math.random() * RANK);
        }
        return number;
    }
}
