class MyQueue {
    private final Stack<Integer> first;
    private final Stack<Integer> second;

    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }
    
    // Push to input stack
    public void push(int x) {
        first.push(x);
    }
    
    // Pop from output stack
    public int pop() {
        peek(); // ensure output stack has the right order
        return second.pop();
    }
    
    // Peek at the front of queue
    public int peek() {
        if (second.isEmpty()) {             // ✅ FIX: transfer only if second is empty
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }
        return second.peek();
    }
    
    // Check if queue is empty
    public boolean empty() {
        return first.isEmpty() && second.isEmpty();
    }
}
