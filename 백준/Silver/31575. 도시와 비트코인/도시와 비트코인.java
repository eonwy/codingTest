import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 
        
        arr = new int [M][N];
        visited = new boolean [M][N];
        
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        boolean isAble = dfs(0, 0);

        System.out.println(isAble ? "Yes" : "No");
    }
    
    public static boolean dfs(int r, int c) {
        
        // 범위 밖
        if (r < 0 || r >= M || c < 0 || c >= N) return false;
        
        // 못가는 구간
        if (arr[r][c] == 0) return false;
        
        // 이미 지난 곳
        if (visited[r][c]) return false;
        
        // 통과
        if (r == M-1 && c == N-1) return true;
        
        visited[r][c] = true;
        
        if (dfs(r+1, c)) return true;
        if (dfs(r, c+1)) return true;
        
        return false;
    }
}