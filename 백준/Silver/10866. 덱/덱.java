import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> arr = new LinkedList<>();

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String act = st.nextToken();
            int s = arr.size();

            if (act.equals("empty")) {
                System.out.println(s == 0 ? 1 : 0);
                continue;
            }

            if (act.equals("front")) {
                System.out.println(s == 0 ? -1 : arr.get(0));
            } else if (act.equals("back")) {
                System.out.println(s == 0 ? -1 : arr.get(s-1));
            } else if (act.equals("size")) {
                System.out.println(s);
            }

            if (act.contains("push")) {
                int num = Integer.parseInt(st.nextToken());
                if (act.contains("front")) {
                    arr.add(0, num);
                } else {
                    arr.add(num);
                }
            } else if (act.contains("pop")) {
                if (s == 0) {
                    System.out.println(-1);
                    continue;
                }

                if (act.contains("front")) {
                    int removed = arr.remove(0);
                    System.out.println(removed);
                } else {
                    int removed = arr.remove(s-1);
                    System.out.println(removed);
                }
            }
        }
    }
}