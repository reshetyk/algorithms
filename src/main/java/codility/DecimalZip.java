package codility;

/**
 * @author Alexey
 */
public class DecimalZip {
    public static int generate(int a, int b) {
        String sA = String.valueOf(a);
        String sB = String.valueOf(b);
        StringBuilder sRes = new StringBuilder();
        int minLen = Math.min(sA.length(), sB.length());
        int counter = 0;
        while (counter < minLen) {
            sRes.append(sA.charAt(counter)).append(sB.charAt(counter));
            counter++;
        }
        if (counter < sA.length()) {
            sRes.append(sA.substring(counter, sA.length()));
        } else if (sB.length() != sA.length()) {
            sRes.append(sB.substring(counter, sB.length()));
        }

        final int res = Integer.parseInt(sRes.toString());

        return res > 100_000_000 ? -1 : res;
    }
}
