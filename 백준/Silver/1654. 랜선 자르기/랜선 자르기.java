import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int K = sc.nextInt();
        int N = sc.nextInt();
        
        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        long answer = binarySearch(arr, K, N);
        
        System.out.println(answer);
        sc.close();
    }
    
    public static long binarySearch(int[] arr, int K, int N) {
        long left = 1;   
        long right = arr[K-1];
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            
            for (int i = 0; i < K; i++) {
                cnt += arr[i] / mid;
            }
            
            if (cnt < N) {  
                right = mid - 1;
            } else {        
                left = mid + 1;
            }
        }
        
        return right;
    }
}