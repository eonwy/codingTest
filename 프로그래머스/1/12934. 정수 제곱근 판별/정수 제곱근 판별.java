class Solution {
    public long solution(long n) {
        
        double answer = Math.sqrt(n);
        
        return (answer == (int) answer) ? (long) Math.pow(answer+1, 2) : -1;
    }
}