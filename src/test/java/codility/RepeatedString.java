package codility;

public class RepeatedString {

    public static long repeatedString(String s, long n) {

        if (s.length() >= n) {
            return countChars(s.substring(0, Long.valueOf(n).intValue()), 'a');
        }

        long count = n / s.length() * countChars(s,'a');
        long countRem = countChars(s.substring(0, Long.valueOf(n % s.length()).intValue()), 'a');

        return count + countRem;
    }

    private static long countChars(String s, char ch) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c == ch)
                .count();
    }
}
