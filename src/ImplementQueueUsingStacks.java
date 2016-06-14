import java.util.*;

public class ImplementQueueUsingStacks {
    
    Stack<Integer> head = new Stack<Integer>();
    Stack<Integer> tail = new Stack<Integer>();
    
    int count = 0;
    
    // Push element x to the back of queue.
    public void push(int x) {
        tail.push(x);
        count++;
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (head.isEmpty()) {
            if (count != 0) {
                for (int i = 0; i < count - 1; i++) {
                    head.push(tail.pop());
                }
                count--;
            }
        } else {
            head.pop();
            count--;
        }
    }

    // Get the front element.
    public int peek() {
        int ret = 0;
        if (head.isEmpty()) {
            if (count != 0) {
                for (int i = 0; i < count; i++) {
                    head.push(tail.pop());
                }
                
                ret = head.peek();
            }
        } else {
            ret = head.peek();
        }
        
        return ret;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (count == 0);
    }
}
