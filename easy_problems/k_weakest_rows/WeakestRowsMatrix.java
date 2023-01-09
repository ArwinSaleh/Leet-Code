import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        Solution testSolution = new Solution();
        int[][] testMat = { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 1 } };
        int[] result = testSolution.kWeakestRows(testMat, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        /*
         * Solution to find the k weakest rows in a given 2D matrix mat. The rows are
         * considered weakest based on the number of
         * soldiers (1s) in each row. The function first initializes an empty array
         * weakestRows of size k to store the indices of the k weakest rows.
         * 
         * It then creates a priority queue pq which will be used to store the rows of
         * mat based on the number of soldiers in each row. The priority queue is
         * implemented such that it stores an array [num, i] for each row i of mat,
         * where num is the number of soldiers in the row. The priority queue is sorted
         * such that the rows are in descending order based on num, and in ascending
         * order based on i in the event of a tie.
         * 
         * The function then iterates through each row i of mat, and adds an array [num,
         * i] to the priority queue, where num is the number of soldiers in the row.
         * 
         * After all rows have been added to the priority queue, the function removes
         * all elements from the priority queue except the top k elements (the weakest k
         * rows).
         * 
         * Finally, the function stores the indices of the weakest k rows in the
         * weakestRows array and returns it.
         */
        int[] weakestRows = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);

        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[] { numSoldiers(mat[i]), i });
        }
        while (pq.size() > k) {
            pq.remove();
        }
        while (k > 0) {
            weakestRows[--k] = pq.poll()[1];
        }

        return weakestRows;
    }

    private int numSoldiers(int[] row) {
        // Binary search
        int low = 0, high = row.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (row[mid] == 1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}