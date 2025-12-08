import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> arr = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            arr.offer(i);
        }
        
        StringBuilder answer = new StringBuilder();
        answer.append("<");
        
        while(arr.size() > 1) {
            for (int i=0; i<K-1; i++) {
                arr.offer(arr.poll());
            }
            answer.append(arr.poll()).append(", ");
        }

        answer.append(arr.poll()).append(">");
        
        System.out.println(answer);
    }
}