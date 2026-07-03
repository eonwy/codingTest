function solution(arr) {
    const s = [];
    
    for (a of arr) {
        if (s.length > 0 && s[s.length - 1] == a) continue;
        s.push(a);
    }
    
    return s;
}