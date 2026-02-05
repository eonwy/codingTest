import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] box;
    static int[][] sum;
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        sum = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, sum[i][j]);
            }
        }

        System.out.println(answer);

    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int newR = cur[0] + directions[i][0];
                int newC = cur[1] + directions[i][1];

                if (newR >= 0 && newR < N && newC >= 0 && newC < M) {
                    if (box[newR][newC] == 0) {
                        box[newR][newC] = 1;
                        sum[newR][newC] = sum[cur[0]][cur[1]] + 1;
                        q.add(new int[] {newR, newC});
                    }
                }
            }
        }
    }
}