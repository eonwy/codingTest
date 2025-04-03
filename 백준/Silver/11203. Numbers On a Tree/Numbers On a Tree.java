import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int height = sc.nextInt();
        String direction = sc.hasNext() ? sc.next() : "";
        
        long top = (long) Math.pow(2, height+1) - 1;
        int index = 1;
        
        if (direction.length() > 0) {
            for (char dir : direction.toCharArray()) {
                if (dir == 'L') {
                    index *= 2;
                } else if (dir == 'R') {
                    index = index * 2 + 1;
                }
            }  
        }   
        
        System.out.println(top - index + 1);
        sc.close();
    }
}