import java.util.*;

class Solution {
    static int row, col;
    static int leverCost, exitCost;
    static int startRow, startCol, leverRow, leverCol, exitRow, exitCol;
    static int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    
    public int solution(String[] maps) {
        row = maps.length;
        col = maps[0].length();
        
        boolean[][] leverVisited = new boolean[row][col];
        boolean[][] exitVisited = new boolean[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (maps[i].charAt(j) == 'S') {
                    startRow = i;
                    startCol = j;
                    leverVisited[i][j] = false;
                    exitVisited[i][j] = false;
                } else if (maps[i].charAt(j) == 'L') {
                    leverRow = i;
                    leverCol = j;
                    leverVisited[i][j] = false;
                    exitVisited[i][j] = false;
                } else if (maps[i].charAt(j) == 'E') {
                    exitRow = i;
                    exitCol = j;
                    leverVisited[i][j] = false;
                    exitVisited[i][j] = false;
                } else if (maps[i].charAt(j) == 'O') {
                    leverVisited[i][j] = false;
                    exitVisited[i][j] = false;
                } else {
                    leverVisited[i][j] = true;
                    exitVisited[i][j] = true;
                }
            }
        }
        
        // 레버까지 최소 거리로 가기
        PriorityQueue<int[]> leverPQ = new PriorityQueue<>(
            (a, b) -> a[2] - b[2]
        );
        leverPQ.add(new int[]{startRow, startCol, 0});
        leverVisited[startRow][startCol] = true;
        
        while(!leverPQ.isEmpty()) {
            int[] cur = leverPQ.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int curCost = cur[2];
            
            if (curRow == leverRow && curCol == leverCol) {
                leverCost = curCost;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int newRow = curRow + directions[i][0];
                int newCol = curCol + directions[i][1];
                
                if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col) {
                    if (maps[newRow].charAt(newCol) != 'X' && !leverVisited[newRow][newCol]) {
                        leverVisited[newRow][newCol] = true;
                        leverPQ.add(new int[]{newRow, newCol, curCost + 1});
                    }
                }
            }
        }
        
        if ((startRow != leverRow || startCol != leverCol) && leverCost == 0) {
            return -1;
        }
        
        // 출구까지 최소 거리로 가기
        PriorityQueue<int[]> exitPQ = new PriorityQueue<>(
            (a, b) -> a[2] - b[2]
        );
        exitPQ.add(new int[]{leverRow, leverCol, leverCost});
        exitVisited[leverRow][leverCol] = true;
        
        while(!exitPQ.isEmpty()) {
            int[] cur = exitPQ.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int curCost = cur[2];
            
            if (curRow == exitRow && curCol == exitCol) {
                exitCost = curCost;
                return exitCost;
            }
            
            for (int i = 0; i < 4; i++) {
                int newRow = curRow + directions[i][0];
                int newCol = curCol + directions[i][1];
                
                if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col) {
                    if (maps[newRow].charAt(newCol) != 'X' && !exitVisited[newRow][newCol]) {
                        exitVisited[newRow][newCol] = true;
                        exitPQ.add(new int[]{newRow, newCol, curCost + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}