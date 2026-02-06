class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();

        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        int move = len - 1;

        for (int i = 0; i < len; i++) {
            int next = i + 1;

            // 연속된 A 스킵
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move, i * 2 + (len - next));
            move = Math.min(move, (len - next) * 2 + i);
        }

        answer += move;
        return answer;
    }
}
