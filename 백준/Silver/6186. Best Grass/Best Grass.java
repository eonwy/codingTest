import java.io.*;
import java.util.*;

public class Main {
    
    static int R, C;
    static int[][] map;
    static boolean[][] visited;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];
        visited = new boolean[R][C];
        
        for (int i=0; i<R; i++) {
            String line = br.readLine();
            for (int j=0; j<C; j++) {
                char c = line.charAt(j);
                map[i][j] = (c == '#') ? 1 : 0;
            }
        }
        
        int count = 0;
        
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }
    
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            for (int i=0; i<4; i++) {
                int newR = r + direction[i][0];
                int newC = c + direction[i][1];
                
                if (newR >= 0 && newR < R && newC >= 0 && newC < C) {
                    if (map[newR][newC] == 1 && !visited[newR][newC]) {
                        visited[newR][newC] = true;
                        q.offer(new int[]{newR, newC});
                    }
                }
            }
        }
    }
}