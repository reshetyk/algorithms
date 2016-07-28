import java.util.Arrays;

/**
 * Created by Reshetuyk on 17.07.2016.
 */
public class LargestProductInSeries {
    private int iterations;
    private int[] series;
    private int limit;
    private long max = 0;
    int iMax = 0;
    int [] maxArr = new int[limit];


    public LargestProductInSeries(int[] series, int limit) {
        this.series = series;
        this.limit = limit;
    }

    public long findMaxMultiplyAdjacentNotOptimized() {
        validateLimit(series, limit);

        for (int i = 0; i + limit - 1 <= series.length - 1; i++) {
            long res = multiplySeries(series, i, limit + i - 1);
            max = Math.max(res, max);
        }
        logDebugInfo();
        return max;
    }

    private void logDebugInfo() {
        System.out.println("series length=" + series.length + " limit=" + limit + " iterations=" + iterations + "; i="+iMax + "; max arr=" + Arrays.toString(maxArr));
    }

    public long findMaxMultiplyAdjacent() {
        validateLimit(series, limit);
        long res = 0; int i;
        for (i = 0; i + limit - 1 <= series.length - 1; i++) {
            if (res == 0) {
                res = multiplySeries(series, i, limit + i - 1);
            }

            if (i + limit > series.length - 1){
                max = Math.max(res, max);
                break;
            }

            if (series[i] == 0 || series[i + limit] == 0 || res == 0) {
                res = 0;
                continue;
            }
            //divide into first element in current range and multiply by the next
            res = res / series[i] * series[i + limit];
            iterations = iterations + 2;
            max = Math.max(res, max);
        }
        logDebugInfo();
        return max;
    }

/*
    private void setMaxIndexAndMaxRange_forDebug(long res, int i) {
        if (res > max) {
            iMax = i;
            maxArr = Arrays.copyOfRange(series, i + 1, limit + i - 1);
        }
    }
*/

    private static void validateLimit(int[] series, int limit) {
        if (series.length < limit) throw new RuntimeException("limit cannot be larger than series");
    }

    private long multiplySeries(int[] series, int from, int to) {
        validateFromTo(series, from, to);
        long res = 1;
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
