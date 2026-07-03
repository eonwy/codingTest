function solution(progresses, speeds) {
    let answer = [];
    let q = [];
    
    for (let i = 0; i < speeds.length; i++) {
        q.push(Math.ceil((100 - progresses[i]) / speeds[i]));
    }

    while(q.length) {
        const standard = q.shift();
        
        let cnt = 1;
        
        while(q.length && q[0] <= standard) {
            q.shift();
            cnt++;
        }
        
        answer.push(cnt);
    }
    
    return answer;
}