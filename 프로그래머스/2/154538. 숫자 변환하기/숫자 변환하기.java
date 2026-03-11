import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        boolean[] visited = new boolean[y + 1];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );
        pq.add(new int[]{x, 0});
        visited[x] = true;
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNum = cur[0];
            int curCnt = cur[1];
            
            if (curNum == y) {
                return curCnt;
            }
            
            if (curNum + n <= y && !visited[curNum + n]) {
                pq.add(new int[]{curNum + n, curCnt + 1});
                visited[curNum + n] = true;
            }
            if (curNum * 2 <= y && !visited[curNum * 2]) {
                pq.add(new int[]{curNum * 2, curCnt + 1});
                visited[curNum * 2] = true;
            }
            if (curNum * 3 <= y && !visited[curNum * 3]) {
                pq.add(new int[]{curNum * 3, curCnt + 1});
                visited[curNum * 3] = true;
            }
        }
        
        return answer;
    }
}