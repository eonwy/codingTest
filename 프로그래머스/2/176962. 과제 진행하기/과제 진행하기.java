import java.util.*;

class Solution {
    
    class HomeWork implements Comparable<HomeWork>{
        String name;
        int start, playtime;
        HomeWork(String name, int start, int playtime){
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
        
        @Override
        public int compareTo(HomeWork s){
            return this.start - s.start;
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int idx = 0;
        
        PriorityQueue<HomeWork> q = new PriorityQueue<>((o1, o2)->(o1.start-o2.start));
        for(String[] p:plans){
            q.add(new HomeWork(p[0], convertTime(p[1]), Integer.parseInt(p[2])));
        }

        HomeWork s = q.poll();
        int now = s.start;
        
        Stack<HomeWork> stack = new Stack<>(); //멈춘 과제들
        while(true){
            if(!q.isEmpty() && now+s.playtime > q.peek().start){
                //과제 중지
                stack.push(new HomeWork(s.name, s.start, s.playtime-(q.peek().start-now)));
                
                now = q.peek().start;
                
                s = q.poll(); //새로운 과제 시작
            }
            else{
                //과제 끝냄
                answer[idx++] = s.name;
                now += s.playtime;
                
                //새로 시작해야 하는 과제가 있다면 새로운 과제 시작
                if(!q.isEmpty() && now==q.peek().start){
                    s = q.poll();
                }
                else if(!stack.isEmpty()){
                    //멈춰둔 과제 다시 시작
                    s = stack.pop();
                }
                else if(!q.isEmpty()){
                    s = q.poll();
                    now = s.start;
                }
                else break;
            }
        }
        
        return answer;
    }
    
    public static int convertTime(String s) {
        String[] str = s.split(":");
        int time = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
        return time;
    }
}