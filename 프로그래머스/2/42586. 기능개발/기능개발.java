import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] daysArr = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
            int left = 100 - progresses[i];
            int days = left / speeds[i];
            
            daysArr[i] = (left % speeds[i] == 0) ? days : days + 1;
        }
        
        List<Integer> answer = new ArrayList<>();
        int prevMaxDays = daysArr[0];
        int count = 0;
        
        for (int i = 0; i < daysArr.length; i++) {
            if (daysArr[i] <= prevMaxDays) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                prevMaxDays = daysArr[i];
            }
        }
        
        answer.add(count);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}