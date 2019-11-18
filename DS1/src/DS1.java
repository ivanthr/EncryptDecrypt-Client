import java.util.*;

public class DS1 {
    List<Set<Integer>> L;

    DS1(int n) {
        L = new LinkedList<Set<Integer>>();
        for(int i=0; i<n; i++) {
            Set<Integer> S = new HashSet<Integer>();
            S.add(i);
            L.add(S);
        }
    }

    boolean connected(int s, int t) {
        for(Set<Integer> C: L) {
            if(C.contains(s) && C.contains(t)) {
                return true;
            }
        }
        return false;
    }

    void union(int s, int t) {
        Set<Integer> S = null;
        Set<Integer> T = null;
        for(Set<Integer> C : L) {
            if(C.contains(s)) {
                S = C;
            }
            if(C.contains(t)) {
                T = C;
            }
        }
        if(S != T) {
            S.addAll(T);
            L.remove(T);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        DS1 uf = new DS1(n);
        for(int i=0; i<m; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String command = parts[0];
            int s = Integer.parseInt(parts[1]);
            int t = Integer.parseInt(parts[2]);

            if(command.equals("u")) {
                uf.union(s, t);
            } else if(command.equals("q")) {
                System.out.println(uf.connected(s, t) ? "yes" : "no");
            }
        }
    }
}
