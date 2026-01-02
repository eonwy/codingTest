import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = (int) ((long) y * 100 / x);

        int left = 0;
        int right = (int) 1e9;
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int newZ = (int) ((long) (y + mid) * 100 / (x + mid));

            if (newZ != z) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}