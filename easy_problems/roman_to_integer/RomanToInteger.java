class Main {
    public static void main(String[] args) {

        Solution testSolution = new Solution();
        System.out.println(testSolution.romanToInt("MCMXCIV"));
    }
}

class Solution {
    public int romanToInt(String s) {
        int lastNumber = 0;
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char romanVal = s.charAt(i);
            int intVal = getIntValue(romanVal);
            if (intVal >= lastNumber) {
                sum += intVal;
            }
            else {
                sum -= intVal;
            }
            lastNumber = intVal;
        }
        return sum;
    }
    private int getIntValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
