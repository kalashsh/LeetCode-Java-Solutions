import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = -1;
            int j = 0;
            while (j < nums2.length && nums2[j] != nums1[i]) j++;
            for (j = j + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) { res[i] = nums2[j]; break; }
            }
        }
        return res;
    } 
}