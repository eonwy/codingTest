import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        visited = new boolean[100001];

        System.out.println(bfs(N));
    }

    public static int bfs(int num) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );
        pq.add(new int[]{num, 0});

        if (num == K) return 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];

            visited[curNode] = true;

            if (curNode == K) return curCost;

            if (curNode * 2 < 100001 && !visited[curNode * 2]) pq.add(new int[]{curNode * 2, curCost});
            if (curNode + 1 < 100001 && !visited[curNode + 1]) pq.add(new int[]{curNode + 1, curCost + 1});
            if (curNode - 1 >= 0 && !visited[curNode - 1]) pq.add(new int[]{curNode - 1, curCost + 1});
        }

        return -1;
    }
}