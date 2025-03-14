import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        
        int M = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }
        
        Arrays.sort(A);
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < M; i++) {
            if (binarySearch(A, B[i])) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        
        System.out.println(sb);
        sc.close();
    }
    
    public static boolean binarySearch(int[] A, int item) {
        int left = 0;
        int right = A.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (item < A[mid]) right = mid - 1;
            else if (item > A[mid]) left = mid + 1;
            else return true;
        }
        return false;
    }
}