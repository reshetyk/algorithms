package codility;

import hackerrank.JumpingOnClouds;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class JumpingOnCloudsTest {

    @Test
    public void count() {
        Assert.assertThat(JumpingOnClouds.count(0, 0, 1, 0, 0, 1, 0), is(4));
        Assert.assertThat(JumpingOnClouds.count(0, 0, 0, 1, 0, 0), is(  3));

    }
}