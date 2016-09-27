import java.util.*;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> lists = new LinkedList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        int empties = 0;
        
        for(String str : strings) {
            if (str.length() == 0) {
                empties++;
                continue;
            }
            
            StringBuffer buffer = new StringBuffer();
            char first = (char)(str.charAt(0) - 'a');
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c - first >= 'a') {
                    buffer.append(c - first);
                } else {
                    buffer.append(c - first + 26);
                }
            }
            String opt = buffer.toString();
            
            if (map.containsKey(opt)) {
                map.get(opt).add(str);
            } else {
                List<String> list = new LinkedList<String>();
                lists.add(list);
                list.add(str);
                map.put(opt, list);
            }
        }
        
        if (empties > 0) {
            List<String> emp = new LinkedList<String>();
            emp.add("");
            lists.add(emp);
        }
        
        return lists;
    }
}
