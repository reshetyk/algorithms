package algorithm;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Design an algorithm to find all pairs of integers within an array which sum to a specified value.
 */
public class FindSpecifiedSumPair {

    public static List<Pair<Integer, Integer>> findPairs(Integer[] arr, int sum) {
        Arrays.sort(arr);
        List<Integer> arrList = new ArrayList<>(Arrays.asList(arr));
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        int i = 0;
        while (i < arrList.size()) {
            int current = arrList.get(i);
            int pairToFind = current < 0 ? Math.abs(current) + sum : sum - current;
            int pairIdx = Arrays.binarySearch(arrList.toArray(), pairToFind);
            if (pairIdx > -1 && pairIdx != i) {
                pairs.add(new Pair(current, pairToFind));
                System.out.println("pair is found [" + current + "," + pairToFind + "]");
                arrList.remove(pairIdx);
            }
            arrList.remove(i);

        }
        return pairs;
    }

    public static List<Pair> findPairs2(Integer[] array, int sum) {
        Arrays.sort(array);
        int first = 0;
        int last = array.length - 1;
        List<Pair> pairs = new ArrayList<>(array.length);
        while (first < last) {
            int s = array[first] + array[last];
            if (s == sum) {
                pairs.add(new Pair(array[first], array[last]));
                first++;
                last--;
            } else {
                if (s < sum) ++first;
                else --last;
            }
        }
        return pairs;
    }

}
