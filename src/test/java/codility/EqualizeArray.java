package codility;


import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EqualizeArray {
    public static int equalizeArray(int... arr) {
        int maxDuplication = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream()
                .sorted(Comparator.reverseOrder()).findFirst().get().intValue();

        return arr.length - maxDuplication;
    }
}
