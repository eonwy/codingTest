import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder result = new StringBuilder();

        int num = 0;
        
        while (result.length() < t * m) {
            String temp = Integer.toString(num, n).toUpperCase();
            result.append(temp);
            num++;
        }

        String str = result.substring(0, t*m);

        for (int i = p - 1; i < str.length(); i+=m) {
            answer.append(str.charAt(i));
        }
        
        return answer.toString();
    }
    
}