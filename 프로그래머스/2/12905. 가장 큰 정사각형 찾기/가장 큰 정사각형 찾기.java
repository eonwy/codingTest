class Solution { 
    public int solution(int [][]board) {        
        int row = board.length;
        int col = board[0].length;
        
        int[][] dp = new int[row][col];
        
        int max = 0;
        
        for (int i = 0; i < row; i++) {
            dp[i][0] = board[i][0];
            max = Math.max(dp[i][0], max);
        } 
        
        for (int i = 0; i < col; i++) {
            dp[0][i] = board[0][i];
            max = Math.max(dp[0][i], max);
        } 
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                }
                
                max = Math.max(dp[i][j], max);
            }
        }
        

        return max * max;
    }
}