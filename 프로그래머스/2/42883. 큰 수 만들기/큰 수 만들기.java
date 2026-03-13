import java.util.*;

class Solution {
    public String solution(String number, int k) {        
        StringBuilder sb = new StringBuilder();
        int remove = k;
        
        for (char c : number.toCharArray()) {
            while (remove > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < c) {
                sb.deleteCharAt(sb.length() - 1);
                remove--;
            }
            sb.append(c);
        }
        
        return sb.substring(0, number.length() - k);
    }
}