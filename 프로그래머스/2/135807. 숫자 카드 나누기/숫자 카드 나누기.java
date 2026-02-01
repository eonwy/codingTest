import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = getAllGCD(arrayA);
        int gcdB = getAllGCD(arrayB);
        
        int checkA = check(gcdA, arrayB);
        int checkB = check(gcdB, arrayA);
        
        return Math.max(checkA, checkB);
    }
    
    private int check(int gcd, int[] array) {
        for (int a : array) {
            if (a % gcd == 0) return 0;
        }
        
        return gcd;
    }
    
    public int getAllGCD(int[] array) {
        int g = array[0];
        
        for (int i = 1; i < array.length; i++) {
            g = getGCD(g, array[i]); 
        }
        
        return g;
    }
    
    public int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
}