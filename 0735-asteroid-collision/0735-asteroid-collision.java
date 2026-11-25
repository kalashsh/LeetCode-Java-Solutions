class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int a : asteroids) {
            while (!stack.isEmpty() && a < 0 && stack.peekLast() > 0) {
                int top = stack.peekLast();
                if (top < -a) stack.pollLast();
                else if (top == -a) { stack.pollLast(); a = 0; break; }
                else { a = 0; break; }
            }
            if (a != 0) stack.addLast(a);
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}