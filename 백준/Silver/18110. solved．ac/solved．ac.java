import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int fifteen = (int) Math.round(n * 0.15);

        int[] copied = Arrays.copyOfRange(arr, fifteen, n-fifteen);

        double sum = 0;
        for (int i=0; i<copied.length; i++) {
            sum += copied[i];
        }

        System.out.println((int) Math.round(sum / copied.length));
    }
}