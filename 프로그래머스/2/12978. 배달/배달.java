import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        // 직접 연결된 마을 간 배달 시간을 기록할 그래프 생성
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 직접 연결된 마을 간 배달 시간을 양방향으로 기록
        for (int[] r : road) {
            int start = r[0] - 1;
            int finish = r[1] - 1;
            int cost = r[2];
            
            graph.get(start).add(new int[]{finish, cost});
            graph.get(finish).add(new int[]{start, cost});
        }
        
        // 1번 마을에서 다른 마을까지 걸리는 총 배달 시간을 기록할 배열
        int[] delivery = new int[N];
        Arrays.fill(delivery, Integer.MAX_VALUE);
        delivery[0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );
        
        pq.add(new int[]{0, 0}); // {마을, 시간}
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];
            
            if (curCost > delivery[curNode]) continue;
            
            for (int[] next : graph.get(curNode)) {
                int nextNode = next[0];
                int nextCost = next[1];
                
                if (delivery[nextNode] > curCost + nextCost) {
                    delivery[nextNode] = curCost + nextCost;
                    pq.add(new int[]{nextNode, curCost + nextCost});
                }
            }
        }
        
        for (int d : delivery) {
            if (d <= K) answer++;
        }
        
        return answer;
    }
}