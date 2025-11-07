import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[5001];
        arr[3] = 1;
        arr[4] = Integer.MAX_VALUE;
        arr[5] = 1;
        arr[6] = 2;
        arr[7] = Integer.MAX_VALUE;;
        
        for (int i=8; i<=N; i++) {
            arr[i] = Math.min(arr[i-3], arr[i-5]) + 1;
        }
        
        System.out.println(arr[N] == Integer.MAX_VALUE ? -1 : arr[N]);
        
    }
}