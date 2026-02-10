import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int has = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = N-1;
            boolean available = false;

            while(left <= right) {
                int mid = (left + right) / 2;

                if (cards[mid] == has) {
                    available = true;
                    break;
                } else {
                    if (cards[mid] >= has) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }

            System.out.println(available ? 1 : 0);
        }
    }
}