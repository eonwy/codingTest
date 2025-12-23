import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<String> arr = new ArrayList<>();
        ArrayList<HashMap<Character, Integer>> dnas = new ArrayList<>();

        // 배열 만들기
        for (int i=0; i<m; i++) {
            dnas.add(new HashMap<>());
        }

        // 각 자릿수별로 어떤 뉴클레오타드가 제일 많은지 확인
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String dna = st.nextToken();

            arr.add(dna);

            for (int j=0; j<m; j++) {
                char c = dna.charAt(j);
                dnas.get(j).put(c, dnas.get(j).getOrDefault(c, 0) + 1);
            }
        }

        char[] order = {'A', 'C', 'G', 'T'};
        StringBuilder sb = new StringBuilder();
        int distance = 0;

        for (int i = 0; i < m; i++) {
            HashMap<Character, Integer> map = dnas.get(i);

            char bestChar = 'A';
            int maxCount = -1;

            for (char c : order) {
                int cnt = map.getOrDefault(c, 0);

                if (cnt > maxCount) {
                    maxCount = cnt;
                    bestChar = c;
                }
            }

            sb.append(bestChar);
            distance += n - maxCount;
        }

        int hd = 0;
        for (int i=0; i<n; i++) {
            String s = arr.get(i);
            for (int j=0; j<m; j++) {

                if (s.charAt(j) != sb.charAt(j)) {
                    hd++;
                }
            }
        }

        System.out.println(sb);
        System.out.println(hd);
    }
}