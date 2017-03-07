package algorithm;

import java.util.Arrays;

/**
 * Created by Reshetuyk on 09.12.2016.
 */
public class FindDuplicateValue {

    public static int findDuplicate (int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i + 1 < arr.length ; i++) {
            if (arr[i] == arr[i+1])
                return arr[i];
        }

        throw new RuntimeException("not found");
    }
}
