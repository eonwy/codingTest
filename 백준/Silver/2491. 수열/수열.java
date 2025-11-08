import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[100001];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] decrease = new int[100001];
        int[] increase = new int[100001];
        decrease[0] = 1;
        increase[0] = 1;
        
        for (int i=1; i<N; i++) {
            if (arr[i] >= arr[i-1]) {
                increase[i] = increase[i-1] + 1;
            } else {
                increase[i] = 1;
            }
            
            if (arr[i] <= arr[i-1]) {
                decrease[i] = decrease[i-1] + 1;
            } else {
                decrease[i] = 1;
            }
        }
        
        int max = 0;
        for (int i=0; i<N; i++) {
            max = Math.max(max, Math.max(increase[i], decrease[i]));
        }
        
        System.out.println(max);
    }
}