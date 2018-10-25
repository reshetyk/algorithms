package hackerrank;

import java.util.stream.Collectors;

/**
 * Created by Reshetuyk on 09.09.2017.
 */
public class FormatPhone {

    public static void main(String[] args) {
        System.out.println(new FormatPhone().solution("00-44  48 5555 8361"));
        System.out.println(new FormatPhone().solution("0 - 22 1985--324"));
        System.out.println(new FormatPhone().solution("022-13"));
        System.out.println(new FormatPhone().solution("0221323"));
        System.out.println(new FormatPhone().solution("0"));
        System.out.println(new FormatPhone().solution("23"));
        System.out.println(new FormatPhone().solution("235"));
        System.out.println(new FormatPhone().solution("235  - 1"));
    }

    public String solution(String S) {
        String collect = S.chars().mapToObj(i -> (char) i)
                .filter(c -> c != ' ' && c != '-')
                .map(c -> c.toString())
                .collect(Collectors.joining(""));

        StringBuilder sb = new StringBuilder();
        int groupLen = 3;
        for (int i = 0; i <= collect.length(); i += groupLen) {
            if (collect.length() - i <= groupLen) {
               sb.append(collect.substring(i, collect.length()));
            }

            else if ((collect.length() - i) % 4 == 0)
                return sb.append(collect.substring(i, i + 2)).append('-').append(collect.substring(i + 2, i + 4)).toString();
            else
                sb.append(collect.substring(i, i + groupLen)).append('-');

        }
        return sb.toString();
    }
}
