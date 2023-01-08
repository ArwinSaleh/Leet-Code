import java.util.*;

class Main {
    public static void main(String[] args) {
        Solution testSolution = new Solution();
        int[][] points = { { 2, 3 }, { 3, 3 }, { -5, 3 } };
        int result = testSolution.maxPoints(points);
        System.out.println(result);
    }
}

class Solution {
    /*
     * This is a solution for finding the maximum number of points that are
     * collinear in a given set of points. It does this by iterating over all pairs
     * of points and for each pair, it calculates the slope and y-intercept of the
     * line that passes through these two points. It then stores the slope and
     * y-intercept in a HashMap, with the key being a string representation of the
     * first point's index on a line with slope (dy/dx) and the value being the
     * count of points that belong to
     * the line.
     * 
     * The solution also handles the case where the input array points contains
     * duplicate points by counting the number of duplicate points and adding it to
     * the maximum number of points on a line.
     */
    public int maxPoints(int[][] points) {
        int nPoints = points.length;
        HashMap<String, Integer> lines = new HashMap<>();
        int maxLines = 0;
        for (int i = 0; i < nPoints; i++) {
            int duplicatePoints = 1;
            for (int j = i + 1; j < nPoints; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    // Count duplicate points
                    duplicatePoints++;
                } else {
                    int dx = points[j][0] - points[i][0];
                    int dy = points[j][1] - points[i][1];
                    int gcd = gcd(dx, dy);
                    // Simplify the slope and intercept
                    dx /= gcd;
                    dy /= gcd;
                    String key = String.format("%d %d %d", i, dy, dx);
                    lines.put(key, lines.getOrDefault(key, 0) + 1);
                }
            }
            maxLines = nPoints > 1 ? Math.max(maxLines, duplicatePoints) : 0;
        }
        for (int value : lines.values()) {
            maxLines = Math.max(maxLines, value);
        }
        return maxLines + 1;
    }

    // Euclidean algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}