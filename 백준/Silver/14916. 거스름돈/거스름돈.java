import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[100001];
        
        arr[1] = Integer.MAX_VALUE;
        arr[2] = 1;
        arr[3] = Integer.MAX_VALUE;
        arr[4] = 2;
        arr[5] = 1;
        
        for (int i=6; i<=n; i++) {
            arr[i] = Math.min(arr[i-2], arr[i-5]) + 1;
        }
        
        System.out.println(arr[n] == Integer.MAX_VALUE ? -1 : arr[n]);
    }
}