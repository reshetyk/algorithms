package hackerrank;

/**
 * Created by Reshetuyk on 10.09.2017.
 */
public class MostOftenElement {

    public static void main(String[] args) {
        System.out.println(new MostOftenElement().solution(7, new int[]{1,2,3,4,5,6,7,7,7,7}));
        System.out.println(new MostOftenElement().solution(4, new int[]{1,2,3,4}));
        System.out.println(new MostOftenElement().solution(2, new int[]{1,2,1,1,1,2,1,2,2,2,2}));
        System.out.println(new MostOftenElement().solution(10000, new int[]{6572,5318,9999,1111,9999}));
    }

//    int solution(int M, int[] A) {
//        int mostOften = A[0];
//        int maxCount = 0;
//        Map<Integer, Integer> occurrences = new HashMap<>();
//        for (int i : A) {
//            Integer count = occurrences.get(i);
//            occurrences.put(i, count != null ? count + 1 : 0);
//            if (occurrences.get(i) > maxCount) {
//                maxCount = count;
//                mostOften = i;
//            }
//        }
//        return mostOften;
//    }


        int solution(int M, int[] A) {
            int N = A.length;
            int[] count = new int[M + 1];
            for (int i = 0; i <= M; i++)
                count[i] = 0;
            int maxOccurence = 0;
            int index = 0;
            for (int i = 0; i < N; i++) {
                if (count[A[i]] > 0) {
                    int tmp = count[A[i]];
                    if (tmp > maxOccurence) {
                        maxOccurence = tmp;
                        index = i;
                    }
                    count[A[i]] = tmp + 1;
                } else {
                    count[A[i]] = 1;
                }
            }
            return A[index];
        }

}
