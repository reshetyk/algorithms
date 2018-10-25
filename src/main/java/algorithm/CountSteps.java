package algorithm;

/**
 * Created by Reshetuyk on 12.12.2017.
 */
public class CountSteps {

    public static int countPossibilities(int n) {
        if (n == 1 || n == 2) return n;
        return countPossibilities(n - 1) + countPossibilities(n - 2);
    }
}
