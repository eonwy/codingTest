import java.util.*;

class Solution {
    static int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    
    public int solution(int[][] maps) {
        
        int mapR = maps.length;
        int mapC = maps[0].length;
        
        boolean[][] visited = new boolean[mapR][mapC];
        int[][] sum = new int[mapR][mapC];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        
        visited[0][0] = true;
        sum[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            if (r == mapR-1 && c == mapC-1) {
                return sum[r][c];
            }
            
            for (int i=0; i<4; i++) {
                int newR = r + direction[i][0];
                int newC = c + direction[i][1];
                
                // 범위 밖
                if (newR < 0 || newR >= mapR || newC < 0 || newC >= mapC) {
                    continue;
                }
                
                // 벽 또는 이미 방문
                if (maps[newR][newC] == 0 || visited[newR][newC]) {
                    continue;
                }
                
                visited[newR][newC] = true;
                sum[newR][newC] = sum[r][c] + 1;
                q.offer(new int[]{newR, newC});
            }
        }
        
        return -1;
        
    }
}