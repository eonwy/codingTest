import java.io.*;
import java.util.*;

public class Main {
    static int V, E, K;
    static List<List<int[]>> graph = new ArrayList<>();
    static int[] channel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        channel = new int[V];
        Arrays.fill(channel, Integer.MAX_VALUE);
        channel[K-1] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[]{v, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );
        pq.add(new int[]{K-1, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];

            if (curCost > channel[curNode]) continue;

            for (int[] next : graph.get(curNode)) {
                int nextNode = next[0];
                int nextCost = next[1];

                if (channel[nextNode] > curCost + nextCost) {
                    channel[nextNode] = curCost + nextCost;
                    pq.add(new int[]{nextNode, curCost + nextCost});
                }
            }
        }

        for (int i : channel) {
            System.out.println(i == Integer.MAX_VALUE ? "INF" : i);
        }
    }
}