package algorithm;

import javafx.util.Pair;
import org.junit.Test;

import static algorithm.FindSpecifiedSumPair.findPairs;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class FindSpecifiedSumPairTest {

    @Test
    public void testFindPairs() throws Exception {
        assertEquals(asList(new Pair(-20, 120), new Pair(-5, 105), new Pair(20, 80), new Pair(30, 70)),
                findPairs(new Integer[]{-8, -20, -5, 0, 0, 2, 20, 30, 61, 50, 55, 70, 80, 105, 120}, 100));

        assertEquals(asList(new Pair(-20, 120), new Pair(-5, 105), new Pair(0, 100), new Pair(20, 80), new Pair(30, 70)),
                findPairs(new Integer[]{-8, -20, -5, 0, 0, 2, 20, 30, 61, 50, 55, 70, 100, 80, 105, 120}, 100));
    }
}