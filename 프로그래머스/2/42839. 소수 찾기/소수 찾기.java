import java.util.*;

class Solution {
    
    char[] nums;
    boolean[] visited;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        
        nums = numbers.toCharArray();
        visited = new boolean[nums.length];

        dfs("", visited);

        int answer = 0;
        for (int n : set) {
            if (isPrime(n)) answer++;
        }
        
        return answer;
    }
    
    public void dfs(String cur, boolean[] visited) {
        if (!cur.isEmpty()) {
            set.add(Integer.parseInt(cur));
        }


        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(cur + nums[i], visited);
                visited[i] = false;
            }
        }
    }


    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}