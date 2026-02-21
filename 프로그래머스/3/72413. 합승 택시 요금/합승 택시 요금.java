import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int min = Integer.MAX_VALUE;
        int[][] taxi = new int[n][n];
        List<List<int[]>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] f : fares) {
            int start = f[0] - 1;
            int finish = f[1] - 1;
            int cost = f[2];
            
            graph.get(start).add(new int[]{finish, cost});
            graph.get(finish).add(new int[]{start, cost});
        }
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(taxi[i], Integer.MAX_VALUE);
            taxi[i][i] = 0;
            
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                (x, y) -> x[1] - y[1]
            );
            pq.add(new int[]{i, 0});
            
            while(!pq.isEmpty()) {
                int[] cur = pq.poll();
                int curNode = cur[0];
                int curCost = cur[1];
                
                if (curCost > taxi[i][curNode]) continue;
                
                for (int[] next : graph.get(curNode)) {
                    int nextNode = next[0];
                    int nextCost = next[1];
                    
                    if (taxi[i][nextNode] > curCost + nextCost) {
                        taxi[i][nextNode] = curCost + nextCost;
                        pq.add(new int[]{nextNode, curCost + nextCost});
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            int together = taxi[s-1][i];
            
            int toA = taxi[i][a-1];
            int toB = taxi[i][b-1];
            
            if (min > together + toA + toB) {
                min = together + toA + toB;
            }
        }
        
        return min;
    }
}