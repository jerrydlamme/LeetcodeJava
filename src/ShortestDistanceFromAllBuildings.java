import java.util.*;

public class ShortestDistanceFromAllBuildings {

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        
        int min = Integer.MAX_VALUE;
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) num++;
            }
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int dis = bfs(grid, i, j, num);
                    if (dis == -1) continue;
                    min = Math.min(dis, min);
                }
            }
        }

        if (min == Integer.MAX_VALUE) return -1;        
        return min;
    }
    
    int bfs(int[][] grid, int i, int j, int num) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        queue.add(i);
        queue.add(j);
        int count = 1;
        int next = 0;
        int level = 1;
        int dis = 0;
        int reach = 0;
        
        while (!queue.isEmpty()) {
            i = queue.poll();
            j = queue.poll();
            
            count--;
            
            if (i-1 >= 0) {
                if (grid[i-1][j] == 0 && !visited[i-1][j]) {
                    queue.add(i-1);
                    queue.add(j);
                    next++;
                } else if (grid[i-1][j] == 1 && !visited[i-1][j]) {
                    dis += level;
                    reach++;
                }
                visited[i-1][j] = true;
            }
            
            if (j-1 >= 0) {
                if (grid[i][j-1] == 0 && !visited[i][j-1]) {
                    queue.add(i); 
                    queue.add(j-1);
                    next++;
                } else if (grid[i][j-1] == 1 && !visited[i][j-1]) {
                    dis += level;
                    reach++;
                }
                visited[i][j-1] = true;
            }
            
            if (i+1 < grid.length) {
                if (grid[i+1][j] == 0 && !visited[i+1][j]) {
                    queue.add(i+1);
                    queue.add(j);
                    next++;
                } else if (grid[i+1][j] == 1 && !visited[i+1][j]) {
                    dis += level;
                    reach++;
                }
                visited[i+1][j] = true;
            }
            
            if (j+1 < grid[0].length) {
                if (grid[i][j+1] == 0 && !visited[i][j+1]) {
                    queue.add(i);
                    queue.add(j+1);
                    next++;
                } else if (grid[i][j+1] == 1 && !visited[i][j+1]) {
                    dis += level;
                    reach++;
                }
                visited[i][j+1] = true;
            }
            
            if (count == 0) {
                level++;
                count = next;
                next = 0;
            }
        }
    
        if (reach < num) return -1;
        
        return dis;
    }
}
