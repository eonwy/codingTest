import java.io.*;
import java.util.*;

public class Main {
    static int[] arrA;
    static int[] arrB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arrA = new int[A];
            arrB = new int[B];

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<A; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<B; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrA);
            Arrays.sort(arrB);

            int count = 0;
            
            for (int i=0; i<A; i++) {
                int a = arrA[i];

                int left = 0;
                int right = arrB.length;

                while(left < right) {
                    int mid = (left + right) / 2;

                    if (arrB[mid] < a) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                count += left;
            }

            System.out.println(count);

        }
    }
}