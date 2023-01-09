import java.util.Random;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        int[] test = random.ints(1000000000, 10,100000).toArray();

        naiveSum(test); // Slow
        twoPointerSum(test); // Fast
        fourPointerSum(test); // Slowest!?
        intStreamSum(test); // Slow
    }

    private static void naiveSum(int[] test) {
        final long startTime = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < test.length; i++) {
            sum += test[i];
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
        System.out.println(sum);
    }
    private static void twoPointerSum(int[] test) {
        final long startTime = System.currentTimeMillis(); 
        int sum = 0;
        int i = 0, j = test.length - 1;
        while (i < j) {
            sum += test[i] + test[j];
            i++; j--;        }
        sum += i == j ? test[i] : 0;
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
        System.out.println(sum);
    }
    private static void fourPointerSum(int[] test) {
        final long startTime = System.currentTimeMillis();
        int sum = 0;
        int beg = 0, end = test.length - 1;
        int mid = end / 2;
        int mid2 = mid + 1;
        while (beg < mid && mid2 < end) {
            sum += test[beg++] + test[mid--] + test[mid2++] + test[end--];
        }
        while (beg < mid) {
            sum += test[beg++] + test[mid--];
        }
        while (mid2 < end) {
            sum += test[mid2++] + test[end--];
        }
        sum += beg == mid ? test[beg] : 0;
        sum += mid2 == end ? test[mid2] : 0;
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
        System.out.println(sum);
    }
    private static void intStreamSum(int[] test) {
        final long startTime = System.currentTimeMillis();
        int sum = IntStream.of(test).sum();
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
        System.out.println(sum);
    }
}
