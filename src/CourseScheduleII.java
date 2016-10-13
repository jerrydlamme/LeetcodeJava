import java.util.*;

public class CourseScheduleII {
    int count;
    int[] res;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<Integer>[] lists = new List[n];
        count = n-1;
        res = new int[n];

        int[] visited = new int[n];
        
        for (int i = 0; i < n; i++) {
            lists[i] = new LinkedList<Integer>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][0] == prerequisites[i][1]) return new int[0];
            lists[prerequisites[i][1]].add(prerequisites[i][0]);
        }
                
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && !dfs(lists, i, visited)) return new int[0];
        }
        
        return res;
    }
    
    boolean dfs(List<Integer>[] lists, int cur, int[] visited) {
        List<Integer> list = lists[cur];
        visited[cur] = 1;
        
        for (Integer i : list) {
            int next = i;
            if (visited[next] == 1) return false;
            if (visited[next] == 0 && !dfs(lists, next, visited)) return false;
        }
        visited[cur] = 2;
        res[count--] = cur;
        
        
        return true;
    }
}
