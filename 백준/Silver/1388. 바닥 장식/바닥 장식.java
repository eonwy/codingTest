import java.io.*;
import java.util.*;

public class Main {
    public static int row, col;
    public static char[][] floor;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        floor = new char[row][col];
        visited = new boolean[row][col];

        for (int i=0; i<row; i++) {
            String s = br.readLine();
            for (int j=0; j<col; j++) {
                floor[i][j] = s.charAt(j);
            }
        }

        int cnt = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (!visited[i][j]) {
                    decorate(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void decorate(int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col) return;
        if (visited[i][j]) return;

        visited[i][j] = true;

        if (floor[i][j] == '-') {
            if (j + 1 < col && floor[i][j + 1] == '-') {
                decorate(i, j + 1);
            }
        } else {
            if (i + 1 < row && floor[i + 1][j] == '|') {
                decorate(i + 1, j);
            }
        }
    }
}