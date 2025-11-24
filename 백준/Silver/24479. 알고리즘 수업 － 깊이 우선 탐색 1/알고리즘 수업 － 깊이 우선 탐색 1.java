import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    static int cnt;
    static int[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        for (int i = 1; i <=N; i++) {
            Collections.sort(graph.get(i));
        }
        
        cnt = 1;
        visited = new int[N+1];
        
        dfs(R);
        
        for (int i=1; i<=N; i++) {
            System.out.println(visited[i]);
        }
    }
    
    public static void dfs(int R) {
        visited[R] = cnt;
        
        for (int i=0; i<graph.get(R).size(); i++) {
            int newNode = graph.get(R).get(i);
            
            if (visited[newNode] == 0) {
                cnt++;
                dfs(newNode);
            }
        }
    }
}