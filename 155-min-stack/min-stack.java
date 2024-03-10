class MinStack {
    private Stack<Integer> minStack;
    private Stack<Integer> stack;

    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int min;
        if (minStack.isEmpty() || val < minStack.peek()) {
            min = val;
        } else {
            min = minStack.peek();
        }

        minStack.push(min);
        stack.push(val);
    }
    
    public void pop() {
        minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
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