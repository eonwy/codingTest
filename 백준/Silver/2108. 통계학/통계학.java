import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        
        Arrays.sort(arr);
        
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : arr) {
            counts.put(i, counts.getOrDefault(i, 0) + 1);
        }
        
        int manyTime = Collections.max(counts.values());
        
        List<Integer> freqList = new ArrayList<>();
        for (int key : counts.keySet()) {
            if (counts.get(key) == manyTime) {
                freqList.add(key);
            }
        }
        
        Collections.sort(freqList);
        
        int freqNum = freqList.size() > 1 ? freqList.get(1) : freqList.get(0);
        
        System.out.println(Math.round((double) sum / N));
        System.out.println(arr[N/2]);
        System.out.println(freqNum);
        System.out.println(Math.abs(arr[0] - arr[N-1]));
    }
}