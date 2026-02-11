import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ingredient = new int[N];

        for (int i = 0; i < N; i++) {
            ingredient[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ingredient);

        int front = 0;
        int back = N - 1;
        int sum = 0;
        int count = 0;

        while (front < back) {
            sum = ingredient[front] + ingredient[back];

            if (sum == M) {
                front++;
                back--;
                count++;
            } else if (sum < M) {
                front++;
            } else {
                back--;
            }
        }

        System.out.println(count);
    }
}