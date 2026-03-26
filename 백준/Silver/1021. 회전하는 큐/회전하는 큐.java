import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        LinkedList<Integer> d = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            d.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (d.indexOf(num) < d.size() - d.indexOf(num)) {
                while (d.peekFirst() != num) {
                    int poll = d.pollFirst();
                    d.addLast(poll);
                    count++;
                }
            } else {
                while (d.peekFirst() != num) {
                    int poll = d.pollLast();
                    d.addFirst(poll);
                    count++;
                }
            }
            d.pollFirst();
        }

        System.out.println(count);
    }
}