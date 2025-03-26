import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int count = 0;
        int len = citations.length;
        
        Arrays.sort(citations);

        for (int i = len - 1; i >= 0; i--) {
            
            if (len - i <= citations[i]) {
                count = len - i;
            }
        }
        
        return count;
    }
}
