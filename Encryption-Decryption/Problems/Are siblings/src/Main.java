import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\ivt44\\dataset_91065.txt";
        File f = new File(path);
        Scanner sc = null;
        try {
            sc = new Scanner(f);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        int num = 9999;
        int count = 0;
        while (sc.hasNext()) {
            int i = Integer.parseInt(sc.nextLine());
            if (i == 0) {
                break;
            } else if (i % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}