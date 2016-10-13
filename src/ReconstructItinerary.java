import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        
        for (String[] ticket : tickets) {
            if (map.containsKey(ticket[0])) {
                map.get(ticket[0]).add(ticket[1]);
            } else {
                PriorityQueue<String> heap = new PriorityQueue<String>();
                heap.offer(ticket[1]);
                map.put(ticket[0], heap);
            }
        }
        
        List<String> journey = new LinkedList<String>();
        
        visit("JFK", journey, map);
        
        return journey;
    }
    
    void visit(String from, List<String> journey, Map<String, PriorityQueue<String>> map) {
        PriorityQueue<String> heap = map.get(from);

        while (heap != null && !heap.isEmpty()) {
            String to = heap.poll();
            visit(to, journey, map);
        }        
        journey.add(0, from);
    }
}
