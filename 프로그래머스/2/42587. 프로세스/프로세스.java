import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        // 우선순위 큐를 내림차순으로 정렬 = 우선순위가 높은 것부터 뽑겠다
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : priorities) {
            q.add(i);
        }
        
        int cnt = 0;
        
        while(!q.isEmpty()) {
            for (int i=0; i<priorities.length; i++) {
                if (priorities[i] == q.peek()) {
                    q.poll();
                    cnt++;
                    
                    if (i == location) {
                        return cnt;
                    }
                }
            }
        }
        
        return cnt;
    }
}