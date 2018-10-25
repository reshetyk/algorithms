package codility;

public class ArrayManipulation {

    public static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];
        for (int i = 0; i < queries.length; i++) {
            int startIndex = queries[i][0];
            int endIndex = queries[i][1];
            long numToSum = queries[i][2];
            arr[startIndex - 1] += numToSum;
            if (endIndex < n) arr[endIndex] -= numToSum;
        }
        long max = 0;
        long temp = 0;

        for (int i = 0; i < n; i++) {
            temp += arr[i];
            if (temp > max) max = temp;
        }
        return max;
    }
}
