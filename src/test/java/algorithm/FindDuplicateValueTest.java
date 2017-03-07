package algorithm;

import org.junit.Test;

import static algorithm.FindDuplicateValue.findDuplicate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FindDuplicateValueTest {

    @Test
    public void testFindDuplicate() throws Exception {
        assertThat(findDuplicate(new int[]{1, 2, 4, 0, 9, 3, 8, 2}), is(2));
        assertThat(findDuplicate(new int[]{6, 5, 15, 44, -5, 4, 44}), is(44));
        assertThat(findDuplicate(new int[]{0, 3, 2, 0}), is(0));
    }
}