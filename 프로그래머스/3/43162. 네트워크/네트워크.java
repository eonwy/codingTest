import java.util.*;

class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                dfs(computers, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int[][] computers, int node) {
        visited[node] = true;
        
        for (int i = 0; i < computers[node].length; i++) {
            if (computers[node][i] == 1 && i != node && !visited[i]) {
                dfs(computers, i);
            }
        }
        
        return;
    }
}