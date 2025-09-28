import java.io.*;
import java.util.*;

public class Main {
    public static int min = 64;
    public static String[] chessboard;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        chessboard = new String[n];
        
        for (int i=0; i<n; i++) {
            chessboard[i] = br.readLine();
        }
        
        for (int i=0; i<n-7; i++) {
            for (int j=0; j<m-7; j++) {
                find(i, j, chessboard);
            }
        }
        
        System.out.println(min);
    }
    
    public static void find(int n, int m, String[] chessboard) {
        String[] example = {"WBWBWBWB", "BWBWBWBW"};
        int count = 0;
        
        for (int i=0; i<8; i++) {
            int row = n + i;
            for (int j=0; j<8; j++) {
                int col = m + j;
                
                if (chessboard[row].charAt(col) != example[row%2].charAt(j)) count++;
            }
        }
        
        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}