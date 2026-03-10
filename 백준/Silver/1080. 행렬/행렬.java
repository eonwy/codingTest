import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] A;
    static boolean[][] B;

    public static boolean isSame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void changeArr(int r, int c) {
        if (r + 3 > N || c + 3 > M) {
            return;
        }
        
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                A[i][j] = !A[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new boolean[N][M];
        B = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++) {
                A[i][j] = (s.charAt(j) - '0' == 0) ? false : true;
            }
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++) {
                B[i][j] = (s.charAt(j) - '0' == 0) ? false : true;
            }
        }

        if (N < 3 && M < 3) {
            if (isSame()) {
                System.out.println("0");
            } else {
                System.out.println("-1");
            }
            return;
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    changeArr(i, j);
                    answer++;
                }
            }
        }

        if (isSame()) {
            System.out.println(answer);
        } else {
            System.out.println("-1");
        }
    }
}