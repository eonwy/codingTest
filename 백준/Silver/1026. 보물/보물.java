import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];
        boolean[] visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        for (int i = 0; i < N; i++) {
            int max = -1;
            int idx = -1;

            for (int j = 0; j < N; j++) {
                if (!visited[j] && B[j] > max) {
                    max = B[j];
                    idx = j;
                }
            }

            answer += A[i] * B[idx];
            visited[idx] = true;
        }

        System.out.println(answer);
    }
}