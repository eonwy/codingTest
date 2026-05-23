import java.util.*;

class Solution {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int[] solution(String[] maps) {

        int n = maps.length;
        int m = maps[0].length();

        boolean[][] visited = new boolean[n][m];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (maps[i].charAt(j) == 'X' || visited[i][j]) {
                    continue;
                }

                int sum = bfs(i, j, maps, visited);
                list.add(sum);
            }
        }

        if (list.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private int bfs(int x, int y, String[] maps, boolean[][] visited) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        visited[x][y] = true;

        int sum = maps[x].charAt(y) - '0';

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {

                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length()) {
                    continue;
                }

                if (visited[nx][ny] || maps[nx].charAt(ny) == 'X') {
                    continue;
                }

                visited[nx][ny] = true;

                sum += maps[nx].charAt(ny) - '0';

                q.offer(new int[]{nx, ny});
            }
        }

        return sum;
    }
}