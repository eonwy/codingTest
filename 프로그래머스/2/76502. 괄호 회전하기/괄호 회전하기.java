import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            
            for (int j = i; j < i + s.length(); j++) {
                
                char c = s.charAt(j % s.length());
                
                if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else if (c == '}') {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
                
            }
            
            if (stack.isEmpty()) {
                answer++;
            }
            
        }
        
        return answer;
    }
}