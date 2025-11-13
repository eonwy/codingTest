import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> arr = new Stack<>();
        
        for (int i=0; i<K; i++) {
            int n = Integer.parseInt(br.readLine());
            
            if (n == 0) {
                arr.pop();
            } else {
                arr.push(n);
            }
        }
        
        int answer = 0;
        
        while(!arr.isEmpty()) {
            answer += arr.pop();
        }
        
        System.out.println(answer);
    }
}