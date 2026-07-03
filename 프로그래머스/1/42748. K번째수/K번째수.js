function solution(array, commands) {
    var answer = [];
    
    for ([i, j, k] of commands) {
        let temp = array.slice(i-1, j);
        
        temp.sort((a, b) => a - b);
        
        answer.push(temp[k - 1]);
    }
    
    return answer;
}