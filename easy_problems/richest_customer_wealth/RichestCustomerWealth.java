class Main {
    public static void main(String[] args) {
        Solution testSolution = new Solution();
        int[][] testAccounts = { { 1, 2, 3 }, { 3, 2, 1 }, { 7, 1, 3 }, { 1, 9, 5 }, { 2, 8, 7 } };
        int result = testSolution.maximumWealth(testAccounts);
        System.out.println(result);
    }
}

class Solution {
    public int maximumWealth(int[][] accounts) {
        int richestCustomer = 0;
        for (int i = 0; i < accounts.length; i++) {
            int currentWealth = sumWealth(accounts[i]);
            richestCustomer = currentWealth > richestCustomer ? currentWealth : richestCustomer;
        }
        return richestCustomer;
    }

    private int sumWealth(int[] account) {
        int sum = 0, low = 0, high = account.length - 1;
        while (low < high) {
            sum += account[low] + account[high];
            low++; high--;
        }
        sum += low == high ? account[low] : 0;
        return sum;
    }
}