package hackerrank;

import java.util.Arrays;

public class MinThatNotIncluded {

    /**
     *  given an array of integer, returns the
     *  smallest positive integer (greater than 0)
     *  that does not occur in seq.
     */
    public static int calc (int...  seq) {

        int res = Arrays.stream(seq)
                .filter((i) -> i > 0)
                .sorted()
                .reduce(0, (left, right) -> left - right < -1 ? left : right);

        return res + 1;

        //1 3 -1 7 4 3
        // (filter/sort) 1 3 3 4 7
        // (reduce)
        // 0 - 1 = -1 -> 1
        // 1 - 3 = -2 -> 1
        // 1 - 3 = -2 -> 1
        // 1 - 4 = -3 -> 1
        // 1 - 7 = -6 -> 1
        // return 1 + 1 = 2
    }
}
