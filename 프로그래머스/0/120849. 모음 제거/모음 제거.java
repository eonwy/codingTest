import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < my_string.length(); i++) {
            if (!"aeiou".contains(String.valueOf(my_string.charAt(i)))) {
                answer.append(my_string.charAt(i));
            }
        }
        
        return answer.toString();
    }
}