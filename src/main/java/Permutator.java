import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Reshetuyk on 09.06.2017.
 */
public class Permutator {

    private Map<Integer, List<Character>> intByLetterMap = new LinkedHashMap<>();

    public Permutator() {
        intByLetterMap.put(1, Arrays.asList('a', 'b', 'c'));
        intByLetterMap.put(2, Arrays.asList('d', 'f', 'g'));
        intByLetterMap.put(3, Arrays.asList('r'));
    }

    public static void doPermutation (List<Integer> seq) {
        for (Integer integer : seq) {

        }

    }
}
