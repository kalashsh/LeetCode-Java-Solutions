import java.util.*;
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals)
            list.add(interval);
        list.add(newInterval);
        list.sort((a,b)-> a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : list) {
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < interval[0]) {
                ans.add(interval);
            } else {
                ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],interval[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}