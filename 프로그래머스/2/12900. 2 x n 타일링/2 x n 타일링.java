class Solution {
    public int solution(int n) {

        int floor[] = new int[n+1];

        floor[1] = 1;
        floor[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            floor[i] = (floor[i-1] + floor[i-2]) % 1000000007;
        }
        
        return floor[n];
    }
}