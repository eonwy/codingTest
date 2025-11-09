import java.io.*;
import java.util.*;

public class Main {
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        arr = new int[15][15];
        
        for (int i=0; i<15; i++) {
            arr[0][i] = i;
        }
        
        for (int i=1; i<15; i++) {
            dp(i);
        }
        
        for (int i=0; i<T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            
            System.out.println(arr[k][n]);
        }
    }
    
    public static void dp(int floor) {
        for (int i=0; i<15; i++) {
            for (int j=0; j<=i; j++) {
                arr[floor][i] += arr[floor-1][j];
            }
        }
    }
}