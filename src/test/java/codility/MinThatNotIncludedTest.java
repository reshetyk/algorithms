package codility;

import hackerrank.MinThatNotIncluded;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class MinThatNotIncludedTest {

    @Test
    public void calc() {
        Assert.assertThat( MinThatNotIncluded.calc(1, 3, -1, 7, 4, 3), is(2));
        Assert.assertThat( MinThatNotIncluded.calc(0, 1, 2, 3, 4, 5, 5, 6), is(7));
        Assert.assertThat( MinThatNotIncluded.calc(1, 2, 3, 4, 5, 5, 6), is(7));
        Assert.assertThat( MinThatNotIncluded.calc(2, 3, 4, 5, 5, 6), is(1));
        Assert.assertThat( MinThatNotIncluded.calc(-1, -3, -9, -1), is(1));
        Assert.assertThat( MinThatNotIncluded.calc(0), is(1));
        Assert.assertThat( MinThatNotIncluded.calc(1), is(2));
        Assert.assertThat( MinThatNotIncluded.calc(3, 2, 1), is(4));

    }
}