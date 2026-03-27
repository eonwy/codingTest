import java.io.*;
import java.util.*;

public class Main {
    static int T, M, N, K;
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int count = 0;
            LinkedList<String> cabbage = new LinkedList<>();

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                cabbage.add(r + "/" + c);
            }

            while (!cabbage.isEmpty()) {
                String cab = cabbage.poll();

                Queue<String> q = new LinkedList<>();
                q.add(cab);

                while (!q.isEmpty()) {
                    String[] parts = q.poll().split("/");
                    int curR = Integer.parseInt(parts[0]);
                    int curC = Integer.parseInt(parts[1]);

                    for (int d = 0; d < 4; d++) {
                        int newR = curR + directions[d][0];
                        int newC = curC + directions[d][1];

                        if (newR < 0 || newR >= N || newC < 0 || newC >= M) continue;

                        String temp = newR + "/" + newC;
                        if (cabbage.contains(temp)) {
                            q.add(temp);
                            cabbage.remove(temp);
                        }
                    }
                }

                count++;
            }

            System.out.println(count);
        }
    }
}