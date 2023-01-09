class Main {
    public static void main(String[] args) {

        Solution testSolution = new Solution();
        int result = testSolution.numberOfSteps(14);
        System.out.println(result);
    }
}

class Solution {
    public int numberOfSteps(int num) {
        int numSteps = 0;
        while (num > 0) {
            // num = num % 2 == 0 ? num / 2 : num - 1;
            num = (num & 1) == 1 ? num - 1 : num >> 1;
            numSteps++;
        }
        return numSteps;
    }
}
