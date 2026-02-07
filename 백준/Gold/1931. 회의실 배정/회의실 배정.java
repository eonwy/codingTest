import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        MeetingRoom[] arr = new MeetingRoom[n]; 
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            arr[i] = new MeetingRoom(startTime, endTime);
        }
        
        Arrays.sort(arr); 
        int count = 0;
        int time = 0; 
        
        for (int i = 0; i < n; i++) {
            if (time <= arr[i].startTime) {  
                count++;
                time = arr[i].endTime;
            }
        }
        System.out.print(count);
    }

    static class MeetingRoom implements Comparable<MeetingRoom> { 
        int startTime;
        int endTime;

        public MeetingRoom(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(MeetingRoom o) {
            if (endTime == o.endTime) return startTime - o.startTime;
            return endTime - o.endTime;
        }
    }
}
 