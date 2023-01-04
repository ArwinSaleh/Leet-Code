import java.util.ArrayDeque;

class Main {
    public static void main(String[] args) {
        Solution testSolution = new Solution();
        int[] testArray = { 2, 4, 3, 1, 5 };
        int[] result = testSolution.maxSlidingWindow(testArray, 2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

class Solution {
    /*
     * NOTE: Comments made by ChatGPT.
     * This code is using a sliding window approach to find the maximum element in
     * each subarray of length k in the input array nums. It uses an array deque to
     * store the indices of the elements in the sliding window in such a way that
     * the first element in the deque is the index of the maximum element in the
     * current window.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k == 0)
            return new int[0];

        ArrayDeque<Integer> slidingWindow = new ArrayDeque<Integer>();
        int maxValIdx = 0;
        int[] maxVals = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (!slidingWindow.isEmpty() && slidingWindow.peek() < i - k + 1) {
                slidingWindow.poll();
            }
            while (!slidingWindow.isEmpty() && nums[slidingWindow.peekLast()] < nums[i]) {
                slidingWindow.pollLast();
            }
            slidingWindow.offer(i);
            if (i >= k - 1) {
                maxVals[maxValIdx++] = nums[slidingWindow.peek()];
            }
        }
        return maxVals;
    }
}