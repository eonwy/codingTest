import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        ArrayList<Integer> complex = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    complex.add(bfs(i, j));
                }
            }
        }

        Collections.sort(complex);

        System.out.println(complex.size());

        for (int i = 0; i < complex.size(); i++) {
            System.out.println(complex.get(i));
        }
    }

    public static int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;

        visited[r][c] = true;
        q.add(new int[] {r, c});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            cnt++;

            for (int i = 0; i < 4; i++) {
                int newR = cur[0] + directions[i][0];
                int newC = cur[1] + directions[i][1];

                if (newR >= 0 && newR < N && newC >= 0 && newC < N) {
                    if (!visited[newR][newC] && map[newR][newC] == 1) {
                        visited[newR][newC] = true;
                        q.add(new int[] {newR, newC});
                    }
                }
            }
        }

        return cnt;
    }
}