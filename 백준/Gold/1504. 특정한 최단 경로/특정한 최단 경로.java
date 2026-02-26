import java.io.*;
import java.util.*;

public class Main {
    static int N, E, v1, v2;
    static ArrayList<List<int[]>> graph = new ArrayList<>();
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int[] form = dikstra(1);
        int[] form1 = dikstra(v1);
        int[] form2 = dikstra(v2);

        long res1 = (long)form[v1] + form1[v2] + form2[N];
        long res2 = (long)form[v2] + form2[v1] + form1[N];

        long answer = Math.min(res1, res2);

        if (form[v1] == INF ||
            form1[v2] == INF ||
            form2[N] == INF) res1 = INF;

        if (form[v2] == INF ||
            form2[v1] == INF ||
            form1[N] == INF) res2 = INF;

        answer = Math.min(res1, res2);

        System.out.println(answer >= INF ? -1 : answer);
    }

    public static int[] dikstra(int start) {
        int[] distance = new int[N+1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];

            if (curCost > distance[curNode]) continue;

            for (int[] next : graph.get(curNode)) {
                int nextNode = next[0];
                int nextCost = next[1];

                if (distance[nextNode] > curCost + nextCost) {
                    distance[nextNode] = curCost + nextCost;
                    pq.add(new int[]{nextNode, curCost + nextCost});
                }
            }
        }
        
        return distance;
    }
}