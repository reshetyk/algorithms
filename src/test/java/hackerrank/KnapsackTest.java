package hackerrank;

import org.junit.Test;

import static hackerrank.Knapsack.unboundedKnapsack;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class KnapsackTest {

    @Test
    public void unboundedKnapsacktest() {
        assertThat(unboundedKnapsack(12, new int[]{1, 6, 9}), is(12));
        assertThat(unboundedKnapsack(9, new int[]{3, 4, 4, 4, 8}), is(9));
        assertThat(unboundedKnapsack(13, new int[]{3, 7, 9, 11}), is(13));
        assertThat(unboundedKnapsack(11, new int[]{3, 7, 9}), is(10));
    }
}