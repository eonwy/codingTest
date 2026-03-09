import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] length = new int[N - 1];
        int[] cost = new int[N];
        boolean[] visited = new boolean[N];
        long answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int index = -1;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < N; j++) {
                if (min > cost[j] && !visited[j]) {
                    index = j;
                    min = cost[j];
                }
            }
            if (index == -1) {
                break;
            }

            if (index == N - 1) {
                visited[index] = true;
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