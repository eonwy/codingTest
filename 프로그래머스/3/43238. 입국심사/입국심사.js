function solution(n, times) { 
    times.sort((a, b) => a - b);
    
    let left = 1;
    let right = times[times.length - 1] * n;
    let answer = right;
    
    while(left <= right) {
        let mid = Math.floor((left + right) / 2);
        let count = 0;
        
        for (let i = 0; i < times.length; i++) {
            count += Math.floor(mid / times[i]);
        }
        
        if (count >= n) {
            answer = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    
    return answer;
}