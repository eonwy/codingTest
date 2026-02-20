import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] village;
    static List<List<int[]>> route = new ArrayList<>();
    static int start, arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 버스 정보를 저장할 배열
        for (int i = 0; i <N; i++) {
            route.add(new ArrayList<>());
        }

        // 버스 정보 양방향 저장
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            route.get(s).add(new int[]{a, c});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        arrive = Integer.parseInt(st.nextToken());

        village = new int[N];
        Arrays.fill(village, Integer.MAX_VALUE);
        village[start-1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        pq.add(new int[]{start-1, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];

            if (curCost > village[curNode]) continue;

            for (int[] next : route.get(curNode)) {
                int nextNode = next[0];
                int nextCost = next[1];

                if (village[nextNode] > curCost + nextCost) {
                    village[nextNode] = curCost + nextCost;
                    pq.add(new int[]{nextNode, curCost + nextCost});
                }
            }
        }

        System.out.println(village[arrive-1]);
    }
}