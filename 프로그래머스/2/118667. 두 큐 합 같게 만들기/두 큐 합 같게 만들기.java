import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long oneSum = 0, twoSum = 0;
        Queue<Integer> one = new LinkedList<>();
        Queue<Integer> two = new LinkedList<>();
        
        for (int n : queue1) {
            one.add(n);
            oneSum += n;
        }
        for (int n : queue2) {
            two.add(n);
            twoSum += n;
        }
        
        int maxOperation = (one.size() + two.size()) * 2;
        
        while (oneSum != twoSum) {
            if (answer > maxOperation) return -1;
            
            if (oneSum > twoSum) {
                int item = one.poll();
                two.add(item);
                oneSum -= item;
                twoSum += item;
            } else if (oneSum < twoSum) {
                int item = two.poll();
                one.add(item);
                twoSum -= item;
                oneSum += item;
            }
            
            answer++;
        }
        
        return answer;
    }
}