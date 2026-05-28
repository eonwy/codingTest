import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        ArrayList<Integer> mean = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int[] s : score) {
            mean.add(s[0] + s[1]);
        }
        Collections.sort(mean, Collections.reverseOrder());
        
        for (int i = 0; i < score.length; i++) {
            answer.add(mean.indexOf(score[i][0] + score[i][1]) + 1);
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}