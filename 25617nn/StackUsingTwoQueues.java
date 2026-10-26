import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    // Two queues
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push element onto the stack
    public void push(int x) {
        // Add element to q2
        q2.add(x);
        
        // Transfer all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        
        // Swap the names of q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Remove the element on top of the stack
    public int pop() {
        if (q1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q1.remove();
    }

    // Get the top element
    public int top() {
        if (q1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q1.peek();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    // Main method for execution and testing
    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();

        System.out.println("Pushing elements: 10, 20, 30");
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.top()); // Output: 30
        System.out.println("Popping element: " + stack.pop()); // Output: 30
        System.out.println("Top element after pop: " + stack.top()); // Output: 20

        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false
        System.out.println("Popping remaining elements: " + stack.pop() + ", " + stack.pop());
        System.out.println("Is stack empty now? " + stack.isEmpty()); // Output: true
    }
}


