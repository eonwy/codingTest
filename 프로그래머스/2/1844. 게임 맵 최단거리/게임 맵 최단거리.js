function solution(maps) {
    var n = maps.length;
    var m = maps[0].length;
    var direction = [[-1, 0], [1, 0], [0, -1], [0, 1]];
    
    var bfs = () => {
        var queue = [[0, 0, 1]];
        maps[0][0] = 0;
        
        while (queue.length > 0) {
            var [row, col, distance] = queue.shift();
            
            if (row == n - 1 && col == m - 1) {
                return distance;
            }
            
            for (var [r, c] of direction) {
                var newRow = row + r;
                var newCol = col + c;
                
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && maps[newRow][newCol] === 1) {
                    queue.push([newRow, newCol, distance + 1]);
                    maps[newRow][newCol] = 0;
                }
            }   
        }
        return -1;
    };
    
    return bfs();
}