import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> arr = new PriorityQueue<>(
            (a, b) -> {
                if (Math.abs(a) == Math.abs(b)) {
                    return a - b;
                }
                return Math.abs(a) - Math.abs(b);
            }
        );

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n != 0) arr.add(n);
            else {
                if (arr.isEmpty()) System.out.println("0");
                else {
                    System.out.println(arr.poll());
                }
            }
        }
    }
}