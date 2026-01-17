class Solution {
    static final int MAX_N = 10000;
    
    int[] person = new int[MAX_N];
    int[] parent = new int[MAX_N];
    int[][] child = new int[MAX_N][2];
    int root, cnt, limit;
    
    int dfs(int node) {
        if (node == -1) return 0;
        
        if (person[node] > limit) {
            cnt = MAX_N + 1;
            return person[node];
        }
        
        int numL = dfs(child[node][0]);
        int numR = dfs(child[node][1]);
        
        if (numL + numR + person[node] <= limit) {
            return numL + numR + person[node];
        }
        
        if (numL == 0 || numR == 0) {
            cnt++;
            return person[node];
        }
        
        if (numL + person[node] <= limit && numR + person[node] <= limit) {
            cnt++;
            return numL < numR ? numL + person[node] : numR + person[node];
        }
        
        if (numL + person[node] <= limit) {
            cnt++;
            return numL + person[node];
        }
        
        if (numR + person[node] <= limit) {
            cnt++;
            return numR + person[node];
        }
        
        cnt += 2;
        return person[node];
    }
    
    public boolean check(int mid, int k) {
        cnt = 0;
        limit = mid;
        
        dfs(root);
        
        if (cnt < k) return true;
        
        return false;
    }
    
    public int solution(int k, int[] num, int[][] links) {
        int sum = 0;
        
        for (int i = 0; i < num.length; i++) {
            parent[i] = -1;
            person[i] = num[i];
            sum += num[i];
        }
        
        for (int i = 0; i < num.length; i++) {
            
            child[i][0] = links[i][0];
            if (child[i][0] != -1) {
                parent[child[i][0]] = i;
            }
            
            child[i][1] = links[i][1];
            if (child[i][1] != -1) {
                parent[child[i][1]] = i;
            }
        }
        
        for (int i = 0; i < num.length; i++) {
            if (parent[i] == -1) {
                root = i;
                break;
            }
        }
        
        int low = sum / k, high = sum;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(mid, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}