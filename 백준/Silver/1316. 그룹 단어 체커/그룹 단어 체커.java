import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            
            boolean[] exist = new boolean[26];
            boolean isAnswer = true;
            
            for (int j=0; j<str.length(); j++) {
                int s = str.charAt(j) - 'a';
                
                if (exist[s] == true) {
                    if (s != str.charAt(j-1) - 'a') {
                        isAnswer = false;
                        break;
                    }
                } else {
                    exist[s] = true;
                }
                
            }
            
            if (isAnswer) {
                answer++;
            }
            
        }
        
        System.out.println(answer);
    }
}