package hackerrank;

public class Knapsack {
    public static int unboundedKnapsack(int k, int[] arr) {
        int[] table = new int[k + 1];

        table[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            if (k % arr[i] == 0) {
                return k;
            }
            for (int j = arr[i]; j <= k; j++)
                table[j] += table[j - arr[i]];
        }

        for (int i = k; i >= 0; i--)
            if (table[i] != 0)
                return i;

        return 0;
    }
}
