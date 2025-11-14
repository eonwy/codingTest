import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int r, c, dir;
    public static int[][] map;
    public static boolean[][] clean;
    public static int[][] direction = {
        {-1, 0}, // 북
        {0, 1},  // 동
        {1, 0},  // 남
        {0, -1}  // 서
    };

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());
        
        map = new int [N][M];
        clean = new boolean[N][M];
        
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(simulate());
    }
    
    public static int simulate() {
       
        int count = 0;
        
        while (true) {
            if(!clean[r][c]) {
                clean[r][c] = true;
                count++;
            }
            
            boolean found = false;
            
            for (int i=0; i<4; i++) {
                dir = (dir + 3) % 4;
                int nr = r + direction[dir][0];
                int nc = c + direction[dir][1];
                
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0 && !clean[nr][nc]) {
                    r = nr;
                    c = nc;
                    found = true;
                    break;
                }
            }
            
            if (found) continue;
            
            int backDir = (dir + 2) % 4;
            int br = r + direction[backDir][0];
            int bc = c + direction[backDir][1];
            
            if (br < 0 || br >= N || bc < 0 || bc >= M || map[br][bc] == 1) {
                return count;
            }
            
            r = br;
            c = bc;
        }
    }
    
}