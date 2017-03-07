package algorithm;

import org.junit.Test;

import static algorithm.InsertionSort.sort;
import static org.junit.Assert.assertArrayEquals;

public class InsertionSortTest {

    @Test
    public void testSort() throws Exception {
        sortAndAssert(new int[]{2, 4, 6, 8, 50}, new int[]{6, 4, 2, 8, 50});
        sortAndAssert(new int[]{1, 1, 2, 2, 3}, new int[]{2, 1, 3, 1, 2});
        sortAndAssert(new int[]{2, 5, 5, 6, 7, 9}, new int[]{5, 7, 2, 5, 6, 9});
    }

    private static void sortAndAssert(int[] expected, int[] arr) {
//        int[] ints = Arrays.stream("1 2 3 4".split(" ")).mapToInt(i -> new Integer(i)).toArray();
//        System.out.println("ints="+Arrays.toString(ints));
        sort(arr);
        assertArrayEquals(expected, arr);
    }
}