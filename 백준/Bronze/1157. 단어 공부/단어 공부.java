import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> arr = new HashMap<>();
        
        String s = br.readLine().toUpperCase();
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            arr.put(c, arr.getOrDefault(c, 0) + 1);
        }
        
        int max = 0;
        char answer = '?';
        boolean duplicate = false;
        
        for (char key : arr.keySet()) {
            int freq = arr.get(key);

            if (freq > max) {
                max = freq;
                answer = key;
                duplicate = false;
            } else if (freq == max) {
                duplicate = true;
            }
        }
        
        System.out.println(duplicate ? '?' : answer);
        
    }
}