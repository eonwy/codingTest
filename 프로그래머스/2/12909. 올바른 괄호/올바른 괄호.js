function solution(s){
    let stack = [];
    stack.push(s[0]);
    
    for (let i = 1; i < s.length; i++) {
        if (stack[stack.length - 1] === '(' && s[i] === ')') {
            stack.pop();
            continue;
        }
        if (s[i] === '(') {
            stack.push(s[i]);
            continue;
        }
    }
    
    console.log(stack);
    
    return stack.length > 0 ? false : true;
}