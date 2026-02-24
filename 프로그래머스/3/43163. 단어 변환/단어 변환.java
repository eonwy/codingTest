import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        boolean keep = false;
        
        for (String w : words) {
            if (target.equals(w)) {
                keep = true;
                break;
            }
        }
        
        if (!keep) return 0;
        
        Queue<String[]> q = new LinkedList<>();
        q.add(new String[]{begin, "0"});
        
        while(!q.isEmpty()) {
            String[] cur = q.poll();
            String curString = cur[0];
            int curCost = Integer.parseInt(cur[1]);
            
            if (curString.equals(target)) return curCost;
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isOneDiff(curString, words[i])) {
                    visited[i] = true;
                    q.add(new String[]{words[i], String.valueOf(curCost + 1)});
                }
            }
        }
        
        return 0;
    }
    
    public boolean isOneDiff(String a, String b) {
        int diff = 0;
        
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        
        return diff == 1;
    }
}