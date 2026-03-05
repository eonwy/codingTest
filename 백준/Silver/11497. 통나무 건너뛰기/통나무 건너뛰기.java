import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] logs = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int max = 0;

            for (int z = 0; z < N; z++) {
                if (z % 2 == 0) {
                    logs[z / 2] = arr[z];
                } else {
                    logs[N - z / 2 - 1] = arr[z];
                }
            }

            for (int y = 1; y < N; y++) {
                max = Math.max(max, Math.abs(logs[y] - logs[y-1]));
            }
            max = Math.max(max, Math.abs(logs[0] - logs[N-1]));
            System.out.println(max);
        }
    }
}