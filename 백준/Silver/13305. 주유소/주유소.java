import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        long[] length = new long[N - 1];
        long[] cost = new long[N];
        boolean[] visited = new boolean[N];
        long answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            length[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int index = -1;
            long min = Integer.MAX_VALUE;

            for (int j = 0; j < N; j++) {
                if (min > cost[j] && !visited[j]) {
                    index = j;
                    min = cost[j];
                }
            }

            if (index == -1) {
                break;
            } else if (index == N - 1) {
                visited[N - 1] = true;
                continue;
            }

            for (int j = index; j < N - 1; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    answer += cost[index] * length[j];
                }
            }
        }

        System.out.println(answer);

    }
}