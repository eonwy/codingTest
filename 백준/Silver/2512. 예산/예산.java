import java.io.*;
import java.util.*;

public class Main {
    static int region, budget;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        region = Integer.parseInt(br.readLine());
        arr = new int[region];
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < region; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        budget = Integer.parseInt(br.readLine());

        int start = 0;
        int end = max;

        int answer = paramatric_search(start, end);

        System.out.println(answer);
    }

    public static int paramatric_search(int start, int end) {
        int mid = 0;

        while(start <= end) {
            int sum = 0;
            mid = (start + end) / 2;

            for (int i = 0; i < region; i++) {
                sum += (arr[i] >= mid) ? mid : arr[i];
            }

            if (sum > budget) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}