function solution(phone_book) {
    let hash = new Map();
    
    for (pb of phone_book) {
        hash.set(pb, 1);
    }
    
    for (phoneNumber of phone_book) {
        let temp = "";
        
        for (num of phoneNumber) {
            temp += num;
            
            if (hash.get(temp) == 1 && temp != phoneNumber) {
                return false;
            }
        }
    }
    
    return true;
}