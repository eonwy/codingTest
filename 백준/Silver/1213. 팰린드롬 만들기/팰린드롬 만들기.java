import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'A']++;
        }

        int odd = 0;
        int oddIndex = -1;
        for (int i=0; i<26; i++) {
            if (count[i] % 2 != 0) {
                odd++;
                oddIndex = i;
            }
        }

        if (odd > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        for (int i=0; i<26; i++) {
            for (int j=0; j<count[i]/2; j++) {
                left.append((char)(i + 'A'));
            }
        }

        right.append(left).reverse();

        if (odd == 1) {
            left.append((char)(oddIndex + 'A'));
        }

        System.out.println(left.toString() + right.toString());

    }
}