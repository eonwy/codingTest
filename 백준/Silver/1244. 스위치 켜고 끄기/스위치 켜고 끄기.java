import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        boolean[] switches = new boolean[n];
        
        int idx = 0;
        while (idx < n) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                switches[idx++] = st.nextToken().equals("1");
            }
        }

        int stu = Integer.parseInt(br.readLine());

        for (int i=0; i<stu; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken())-1;

            if (sex == 1) {
                for (int j = num; j < n; j += (num + 1)) {
                    switches[j] = !switches[j];
                }
            } else {
                int left = num;
                int right = num;

                while (left >= 0 && right < n && switches[left] == switches[right]) {
                    switches[left] = !switches[left];
                    switches[right] = !switches[right];
                    left--;
                    right++;
                }
                switches[num] = !switches[num];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(switches[i] ? "1 " : "0 ");
            if ((i + 1) % 20 == 0) System.out.println();
        }
    }
}