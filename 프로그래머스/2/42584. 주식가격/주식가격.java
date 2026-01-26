import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int len = prices.length;
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = len - 1 - index;
        }
        
        return answer;   
    }
}