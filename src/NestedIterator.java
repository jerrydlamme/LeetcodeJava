import java.util.*;

interface NestedInteger {
	public boolean isInteger();
	
	public Integer getInteger();
	
	public List<NestedInteger> getList();
}
public class NestedIterator {
    List<NestedInteger> nestedList;
    int index;
    List<Integer> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        index = 0;
        list = new LinkedList<Integer>(); 
        flatten(nestedList);
    }
    
    private void flatten(List<NestedInteger> nestedList) {
        
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                list.add(ni.getInteger());
            } else {
                flatten(ni.getList());
            }
        }
    }

    public Integer next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }
}
