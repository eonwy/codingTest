import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        Deque<Integer> answer = new ArrayDeque<>();
        
        for (int n : num_list) {
            answer.addFirst(n);
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}