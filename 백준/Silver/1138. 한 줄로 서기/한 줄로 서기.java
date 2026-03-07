import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int cnt = Integer.parseInt(st.nextToken());

            int count = 0;

            for (int j = 0; j < N; j++) {
                if (!visited[j]) {
                    if (count == cnt) {
                        arr[j] = i + 1;
                        visited[j] = true;
                        break;
                    }
                    count++;
                }
            }
        }

        for (int i = 0; i < N - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[N-1]);
    }
}