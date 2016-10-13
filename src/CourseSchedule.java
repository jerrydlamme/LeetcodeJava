import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
	    int n = numCourses;
	    List<Integer>[] lists = new List[n];
	    boolean sink = false;
	    int[] visited = new int[n];
	    
	    for (int i = 0; i < n; i++) {
	        lists[i] = new LinkedList<Integer>();
	    }
	    
	    for (int i = 0; i < prerequisites.length; i++) {
	        if (prerequisites[i][0] == prerequisites[i][1]) return false;
	        lists[prerequisites[i][1]].add(prerequisites[i][0]);
	    }
	    
	    for (int i = 0; i < n; i++) {
	        if (lists[i].size() == 0) sink = true;
	    }
	    if (!sink) return false;
	            
	    for (int i = 0; i < n; i++) {
	        if (visited[i] == 0 && !dfs(lists, i, visited)) return false;
	    }
	    
	    return true;
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
	    
	    return true;
	}
}