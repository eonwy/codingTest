import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long[] sum = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[0] = arr[0];
        long max = sum[0];
        
        for (int i = 1; i < n; i++) {
            sum[i] = Math.max(sum[i-1] + arr[i], arr[i]);
            
            if (max < sum[i]) {
                max = sum[i];
            }
        }

        System.out.println(max);
    }
}