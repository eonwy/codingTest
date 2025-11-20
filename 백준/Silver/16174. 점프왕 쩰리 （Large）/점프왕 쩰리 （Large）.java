import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
       
        arr = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        boolean result = dfs(0, 0);
        
        System.out.println(result ? "HaruHaru" : "Hing");
    }
    
    public static boolean dfs(int x, int y) {
        
        // 범위 밖
        if (x >= N || x < 0 || y >= N || y < 0) return false;
        
        // 들른 곳
        if (visited[x][y]) return false;
        
        // 성공
        if (x == N-1 && y == N-1) return true;
        
        visited[x][y] = true;
        
        int jump = arr[x][y];
        
        if (jump == 0) return false;
        if (dfs(x+jump, y)) return true;
        if (dfs(x, y+jump)) return true;
        
        return false;
    }
}