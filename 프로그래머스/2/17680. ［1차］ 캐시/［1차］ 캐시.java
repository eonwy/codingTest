import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 5;
        List<String> caches = new ArrayList<>();
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        caches.add(cities[0].toLowerCase());
        
        for (int i=1; i<cities.length; i++) {
            String city = cities[i].toLowerCase();
            
            if (caches.contains(city)) {
                answer += 1;
                caches.remove(city);
            } else {
                if (caches.size() == cacheSize) {
                    caches.remove(0);
                }
                answer += 5;
            }
            
            caches.add(city);
        }
        System.out.println(caches);
        
        return answer;
    }
}