/**
 * Created by Reshetuyk on 17.07.2016.
 */
public class LargestProductInSeries {
    private int iterations;
    private int[] series;
    private int limit;
    private int max = 0;

    public LargestProductInSeries(int[] series, int limit) {
        this.series = series;
        this.limit = limit;
    }

    public int findMaxMultiplyAdjacentNotOptimized() {
        validateLimit(series, limit);

        for (int i = 0; i + limit - 1 <= series.length - 1; i++) {
            int res = multiplySeries(series, i, limit + i - 1);
            max = Math.max(res, max);
        }
        System.out.println("series length=" + series.length + " limit=" + limit + " iterations=" + iterations);
        return max;
    }


    public int findMaxMultiplyAdjacent() {
        int res = findMaxMultiplyAdjacent(0, series.length - 1, 0);
        System.out.println("series length=" + series.length + " limit=" + limit + " iterations=" + iterations);
        return res;
    }

    public int findMaxMultiplyAdjacent(int from, int to, int res) {
        validateLimit(series, limit);

        for (int i = from; i + limit - 1 <= to; i++) {
            if (res == 0) {
                res = multiplySeries(series, i, limit + i - 1);
            }
            if (i + limit < series.length - 1 && series[i + limit] == 0 || res == 0) {
                return findMaxMultiplyAdjacent(i + limit + 1, to, 0);
            }

            if (i + limit > series.length - 1)
                return Math.max(res, max);

            res = res / series[i] * series[i + limit];
            iterations = iterations + 2;

            max = Math.max(res, max);
        }
        return max;
    }

    private static void validateLimit(int[] series, int limit) {
        if (series.length < limit) throw new RuntimeException("limit cannot be larger than series");
    }

    private int multiplySeries(int[] series, int from, int to) {
        validateFromTo(series, from, to);
        int res = 1;
        for (int i = from; i <= to; i++) {
            res *= series[i];
            ++iterations;
        }
        return res;
    }

    private static void validateFromTo(int[] series, int from, int to) {
        if (from > series.length || to > series.length)
            throw new RuntimeException("from or to cannot be bigger then array length");
    }
}
