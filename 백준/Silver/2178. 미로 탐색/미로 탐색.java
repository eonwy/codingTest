import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] sum;
    static int[][] map;
    static boolean[][] visited;
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sum = new int[N][M];
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        visited[0][0] = true;
        sum[0][0] = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int newR = r + directions[i][0];
                int newC = c + directions[i][1];

                if (newR >= 0 && newR < N && newC >= 0 && newC < M) {
                    if (!visited[newR][newC] && map[newR][newC] == 1) {
                        visited[newR][newC] = true;
                        q.add(new int[] {newR, newC});
                        sum[newR][newC] = sum[r][c] + 1;
                    }
                }
            }
        }

        System.out.println(sum[N-1][M-1]);
    }
}