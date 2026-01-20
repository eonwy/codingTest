import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) {
            q.add(w);
        }
        
        for (int i = 0; i < n; i++) {
            int work = q.poll() - 1;
            q.add(work < 0 ? 0 : work);
        }
        
        for (int i : q) {
            answer += (long) Math.pow(i, 2);
        }
        
        return answer;
    }
}