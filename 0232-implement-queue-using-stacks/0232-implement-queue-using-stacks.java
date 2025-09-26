class MyQueue {
    private final Stack<Integer> first;
    private final Stack<Integer> second;

    public MyQueue() {
        first= new Stack<>();
        second= new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        peek();
        return second.pop();
    }
    
    public int peek() {
        if(second.empty()){
            while(!first.empty()){
                second.push(first.pop());
            }
        }
        return second.peek();
    }
    
    public boolean empty() {
        return first.empty() && second.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */