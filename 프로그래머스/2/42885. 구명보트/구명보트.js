function solution(people, limit) {
    let count = 0;
    let low = 0;
    let high = people.length - 1;
    
    people.sort((a, b) => a - b);
    
    while(low <= high) {
        if (people[low] + people[high] <= limit) {
            low++;
        }
        high--;
        count++;
    }
    
    return count;
}