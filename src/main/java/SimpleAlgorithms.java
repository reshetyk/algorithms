/**
 * @author Alexey
 */
public class SimpleAlgorithms {

    /**
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
     * The sum of these multiples is 23.
     * Find the sum of all the multiples of 3 or 5 below 1000.
     */
    public static void multiplesOf3And5 () {
        int sum = 0;
        for (int i = 0; i < 1000; i += 3) {
            sum += i ;
            if ((i + 2) % 5 == 0) {
                sum += i + 2;
            }
        }
        System.out.println(sum);

        int sum2 = 0;
        for (int i = 0; i < 1000; i++)
        {
            if ((i % 3 == 0) || (i % 5 == 0))
            {
                sum2 = sum2 + i;
            }
        }
        System.out.println(sum2);
    }

    public static void main(String[] args) {
        multiplesOf3And5();
    }

}
