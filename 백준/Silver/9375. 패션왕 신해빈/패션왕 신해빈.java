import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            int clothes = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int j=0; j<clothes; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String type = st.nextToken();

                map.put(type, map.getOrDefault(type, 0) + 1);
            }
            
            int answer = 1;
            for (String s : map.keySet()) {
                answer *= map.get(s) + 1;
            }
            System.out.println(answer - 1);
        }
        
    }
}