import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<Integer>());
        }
        
        for (int[] w : wires) {
            arr.get(w[0]).add(w[1]);
            arr.get(w[1]).add(w[0]);
        }
        
        for (int[] w : wires) {
            int v1 = w[0];
            int v2 = w[1];
            
            arr.get(v1).remove(Integer.valueOf(v2));
            arr.get(v2).remove(Integer.valueOf(v1));

            
            boolean[] visited = new boolean[n + 1];
            int cnt = dfs(v1, visited);
            
            int diff = Math.abs(n - 2 * cnt);
            answer = Math.min(answer, diff);
            
            arr.get(v1).add(v2);
            arr.get(v2).add(v1);
        }
        
        return answer;
    }
    
    public int dfs(int node, boolean[] visited) {
        visited[node] = true;
        int cnt = 1;
        
        for (int next : arr.get(node)) {
            if (!visited[next]) {
                cnt += dfs(next, visited);
            }
        }
        
        return cnt;
    }
}