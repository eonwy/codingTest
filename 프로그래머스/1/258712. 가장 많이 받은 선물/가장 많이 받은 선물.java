import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int len = friends.length;
        HashMap<String, Integer> dic = new HashMap<>();
        int[] giftDegree = new int[len];
        int[][] giftHistory = new int[len][len];
        
        for (int i = 0; i < len; i++) {
            dic.put(friends[i], i);
        }
        
        for (String g : gifts) {
            String[] giveAndTake = g.split(" ");
            giftDegree[dic.get(giveAndTake[0])]++;
            giftDegree[dic.get(giveAndTake[1])]--;
            giftHistory[dic.get(giveAndTake[0])][dic.get(giveAndTake[1])]++;
        }
        
        for (int i = 0; i < len; i++) {
            int cnt = 0;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                
                if (giftHistory[i][j] > giftHistory[j][i]) {
                    cnt++;
                } else if (giftHistory[i][j] == giftHistory[j][i] && giftDegree[i] > giftDegree[j]) {
                    cnt++;
                }
            }
            
            if (answer < cnt) {
                answer = cnt;
            }
        }
        
        return answer;
    }
}