import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    static int count = 1;
    static int[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        for (int i=0; i<=N; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }
        
        visited = new int[N+1];
        
        bfs(R);
        
        for (int i=1; i<=N; i++) {
            System.out.println(visited[i]);
        }
        
    }
    
    public static void bfs(int R) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(R);
        
        visited[R] = count;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for (int i=0; i<graph.get(cur).size(); i++) {
                int newNode = graph.get(cur).get(i);
                
                if (visited[newNode] != 0) {
                    continue;
                }
                
                q.offer(newNode);
                count++;
                visited[newNode] = count;
            }
        }
    }
}