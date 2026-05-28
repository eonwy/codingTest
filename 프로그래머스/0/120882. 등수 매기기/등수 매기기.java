class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        double[] mid = new double[score.length];
        
        for(int i=0; i<score.length; i++){
            mid[i] = (double)(score[i][0] + score[i][1]) / 2;
        }

        for(int i=0; i<mid.length; i++){
            int num = 1;
            for(int j=0; j<mid.length; j++){
                if(mid[i] < mid[j]){
                    num++;
                }
            }
            answer[i] = num;
        }
        
        return answer;
    }
}