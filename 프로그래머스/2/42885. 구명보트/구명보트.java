import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int cnt = 0;
        int low = 0;
        int high = people.length - 1;
        
        Arrays.sort(people);
        
        while(low <= high) {
            if (people[low] + people[high] <= limit) {
                low++;
            }
            high--;
            cnt++;
        }
        
        return cnt;
    }
}