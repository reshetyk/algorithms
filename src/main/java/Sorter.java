/**
 * Created by Reshetuyk on 13.02.2016.
 */
public class Sorter {

    public static int[] zerosToTop(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] == 0) {
                left++;
                continue;
            }
            if (arr[right] != 0) {
                right--;
                continue;
            }
            arr[right] = arr[left];
            arr[left] = 0;
            left++;
            right--;
        }
        return arr;
    }
}
