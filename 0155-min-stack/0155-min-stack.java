class MinStack {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public MinStack() {}
    public void push(int val) {
        s.push(val);
        min.push(min.isEmpty() ? val : Math.min(val, min.peek()));
    }
    public void pop() {
        s.pop();
        min.pop();
    }
    public int top() {
        return s.peek();
    }
    public int getMin() {
        return min.peek();
    }
}
