import java.util.*;

public class ImplementStackUsingQueues {
    
    Deque<Integer> queue = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        queue.push(x);
        for (int i = 0; i < queue.size()-1; i++) {
            queue.push(queue.pop());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.pop();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
