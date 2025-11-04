import java.io.*;
import java.util.*;

public class Main {
    public static int[][] arr = new int[30][30];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        for (int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
        
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            System.out.println(combination(m, n));
            
        }
    }
    
    public static int combination(int m, int n) {
        if (arr[m][n] > 0) {
            return arr[m][n];
        }
        
        if (m == n || n == 0) {
            return arr[m][n] = 1;
        }
        
        return arr[m][n] = combination(m-1, n-1) + combination(m-1, n);
    }
}