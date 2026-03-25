import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static String[] words;
    static boolean[] visited = new boolean[26];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        if (K < 5) {
            System.out.println(max);
        } else {
            dfs(0, 0);
            System.out.println(max);
        }
    }

    public static void dfs(int index, int count) {
        if (count + 5 == K) {
            check();
            return;
        }

        for (int i = index; i < 26; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            dfs(i + 1, count + 1);
            visited[i] = false;
        }
    }

    public static void check() {
        int count = 0;

        for (String word : words) {
            boolean canRead = true;

            for (int i = 0; i < word.length(); i++) {
                if (!visited[word.charAt(i) - 'a']) {
                    canRead = false;
                    break;
                }
            }

            if (canRead) count++;
        }

        max = Math.max(max, count);
    }
}