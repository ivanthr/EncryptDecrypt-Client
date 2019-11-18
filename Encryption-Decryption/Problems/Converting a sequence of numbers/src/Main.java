import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int i;
            String s = sc.nextLine();
            try {
                i = Integer.parseInt(s);
                if(i != 0) {
                    System.out.println(i * 10);
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid user input: " + s);
            }
        }
    }
}