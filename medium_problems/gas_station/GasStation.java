class Main {
    public static void main(String[] args) {
        Solution testSolution = new Solution();
        int[] gas =     {1,2,3,4,5};
        int[] cost =    {3,4,5,1,2};
        int result = testSolution.canCompleteCircuit(gas, cost);
        //System.out.println(result);
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int travelIdx = 0, gasTank = 0, n = gas.length;
        for (int i = 0; i < n; i++) {
            travelIdx = gas[i] >= cost[i] ? i : travelIdx;
        }
        gasTank = gas[travelIdx];
        while (gasTank > 0) {
            travelIdx = travelIdx == n-1 ? 0 : travelIdx + 1;
            gasTank += gas[travelIdx] - cost[travelIdx-1];
            System.out.println(gasTank);
        }
        travelIdx -= gasTank < 0 ? 1 : 0;
        return travelIdx;
    }
}