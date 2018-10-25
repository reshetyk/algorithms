package codility.amazon;

import algorithm.CountSteps;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class CountStepsTest {

    @Test
    public void testCountPossibilities() throws Exception {
        Assert.assertThat(CountSteps.countPossibilities(3), is(3));
        Assert.assertThat(CountSteps.countPossibilities(2), is(2));
        Assert.assertThat(CountSteps.countPossibilities(4), is(5));
        Assert.assertThat(CountSteps.countPossibilities(5), is(8));
    }
}