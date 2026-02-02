import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int last = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            String cmd = s.split(" ")[0];

            if (cmd.equals("push")) {
                last = Integer.parseInt(s.split(" ")[1]);
                q.add(last);
            } else if (cmd.equals("pop")) {
                System.out.println(q.isEmpty() ? "-1" : q.poll());
            } else if (cmd.equals("size")) {
                System.out.println(q.size());
            } else if (cmd.equals("empty")) {
                System.out.println(q.isEmpty() ? "1" : "0");
            } else if (cmd.equals("front")) {
                System.out.println(q.isEmpty() ? "-1" : q.peek());
            } else if (cmd.equals("back")) {
                System.out.println(q.isEmpty() ? "-1" : last);
            }
        }
    }
}