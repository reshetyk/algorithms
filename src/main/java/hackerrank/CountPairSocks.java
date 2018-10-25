package hackerrank;

import java.util.Arrays;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CountPairSocks {
    public static int count (int... seq) {
        return Arrays.stream(seq)
                .boxed()
                .collect(groupingBy(identity(), counting()))
                .values().stream()
                .map(e -> e.intValue() / 2)
                .reduce(0, Integer::sum);

    }
}
