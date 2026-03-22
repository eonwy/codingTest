import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        
        int r = board.length;
        int c = board[0].length();
        int rRow = 0, rCol = 0, gRow = 0, gCol = 0;
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 동, 서, 남, 북
        boolean[][] visited = new boolean[r][c];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char ch = board[i].charAt(j);
                
                if (ch == 'R') {
                    rRow = i;
                    rCol = j;
                }
                if (ch == 'G') {
                    gRow = i;
                    gCol = j;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{rRow, rCol, 0});
        visited[rRow][rCol] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int curCost = cur[2];
            
            if (board[curRow].charAt(curCol) == 'G') return curCost;
            
            for (int[] d : directions) {
                int nr = curRow;
                int nc = curCol;

                while (true) {
                    int newRow = nr + d[0];
                    int newCol = nc + d[1];

                    if (newRow < 0 || newRow >= r || newCol < 0 || newCol >= c) break;
                    if (board[newRow].charAt(newCol) == 'D') break;

                    nr = newRow;
                    nc = newCol;
                }

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc, curCost + 1});
                }
            }
        }
        
        return answer;
    }
}