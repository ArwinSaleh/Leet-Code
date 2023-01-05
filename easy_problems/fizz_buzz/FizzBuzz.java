import java.util.*;

class Main {
    public static void main(String[] args) {

        Solution testSolution = new Solution();
        List<String> result = testSolution.fizzBuzz(5);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> fizzBuzz = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) sb.append("Fizz");
            if (i % 5 == 0) sb.append("Buzz");
            if (sb.length() == 0) sb.append(i);
            fizzBuzz.add(sb.toString());
        }
        return fizzBuzz;
    }
}
