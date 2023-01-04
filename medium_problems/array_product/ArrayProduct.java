import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Solution testSolution = new Solution();
        int[] testArray = { 2, 3, 6, 4 };
        int[] result = testSolution.productExceptSelf(testArray);
        System.out.println(result[0]);
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        int numberOfZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numberOfZeros++;
            } else {
                totalProduct *= nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (numberOfZeros > 1) {
                nums[i] = 0;
            }
            else if (nums[i] == 0) {
                nums[i] = totalProduct;
            }
            else {
                nums[i] = numberOfZeros == 0 ? totalProduct / nums[i] : 0;
            }
        }
        return nums;
    }
}