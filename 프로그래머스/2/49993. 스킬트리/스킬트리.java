class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            String s = skill_trees[i];
            
            boolean isSkill = true;
            
            for (int j = 0; j < skill.length() - 1; j++) {
                int curIndex = s.indexOf(skill.charAt(j));
                int nextIndex = s.indexOf(skill.charAt(j+1));
                
                if (curIndex == -1 && nextIndex >= 0) {
                    isSkill = false;
                    break;
                }
                
                if (nextIndex == -1) {
                    continue;
                }
                
                if(curIndex > nextIndex) {
                    isSkill = false;
                    break;
                }
            }
            
            if (isSkill) answer++;
        }
        
        return answer;
    }
}