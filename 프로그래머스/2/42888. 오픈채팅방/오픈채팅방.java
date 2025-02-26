import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> names = new HashMap<>();
        
        for (int i = 0; i < record.length; i++) {
            String state = record[i].split(" ")[0];
            String uuid = record[i].split(" ")[1];
            
            if (!state.equals("Leave")) {
                String name = record[i].split(" ")[2];
                names.put(uuid, name);
            }
        }
        
        for (int i = 0; i < record.length; i++) {
            String state = record[i].split(" ")[0];
            String uuid = record[i].split(" ")[1];
            String name = names.get(uuid);
            
            if (state.equals("Enter")) {
                answer.add(name + "님이 들어왔습니다.");
            } else if (state.equals("Leave")) {
                answer.add(name + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[0]);
    }
}