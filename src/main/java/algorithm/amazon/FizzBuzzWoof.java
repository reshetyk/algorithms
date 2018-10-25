package algorithm.amazon;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by Reshetuyk on 15.06.2017.
 */
public class FizzBuzzWoof {

    private static final Map<Integer, String> mapping = new LinkedHashMap<>(3);

    static {
        mapping.put(3, "Fizz");
        mapping.put(5, "Buzz");
        mapping.put(7, "Woof");
    }

    public void solution(int N) {
        StringBuilder res = new StringBuilder();
        IntStream.rangeClosed(1, N).forEach(i -> {
                    res.setLength(0);
                    checkModulo(res, i);
                    if (res.length() <= 0) {
                        res.append(i);
                    }
                    System.out.println(res.toString());
                }
        );
    }

    private void checkModulo(StringBuilder res, int i) {
        mapping.forEach((k, v) -> {
            if (i % k == 0) {
                res.append(v);
            }
        });
    }

}
