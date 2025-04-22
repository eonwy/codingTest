import java.util.*;

class Solution {
    public int[] solution(String s) {        
        s = s.replaceAll("\\{", "");
        s = s.replaceAll("\\}", "");
        String[] arr = s.split(",");
        
        Map<String, Integer> pair = new HashMap<>();
        for (String a : arr) {
            pair.put(a, pair.getOrDefault(a, 0) + 1);
        }
        
        List<Integer> answer = new ArrayList<>();
        int k = pair.size();
        for (int i = 0; i < pair.size(); i++) {
            for (String key : pair.keySet()) {
                if (pair.get(key) == k) {
                    answer.add(Integer.parseInt(key));
                    k--;
                }
            }
        }
            
        return answer.stream().mapToInt(i->i).toArray();
    }
}