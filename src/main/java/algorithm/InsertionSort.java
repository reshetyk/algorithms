package algorithm;

import java.util.Arrays;

/**
 * Created by Reshetuyk on 30.01.2017.
 */
class LinkedList<T> {
    T element;
    T next;
}


public class InsertionSort {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.element = 1;
        list.next = 2;

    }

    public static void sort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int temp = arr[j];
                arr[j] = arr [j -1];
                arr[j - 1] = temp;
                res++;
                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println(res);
    }
// 5 7 2 5 6 9
// 2 5 7 5 6 9  - 1
// 2 5 5 7 6 9  - 2
// 2 5 5 6 7 9  - 3

}
