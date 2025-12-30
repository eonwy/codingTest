import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new long[n+1];
        arr[0] = 1;

        dp(n);
        System.out.println(arr[n]);
    }

    public static void dp(int n) {
        if (arr[n] != 0) {
            return;
        }

        if (arr[n] == 0) {
            dp(n-1);
        }

        if (n == 0) {
            return;
        }

        for(int i=0; i<n; i++) {
            arr[n] += arr[i]*arr[n-i-1];
        }

        return;
    }
}