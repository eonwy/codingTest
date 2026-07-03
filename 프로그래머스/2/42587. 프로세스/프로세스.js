function solution(priorities, location) {
    let q = priorities.map((priority, index) => ({index, priority}));
    
    let cnt = 0;
    
    while(q.length > 0) {
        let cur = q.shift();
        
        let hasHigherPriority = q.some(process => process.priority > cur.priority);
        
        if (hasHigherPriority) {
            q.push(cur);
        } else {
            cnt++;
            if (cur.index === location) {
                return cnt;
            }
        }
    }
}