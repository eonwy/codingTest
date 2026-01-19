import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        // 인덱스를 담을 배열
        Stack<Integer> s = new Stack<>();
        
        // 첫번째 인덱스 넣어주기
        s.push(0);
        
        for (int i = 1; i < numbers.length; i++) {
            
            while (!s.isEmpty() && numbers[s.peek()] < numbers[i]) {
                answer[s.peek()] = numbers[i];
                s.pop();
            }
            
            s.push(i);
        }
        
        while (!s.isEmpty()) {
            answer[s.pop()] = -1;
        }
        
        return answer;
    }
}