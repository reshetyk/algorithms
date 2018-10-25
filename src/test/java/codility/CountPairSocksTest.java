package codility;

import hackerrank.CountPairSocks;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class CountPairSocksTest {

    @Test
    public void count() {
        Assert.assertThat(CountPairSocks.count(2, 2, 5, 5, 5, 6, 1, 7, 8, 8, 8, 8), is(4));
        Assert.assertThat(CountPairSocks.count(1, 2, 3, 4, 5, 6, 7, 8), is(0));
        Assert.assertThat(CountPairSocks.count(1, 1, 3, 1, 1, 6, 1, 1), is(3));
    }
}