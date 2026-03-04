import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][][] visited;
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long answer = -1;

        arr = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 1});
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curWall = cur[2];
            int curCost = cur[3];

            if (curX == N-1 && curY == M-1) {
                answer = curCost;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = curX + directions[i][0];
                int newY = curY + directions[i][1];

                if (newX < 0 || newX >= N || newY < 0 || newY >= M) continue;
                // 1️⃣ 벽이 아닌 경우
                if (arr[newX][newY] == 0 && !visited[newX][newY][curWall]) {
                    visited[newX][newY][curWall] = true;
                    q.add(new int[]{newX, newY, curWall, curCost + 1});
                }

                // 2️⃣ 벽인데 아직 안 깬 경우
                if (arr[newX][newY] == 1 && curWall == 0 && !visited[newX][newY][1]) {
                    visited[newX][newY][1] = true;
                    q.add(new int[]{newX, newY, 1, curCost + 1});
                }
            }
        }

        System.out.println(answer);
    }
}