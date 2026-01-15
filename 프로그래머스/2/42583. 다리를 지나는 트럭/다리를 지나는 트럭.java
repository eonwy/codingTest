import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> bridge = new LinkedList<>();
        
        // bridge_length - 1 만큼만(= 1자리만 부족하게) bridge를 채워둠
        for (int i = 0; i < bridge_length - 1; i++) {
            bridge.add(0);
        }
        
        // 첫 번째 트럭을 bridge에 올림
        bridge.add(truck_weights[0]);
        
        int sec = 1; // 첫 번째 트럭이 올라갔으니 1초 시작
        int index = 1; // 다음 트럭의 index
        int now_weight = truck_weights[0]; // 현재 다리에 올라간 트럭 무게
        
        while(!bridge.isEmpty()) {
            
            sec++;
            
            int p = (int) bridge.poll();
            now_weight -= p;
            
            if (index < truck_weights.length) {
                if (now_weight + truck_weights[index] <= weight) {
                    bridge.add(truck_weights[index]);
                    now_weight += truck_weights[index];
                    index++;
                } else {
                    bridge.add(0);
                }
            }
            
        }
        
        return sec;
    }
}