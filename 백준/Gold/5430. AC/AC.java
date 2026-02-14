import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringBuilder output = new StringBuilder();
            Deque<Integer> deque = new ArrayDeque<>();

            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            if (n > 0) {
                String[] arr = s.substring(1, s.length() - 1).split(",");
                for (String str : arr) {
                    deque.add(Integer.parseInt(str));
                }
            }

            boolean isFront = true;
            boolean error = false;

            for (int j = 0; j < cmd.length(); j++) {
                char c = cmd.charAt(j);

                if (c == 'R') {
                    isFront = !isFront;
                } else {
                    if (deque.isEmpty()) {
                        output.append("error\n");
                        error = true;
                        break;
                    }

                    if (isFront) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if (error) {
                System.out.println("error"); 
                continue;
            }

            output.append("[");

            while (!deque.isEmpty()) {
                if (isFront) {
                    output.append(deque.pollFirst());
                } else {
                    output.append(deque.pollLast());
                }

                if (!deque.isEmpty()) {
                    output.append(",");
                }
            }

            output.append("]\n");
            System.out.print(output);
        }
    }
}