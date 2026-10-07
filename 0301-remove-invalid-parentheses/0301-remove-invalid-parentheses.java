class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s); seen.add(s);

        while (!q.isEmpty()) {
            String x = q.poll();

            if (valid(x)) ans.add(x);
            if (!ans.isEmpty()) continue;

            for (int i = 0; i < x.length(); i++)
                if (x.charAt(i) == '(' || x.charAt(i) == ')') {
                    String y = x.substring(0, i) + x.substring(i + 1);
                    if (seen.add(y)) q.add(y);
                }
        }
        return ans;
    }

    boolean valid(String s) {
        int b = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') b++;
            else if (c == ')' && --b < 0) return false;
        }
        return b == 0;
    }
}
