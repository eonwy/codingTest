import java.io.*;
import java.util.*;

public class Main {
    static int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            
            if (w == 0 && h == 0) {
                return;
            }
            
            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];
            
            for (int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int count = 0;
            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        bfs(map, visited, i, j);
                        count++;
                    }
                }
            }
            
            System.out.println(count);
            
        }
    }
    
    public static void bfs(int[][] map, boolean[][] visited, int i, int j) {
        Queue<int[]>q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            
            for (int k=0; k<8; k++) {
                int nRow = row + directions[k][0];
                int nCol = col + directions[k][1];
                
                if (nRow >= 0 && nRow < map.length && nCol >= 0 && nCol < map[0].length) {
                    if (map[nRow][nCol] == 1 && !visited[nRow][nCol]) {
                        visited[nRow][nCol] = true;
                        q.offer(new int[]{nRow, nCol});
                    }
                }
            }
        }
    }
}