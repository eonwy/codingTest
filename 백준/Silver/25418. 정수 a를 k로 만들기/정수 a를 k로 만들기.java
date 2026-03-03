import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[k + 1];

        PriorityQueue<int[]> q = new PriorityQueue<>(
            (o1, o2) -> o1[1] - o2[1]
        );

        q.add(new int[]{a, 0});
        visited[a] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curNum = cur[0];
            int curCnt = cur[1];

            if (curNum == k) {
                System.out.println(curCnt);
                break;
            }

            if (curNum + 1 <= k && !visited[curNum + 1]) {
                visited[curNum + 1] = true;
                q.add(new int[]{curNum + 1, curCnt + 1});
            }

            if (curNum * 2 <= k && !visited[curNum * 2]) {
                visited[curNum * 2] = true;
                q.add(new int[]{curNum * 2, curCnt + 1});
            }
        }
    }
}