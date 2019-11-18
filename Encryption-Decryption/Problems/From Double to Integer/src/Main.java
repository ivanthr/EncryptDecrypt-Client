import java.util.*;

public class Main {

    public static int convert(Double val) {
        int i = 0;
        if (val.equals(Double.NEGATIVE_INFINITY)) {
            i = Integer.MIN_VALUE;
        } else if (val.equals(Double.POSITIVE_INFINITY)) {
            i = Integer.MAX_VALUE;
        } else if (val.equals(Double.NaN)) {
            i = 0;
        } else {
            i = val.intValue();
        }
        return i;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double doubleVal = new Double(scanner.nextDouble() / scanner.nextDouble());
        System.out.println(convert(doubleVal));
    }
}