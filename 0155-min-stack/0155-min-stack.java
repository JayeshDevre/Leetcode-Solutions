class MinStack {

    private Stack<Integer> st1;
    private Stack<Integer> minStack;

    public MinStack() {
        st1= new Stack<>();
        minStack= new Stack<>();
    }
    
    public void push(int val) {
        st1.push(val);

        if(minStack.isEmpty() || minStack.peek()>=val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(minStack.peek().equals(st1.peek())){
            minStack.pop();
        }
        st1.pop();
    }
    
    public int top() {
        return st1.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */