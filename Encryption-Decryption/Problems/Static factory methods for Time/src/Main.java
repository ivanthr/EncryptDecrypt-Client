import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;

    public static Time noon() {
        Time t = new Time();
        t.hour = 12;
        t.minute = 0;
        t.second = 0;
        return t;
    }

    public static Time midnight() {
        Time t = new Time();
        t.hour = 0;
        t.minute = 0;
        t.second = 0;
        return t;
    }

    public static Time ofSeconds(long seconds) {
        Time t = new Time();
        t.hour = (int) (seconds / (60*60)) % 24;
        t.minute = (int) (seconds / 60) % 60;
        t.second = (int) seconds % 60;
        return t;
    }

    public static Time of(int hour, int minute, int second) {
        if (hour > 23 || hour < 0 || minute > 59 || minute < 0 || second > 59 || second < 0) {
            return null;
        }
        Time t = new Time();
        t.hour = hour;
        t.minute = minute;
        t.second = second;
        return t;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String args[]) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time != null) {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        } else {
            System.out.println(time);
        }
    }
}