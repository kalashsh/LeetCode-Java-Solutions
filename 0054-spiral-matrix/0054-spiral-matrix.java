class Solution {
    public List<Integer> spiralOrder(int[][] a) {
        List<Integer> ans = new ArrayList<>();
        int top = 0, bottom = a.length - 1;
        int left = 0, right = a[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) ans.add(a[top][j]);
            top++;
            for (int i = top; i <= bottom; i++) ans.add(a[i][right]);
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) ans.add(a[bottom][j]);
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) ans.add(a[i][left]);
                left++;
            }
        } 
        return ans;
    }
}
