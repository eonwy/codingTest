import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (tryPrev(arr)) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println("-1");
            return;
        }

    }

    public static boolean tryPrev(int[] arr) {
        int index = arr.length - 1;

        while(index > 0 && arr[index-1] <= arr[index]) {
            index--;
        }

        if (index == 0) {
            return false;
        }

        int changes = arr.length - 1;

        while(arr[index-1] <= arr[changes]) {
            changes--;
        }

        swap(index-1, changes);

        changes = arr.length - 1;

        while(index < changes) {
            swap(index, changes);
            index++;
            changes--;
        }
        return true;
    }

    public static void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


}