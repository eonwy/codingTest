let answer = 0;

function solution(numbers, target) {
    answer = 0;
    
    dfs(numbers, target, 0, 0);
    
    return answer;
}

function dfs(numbers, target, depth, result) {
    if (depth === numbers.length) {
        if (result === target) {
            answer++;
        }
        return;
    }
    
    dfs(numbers, target, depth+1, result+numbers[depth]);
    dfs(numbers, target, depth+1, result-numbers[depth]);
}