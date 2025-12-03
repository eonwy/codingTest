class Solution {
    public int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int depth, int result) {
        if (depth == numbers.length) {
            if (result == target) {
                answer++;
            }
            return;
        }
        
        dfs(numbers, target, depth+1, result+numbers[depth]);
        dfs(numbers, target, depth+1, result-numbers[depth]);
    }
}