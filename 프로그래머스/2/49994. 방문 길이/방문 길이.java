import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        
        boolean[][][] visited = new boolean[11][11][4];
        
        int x = 5;
        int y = 5;
        int d = 0;
        
        for (int i=0; i<dirs.length(); i++) {
            char c = dirs.charAt(i);
            
            if (c == 'U') d = 0;
            if (c == 'L') d = 1;
            if (c == 'D') d = 2;
            if (c == 'R') d = 3;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx < 0 || nx >= 11 || ny < 0 || ny >= 11) continue;
            if (!visited[nx][ny][d]) {
                visited[nx][ny][d] = true;
                visited[x][y][(d+2) % 4] = true;
                answer++;
            }
            
            x = nx;
            y = ny;
        }
        
        return answer;
    }
}