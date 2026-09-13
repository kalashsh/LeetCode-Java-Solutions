class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length)
            c[k++] = a[i] < b[j] ? a[i++] : b[j++];

        while (i < a.length) c[k++] = a[i++];
        while (j < b.length) c[k++] = b[j++];

        int n = c.length;
        return n % 2 == 1
            ? c[n / 2]
            : (c[n / 2 - 1] + c[n / 2]) / 2.0;
    }
}
