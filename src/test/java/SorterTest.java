import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Reshetuyk on 13.02.2016.
 */
public class SorterTest {
    @Test
    public void testZeroFirst() {
        assertThat(Sorter.zerosToTop(new int[]{}), is(new int[]{}));
        assertThat(Sorter.zerosToTop(new int[]{1}), is(new int[]{1}));
        assertThat(Sorter.zerosToTop(new int[]{0, 1}), is(new int[]{0, 1}));
        assertThat(Sorter.zerosToTop(new int[]{1, 0}), is(new int[]{0, 1}));
        assertThat(Sorter.zerosToTop(new int[]{0, 0, 1, 0}), is(new int[]{0, 0, 0, 1}));
        assertThat(Sorter.zerosToTop(new int[]{0, 0, 1, 0, 1}), is(new int[]{0, 0, 0, 1, 1}));
        assertThat(Sorter.zerosToTop(new int[]{1, 0, 1, 0, 0, 1, 0}), is(new int[]{0, 0, 0, 0, 1, 1, 1}));
        assertThat(Sorter.zerosToTop(new int[]{2, 2, 2, 2, 0, 2, 2}), is(new int[]{0, 2, 2, 2, 2, 2, 2}));
        assertThat(Sorter.zerosToTop(new int[]{0, 2, 0, 2, 0, 2, 0, 2}), is(new int[]{0, 0, 0, 0, 2, 2, 2, 2}));
    }
}
