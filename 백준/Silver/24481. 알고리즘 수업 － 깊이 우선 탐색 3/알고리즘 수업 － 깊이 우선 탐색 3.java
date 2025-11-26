import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] depth;
    
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
        
        for (int i=1; i<=N; i++) {
            Collections.sort(graph.get(i));
        }
        
        depth = new int[N+1];
        Arrays.fill(depth, -1);
        
        dfs(R, 0);
        
        for (int i=1; i<=N; i++) {
            System.out.println(depth[i]);
        }
    }
    
    public static void dfs(int R, int d) {
        depth[R] = d;
        
        for (int i=0; i<graph.get(R).size(); i++) {
            int newNode = graph.get(R).get(i);
            
            if (depth[newNode] == -1) {
                dfs(newNode, d+1);
            } 
        }
    }
}