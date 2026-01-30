import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
         
        Arrays.sort(arr, (b, a) -> (a + b).compareTo(b + a));
        
        if (arr[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}