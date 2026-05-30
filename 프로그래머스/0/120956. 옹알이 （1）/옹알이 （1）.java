class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] bab = {"aya", "ye", "woo", "ma"};
        
        for (String b : babbling) {
            for (int i = 0; i < 4; i++) {
                if (b.contains(bab[i])) {
                    b = b.replace(bab[i], " ");
                }
            }
            
            if (b.trim().isEmpty()) answer++;
        }
        
        return answer;
    }
}