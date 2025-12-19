import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] arr = new int[r][c];

        for (int i=0; i<r; i++) {
            String s = br.readLine();
            for (int j=0; j<c; j++) {
                arr[i][j] = Integer.parseInt(s.substring(j, j+1));
            }
        }

        int len = Math.min(r, c);
        while(len > 1) {
            for (int i=0; i<=r-len; i++) {
                for (int j=0; j<=c-len; j++) {
                    int peak = arr[i][j];

                    if (peak == arr[i][j+len-1] && peak == arr[i+len-1][j] && peak == arr[i+len-1][j+len-1]) {
                        System.out.println(len*len);
                        return;
                    }
                }
            }

            len--;
        }

        System.out.println(len*len);
    }
}