import java.util.function.IntBinaryOperator;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.stream;

/**
 * Created by Reshetuyk on 17.07.2016.
 */
public class LargestProductInSeries {
//    private int max;
//
//    public int findMaxMultiplyAdjacent(int[] series, int limit) {
//        if (series.length < limit) throw new RuntimeException("limit cannot be larger than series");
//
//        int halfLength = series.length / 2;
//        int multiplyResult;
//
//        if (series.length == limit) {
//            multiplyResult = stream(series).reduce(1, multiple());
//            return max > multiplyResult ? max : multiplyResult;
//        }
//        if (halfLength < limit) {
//            multiplyResult = findMaxMultiplyAdjacentSimple(series, limit);
//            return max > multiplyResult ? max : multiplyResult;
//        }
//
//        int[] middle = copyOfRange(series, halfLength - (limit - 1), halfLength + (limit - 1));
//        int maxInMiddle = findMaxMultiplyAdjacentSimple(middle, limit);
//        max = maxInMiddle > max ? maxInMiddle : max;
//        int[] firstHalf = copyOfRange(series, 0, halfLength);
//        int[] secondHalf = copyOfRange(series, halfLength, series.length);
//
//        return stream(firstHalf).sum() > stream(secondHalf).sum()
//                ? findMaxMultiplyAdjacent(firstHalf, limit)
//                : findMaxMultiplyAdjacent(secondHalf, limit);
//    }

    public static int findMaxMultiplyAdjacent(int[] series, int limit) {
        if (series.length < limit) throw new RuntimeException("limit cannot be larger than series");

        int max = 0;
        for (int i = 0; i < series.length; i++) {
            if (i + limit > series.length) break;
            int multiplyResult = stream(copyOfRange(series, i, limit + i)).reduce(1, multiple());
            max = multiplyResult > max ? multiplyResult : max;
        }
        return max;
    }

    private static IntBinaryOperator multiple() {
        return (a, b) -> a * b;
    }
}
