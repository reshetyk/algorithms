package algorithm;

public class CoinProblem {

    static int minCoins(int arr[], int k) {
        int table[] = new int[k + 1];
        table[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j <= k; j++)
                table[j] += table[j - arr[i]];
        }

        for (int i = k; i >= 0; i--)
            if (table[i] != 0)
                return i;

        return 0;

    }

    // m is size of coins array
    // (number of different coins)
    static int minCoins(int coins[], int m, int V) {
        // table[i] will be storing
        // the minimum number of coins
        // required for i value. So
        // table[V] will have result
        int table[] = new int[V + 1];

        // Base case (If given value V is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i = 1; i <= V; i++)
            table[i] = Integer.MAX_VALUE;

        // Compute minimum coins required for all
        // values from 1 to V
        for (int i = 1; i <= V; i++) {
            // Go through all coins smaller than i
            for (int j = 0; j < m; j++)
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;


                }

        }
        return table[V];

    }
}