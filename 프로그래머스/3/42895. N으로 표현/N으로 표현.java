import java.util.*;

class Solution {
    public int solution(int N, int number) {        
        List<Set<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            arr.add(new HashSet<>());
        }
        
        for (int i = 1; i <= 8; i++) {
            arr.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            for (int j = 1; j < i; j++) {
                for (int one : arr.get(j)) {
                    for (int two : arr.get(i - j)) {
                        arr.get(i).add(one + two);
                        arr.get(i).add(one - two);
                        arr.get(i).add(one * two);
                        if (two != 0) arr.get(i).add(one / two);
                    }
                }
            }
            
            if (arr.get(i).contains(number)) return i;
        }
        
        return -1;
    }
}