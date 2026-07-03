function solution(progresses, speeds) {
    let answer = [];
    let days = [];
    
    for (let i = 0; i < speeds.length; i++) {
        days.push(Math.ceil((100 - progresses[i]) / speeds[i]));
    }
    
    let max = days[0];
    let cnt = 1;
    
    for (let i = 1; i < days.length; i++) {
        if (days[i] <= max) {
            cnt++;
        } else {
            max = days[i];
            answer.push(cnt);
            cnt = 1;
        }
    }
    
    answer.push(cnt);
    
    return answer;
}