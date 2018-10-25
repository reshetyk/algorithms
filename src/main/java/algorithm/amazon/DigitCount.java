package algorithm.amazon;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;

/**
 * Created by Reshetuyk on 15.06.2017.
 */
public class DigitCount {

    private static final int POW_NUMBER = 11;
    private static final int REPRESENT_NUMBER = 1;

    public int solution(int N) {
        System.out.println("N="+N);

        int count = 0;
        BigInteger res = valueOf(POW_NUMBER);
        res = res.pow(N);
        System.out.println("pow="+res);
        BigInteger zero = valueOf(0L);
        for (; res.compareTo(zero) == 1; res = res.divide(valueOf(10L))) {
            if (res.remainder(valueOf(10L)).equals(valueOf(REPRESENT_NUMBER))) {
                count++;
            }
        }

        return count;
    }

}
