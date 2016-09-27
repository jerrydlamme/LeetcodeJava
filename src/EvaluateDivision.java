import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    	Map<String, Map<String, Double>> maps = new HashMap<String, Map<String, Double>>();
    	double[] res = new double[queries.length];
    	
    	for (int i = 0; i < equations.length; i++) {
    		String[] pair = equations[i];
    		insert(maps, pair[0], pair[1], values[i]);
    		insert(maps, pair[1], pair[0], 1.0/values[i]);
    	}
    	
    	System.out.println(maps);
    	
    	for (int i = 0; i < queries.length; i++) {
    	    if (queries[i][0].equals(queries[i][1])) {
    	        if (maps.containsKey(queries[i][0])) {
    	            res[i] = 1.0;
    	        } else {
    	            res[i] = -1.0;
    	        }
    	        continue;
    	    }
    	    
    	    if (!maps.containsKey(queries[i][0])) {
    	        res[i] = -1.0;
    	    } else {
    	        Map<String, Double> map = maps.get(queries[i][0]);
    	        Set<String> set = new HashSet<String>();
    	        set.add(queries[i][0]);
    	        if (!dfs(set, i, queries[i][1], res, map, maps, 1.0)) res[i] = -1;
    	    }
    	}
    	
    	return res;
    }
    
    boolean dfs (Set<String> set, int index, String a, double[] res, Map<String, Double> map, Map<String, Map<String, Double>> maps, double last) {
    	System.out.println("mark");
        if (map.containsKey(a)) {
            res[index] = last * map.get(a);
            return true;
        } else {
            for (String key : map.keySet()) {
                if (maps.containsKey(key) && !set.contains(key)) {
                	set.add(key);
                    if (dfs(set, index, a, res, maps.get(key), maps, last * map.get(key))) return true;
                }
            }
            return false;
        }
    }
    
    
    void insert(Map<String, Map<String, Double>> maps, String a, String b, double value) {
    	Map<String, Double> mapA = null, mapB = null, mapC = null;
    	
    	if (maps.containsKey(a)) {
    		mapA = maps.get(a);
    	} else {
    		mapA = new HashMap<String, Double>();
    		maps.put(a, mapA);
    	}
    	mapA.put(b, value);
    }
    
    public static void main(String[] args) {
    	EvaluateDivision ins = new EvaluateDivision();
    	
    	String[][] eq = new String[2][2];
    	eq[0][0] = "a";
    	eq[0][1] = "b";
    	eq[1][0] = "b";
    	eq[1][1] = "c";
    	
    	double[] values = new double[2];
    	values[0] = 2.0;
    	values[1] = 3.0;
    	
    	String[][] queries = new String[5][2];
    	queries[0][0] = "a";
    	queries[0][1] = "c";
    	queries[1][0] = "b";
    	queries[1][1] = "c";
    	queries[2][0] = "a";
    	queries[2][1] = "e";
    	queries[3][0] = "a";
    	queries[3][1] = "a";
    	queries[4][0] = "x";
    	queries[4][1] = "x";
    	
    	ins.calcEquation(eq, values, queries);
    	
    	
    	
    	
    	
    	
    }
}
