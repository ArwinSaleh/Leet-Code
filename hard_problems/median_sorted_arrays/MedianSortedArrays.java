class Main {
    public static void main(String[] args) {
        Solution testSolution = new Solution();
        int[] nums1 = { 1, 2 }, nums2 = { 3, 4 };
        double result = testSolution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int mn = m + n;
        boolean isEven = (mn & 1) == 0;
        int midIdx = mn / 2;
        int i = 0, j = 0;
        int median1 = 0, median2 = 0;
        for (int k = 0; k <= midIdx; k++) {
            int num;
            if (i >= m) {
                num = nums2[j++];
            } else if (j >= n) {
                num = nums1[i++];
            } else if (nums1[i] <= nums2[j]) {
                num = nums1[i++];
            } else {
                num = nums2[j++];
            }
            median1 = median2;
            median2 = num;
        }
        return isEven ? (median1 + median2) / 2.0 : median2;
    }
}