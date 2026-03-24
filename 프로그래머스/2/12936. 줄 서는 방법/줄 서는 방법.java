import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> arr = new ArrayList<>();
        
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            arr.add(i);
            factorial *= i;
        }
        
        k--;
        
        int idx = 0;
        while(idx < n) {
            factorial /= n - idx;
            answer[idx++] = arr.remove((int) (k / factorial));
            k %= factorial;
        }
        
        return answer;
    }
}