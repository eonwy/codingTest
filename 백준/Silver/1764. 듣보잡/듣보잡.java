import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> names = new HashMap<>();

        for (int i=0; i<N+M; i++) {
            String s = br.readLine();

            names.put(s, names.getOrDefault(s, 0) + 1);
        }

        int cnt = 0;
        List<String> arr = new ArrayList<>();

        for (String s : names.keySet()) {
            if (names.get(s) > 1) {
                cnt++;
                arr.add(s);
            }
        }

        System.out.println(cnt);
        Collections.sort(arr);
        
        for (int i=0; i<arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}