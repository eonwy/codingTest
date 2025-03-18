import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] arrN = new int[N];
        for (int i = 0; i < N; i++) {
            arrN[i] = sc.nextInt();
        }
        Arrays.sort(arrN);
        
        int M = sc.nextInt();
        int[] arrM = new int[M];
        for (int i = 0; i < M; i++) {
            arrM[i] = sc.nextInt();
        }
        
        StringBuffer answer = new StringBuffer();
        for (int i = 0; i < M; i++) {
            int firstIdx = binarySearchFirst(arrN, arrM[i]);
            int lastIdx = binarySearchLast(arrN, arrM[i]);
            
            if (firstIdx == arrN.length || arrN[firstIdx] != arrM[i]) {
                answer.append(0).append(' ');
            } else {
                answer.append(lastIdx - firstIdx).append(' ');
            }
        }
        
        System.out.println(answer);
        sc.close();
    }
    
    // arrN[]에서 item값과 동일한 값의 첫부분 찾기
    public static int binarySearchFirst(int[] arrN, int item) {
        int left = 0;
        int right = arrN.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (item <= arrN[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
        
    }
    
    // arrN[]에서 item값과 동일한 값의 마지막부분 찾기
    public static int binarySearchLast(int[] arrN, int item) {
        int left = 0;
        int right = arrN.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (item < arrN[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
        
    }
    
}