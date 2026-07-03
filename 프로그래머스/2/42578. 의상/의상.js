function solution(clothes) {
    var answer = 1;
    let map = new Map();
    
    for ([name, type] of clothes) {
        map.set(type, (map.get(type) || 0) + 1);
    }
    
    for ([type, cnt] of map) {
        answer *= (cnt + 1);
    }
    
    return answer - 1;
}