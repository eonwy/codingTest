function solution(n, computers) {
    let answer = 0;
    const visited = [];
    
    for (let i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(i, visited, computers);
            answer++;
        }
    }
    
    return answer;
}

const dfs = (node, visited, computers) => {
    visited[node] = true;
    for (let i = 0; i < computers.length; i++) {
        if (computers[node][i] === 1 && !visited[i]) {
            dfs(i, visited, computers);
        }
    }
}