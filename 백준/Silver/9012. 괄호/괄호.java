import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();

            for (int j=0; j<s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(') stack.push('(');
                if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(')');
                    }
                }
                
            }

            if (stack.size() > 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}