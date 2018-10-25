package algorithm.amazon;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DigitCountTest {

    @Test
    public void testSolution() throws Exception {
        assertThat(new DigitCount().solution(3), is(2));
        assertThat(new DigitCount().solution(5), is(3));
        assertThat(new DigitCount().solution(10), is(1));
        assertThat(new DigitCount().solution(100), is(12));
        assertThat(new DigitCount().solution(500), is(55));
        assertThat(new DigitCount().solution(1000), is(105));
    }
}