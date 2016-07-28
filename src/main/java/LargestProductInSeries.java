import java.util.Arrays;

/**
 * Created by Reshetuyk on 17.07.2016.
 */
public class LargestProductInSeries {
    private int iterations;
    private int[] series;
    private int limit;
    private long max = 0;

    public LargestProductInSeries(int[] series, int limit) {
        this.series = series;
        this.limit = limit;
    }

    public long findMaxMultiplyAdjacentNotOptimized() {
        validateLimit(series, limit);
        int [] maxArr = new int[series.length-1];
        for (int i = 0; i + limit - 1 <= series.length - 1; i++) {
            long res = multiplySeries(series, i, limit + i - 1);
            if (res > max) maxArr = Arrays.copyOfRange(series, i, limit + i - 1);
            max = Math.max(res, max);
        }
        System.out.println("\nseries length=" + series.length + " limit=" + limit + " iterations=" + iterations);
        System.out.println("max arr=" + Arrays.toString(maxArr) + "; max="+max);
        return max;
    }

    public long findMaxMultiplyAdjacent() {
        int [] maxArr = new int[series.length-1];
        validateLimit(series, limit);
        int i, maxI = 0;
        long res = 0;
        for (i = 0; i + limit - 1 <= series.length - 1; i++) {
            if (res == 0) {
                res = multiplySeries(series, i, limit + i - 1);
            }
//            9* 7* 5* 3* 6* 9* 7* 8* 1* 7* 9* 7* 7* 8 = 70573265280
//            if (series[i] == 0 || (i + limit < series.length - 1 && series[i + limit] == 0) || res == 0) {
//                i = i + limit;
//                res = 0;
//                continue;
//            }


            if (i + limit > series.length - 1){
                if (res > max) {
                    maxArr = Arrays.copyOfRange(series, i, limit + i);
                    maxI = i;
                }
                max = Math.max(res, max);
                System.out.println(max);
                break;
            }

            if (res == 0 || series[i] == 0 || series[i + limit] == 0) {
                res = 0;
                continue;
            }
            res = res / series[i] * series[i + limit];
            if (res > max) {
                maxArr = Arrays.copyOfRange(series, i + 1, limit + i + 1);
                maxI = i;
            }
            iterations = iterations + 2;

            max = Math.max(res, max);
        }
        System.out.println("\nseries length=" + series.length + " limit=" + limit + " iterations=" + iterations);
        System.out.println("max arr=" + Arrays.toString(maxArr) + "; max="+max +"; i="+maxI);
        return max;
    }

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
