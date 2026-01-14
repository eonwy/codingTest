import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            HashMap<Long, Integer> milMap = new HashMap<>();

            for (int j=0; j<t; j++) {
                long mil = Long.parseLong(st.nextToken());
                
                milMap.put(mil, milMap.getOrDefault(mil, 0) + 1);
            }

            double half = (double) t / 2;

            long answer = -1;

            for (long m : milMap.keySet()) {
                if (milMap.get(m) > half) {
                    answer = m;
                    break;
                }
            }

            System.out.println(answer == -1 ? "SYJKGW" : answer);
        }
    }
}