import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int p : prices) {
            q.add(p);
        }
        
        for (int i = 0; i < prices.length; i++) {
            int cnt = 0;
            int point = q.poll();
            
            for (int j = i + 1; j < prices.length; j++) {
                cnt++;
                if (point > prices[j]) break;
                    
            }
            
            answer[i] = cnt;
        }
        
        return answer;
    }
}