package algorithm;

import org.junit.Assert;
import org.junit.Test;

import static algorithm.CoinProblem.minCoins;
import static org.hamcrest.core.Is.is;

public class CoinProblemTest {

    @Test
    public void minCoinsTest() {

//        Assert.assertThat(minCoins(new int[]{9, 6, 5, 1}, 4, 11), is(2));
        Assert.assertThat(minCoins(new int[]{9, 6, 5, 1}, 11), is(2));
    }
}