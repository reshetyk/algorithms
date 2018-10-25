package codility;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

import static codility.ArrayManipulation.arrayManipulation;
import static org.hamcrest.core.Is.is;

public class ArrayManipulationTest {

    @Test
    public void arrayManipulationTest() {
//        Assert.assertThat(arrayManipulation(4000, readFromFile()), is(7542539201L));
        Assert.assertThat(arrayManipulation(6, new int[][]{{3, 5, 4}, {1, 2, 6}, {4, 5, 1}}), is(6L));
        Assert.assertThat(arrayManipulation(10, new int[][]{{1, 5, 3}, {4, 8, 7}, {6, 9, 1}, {6, 7, 5}, {7, 8, 6}}), is(19L));
        Assert.assertThat(arrayManipulation(5, new int[][]{{1, 2, 100}, {2, 5, 100}, {3, 4, 100}}), is(200L));
    }

    private static int[][] readFromFile() {
        int[][] res = new int[30000][3];
        try (InputStream resourceAsStream = ArrayManipulation.class.getClassLoader().getResourceAsStream("input-2d-array.txt")) {
            String text = IOUtils.toString(resourceAsStream);
            String[] split = text.split("\\s+");
            int count = 0;
            for (int i = 0; i < 30000; i++) {
                for (int j = 0; j < 3; j++) {
                    res[i][j] = Integer.parseInt(split[count++]);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}