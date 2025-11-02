import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[m];
        
        dfs(1, 0);
    }
    
    public static void dfs(int at, int depth) {
        if (depth == m) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }
        
        for (int i=at; i<=n; i++) {
            arr[depth] = i;
            dfs(i, depth+1);
        }
    }
}