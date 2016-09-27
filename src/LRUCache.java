import java.util.*;

public class LRUCache {
    DataEntry head;
    DataEntry tail;
    int capacity;
    Map<Integer, DataEntry> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DataEntry(0, 0);
        tail = new DataEntry(0, 0);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<Integer, DataEntry>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            DataEntry entry = map.get(key);
            delete(entry);
            insertInHead(entry);
            return entry.value;
        }    
        
        return -1;
    }
    
    public void set(int key, int value) {
        if (capacity < 1) {
            return;
        }
        
        if (map.containsKey(key)) {
            DataEntry entry = map.get(key);
            entry.value = value;
            delete(entry);
            insertInHead(entry);
        } else {
            DataEntry entry = new DataEntry(key, value);
            map.put(key, entry);
            insertInHead(entry);
            
            if (map.size() > capacity) {
                DataEntry second = tail.pre;
                delete(second);
                map.remove(second.key);
            }
        }
    }
    
    void delete(DataEntry entry) {
        entry.pre.next = entry.next;
        entry.next.pre = entry.pre;
        entry.next = null;
        entry.pre = null;
    }
    
    void insertInHead(DataEntry entry) {
        entry.next = head.next;
        entry.pre = head;
        head.next = entry;
        entry.next.pre = entry;
    }
    
    class DataEntry {
        int key;
        int value;
        
        DataEntry pre;
        DataEntry next;
        
        public DataEntry(int key, int val) {
            pre = null;
            next = null;
            this.key = key;
            this.value = val;
        }
    }
}
