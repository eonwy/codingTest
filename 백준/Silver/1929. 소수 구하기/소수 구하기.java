import java.io.*;
import java.util.*;

public class Main {
    
    public static boolean[] sosu;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        sosu = new boolean[n+1];
        
        get_sosu(m, n);
    }
    
    public static void get_sosu(int m, int n) {
        
        // true = 소수아님, false = 소수
        sosu[0] = sosu[1] = true;
        
        for (int i=2; i*i<=n; i++) {
            if (sosu[i]) continue;
            for (int j=i*i; j<=n; j+=i) {
                sosu[j] = true;
            }
        }
        
        for (int i=m; i<=n; i++) {
            if (!sosu[i]) System.out.println(i);
        }
    }
}