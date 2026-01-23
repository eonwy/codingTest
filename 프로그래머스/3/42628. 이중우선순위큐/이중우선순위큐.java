import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(); // 오름차순
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder()); // 내림차순
        
        for (int i = 0; i < operations.length; i++) {
            String cmd = operations[i].split(" ")[0];
            int num = Integer.parseInt(operations[i].split(" ")[1]);
            
            if (cmd.equals("I")) {
                maxPQ.add(num);
                minPQ.add(num);
            } else {
                if (!minPQ.isEmpty() && !maxPQ.isEmpty()) {
                    if (num == -1) {
                        int tar = minPQ.poll();
                        maxPQ.remove(tar);
                    } else {
                        int tar = maxPQ.poll();
                        minPQ.remove(tar);
                    }
                }
            }
        }
        
        answer[0] = maxPQ.isEmpty() ? 0 : maxPQ.poll();
        answer[1] = minPQ.isEmpty() ? 0 : minPQ.poll();
        
        return answer;
    }
}