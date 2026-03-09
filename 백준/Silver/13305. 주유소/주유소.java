import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        long[] length = new long[N - 1];
        long[] cost = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            length[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long answer = 0;
        long minCost = cost[0];
        for (int i = 0; i < N - 1; i++) {
            minCost = Math.min(minCost, cost[i]);
            answer += minCost * length[i];
        }

        System.out.println(answer);

    }
}