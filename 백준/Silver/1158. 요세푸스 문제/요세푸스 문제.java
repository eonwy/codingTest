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
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        while(arr.size() > 1) {
            for (int i=0; i<K-1; i++) {
                arr.offer(arr.poll());
            }
            sb.append(arr.poll()).append(", ");
        }
        sb.append(arr.poll()).append(">");
        
        System.out.println(sb);
        
    }
}