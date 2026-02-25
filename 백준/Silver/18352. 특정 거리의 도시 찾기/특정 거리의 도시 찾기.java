import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static int[] distance;
    static ArrayList<List<Integer>> city = new ArrayList<>();
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[X-1] = 0;

        for (int i = 0; i < N; i++) {
            city.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()) - 1;
            int arrive = Integer.parseInt(st.nextToken()) - 1;

            city.get(start).add(arrive);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        pq.add(new int[]{X-1, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];

            if (curCost > distance[curNode]) continue;

            for (int c : city.get(curNode)) {
                if (distance[c] > curCost + 1) {
                    distance[c] = curCost + 1;
                    pq.add(new int[]{c, curCost + 1});
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == K) answer.add(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i)).append("\n");
        }

        System.out.println(answer.isEmpty() ? -1 : sb);
    }
}