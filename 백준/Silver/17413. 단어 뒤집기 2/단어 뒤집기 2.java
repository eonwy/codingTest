import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder answer = new StringBuilder();
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean isForward = false;
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '<') {
                while(!stack.empty()) answer.append(stack.pop());
                isForward = true;
                answer.append(c);
                continue;
            }
            
            if (c == '>') {
                isForward = false;
                answer.append(c);
                continue;
            }
            
            if (isForward) {
                answer.append(c);
            } else {
                if (c == ' ') {
                    while(!stack.empty()) answer.append(stack.pop());
                    answer.append(' ');
                } else {
                    stack.push(c);
                }
            }
        }
        
        while(!stack.empty()){
            answer.append(stack.pop());
        }
        
        System.out.println(answer);
    }
}