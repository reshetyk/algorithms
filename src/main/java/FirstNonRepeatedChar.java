import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

/**
 * Created by Reshetuyk on 15.07.2016.
 */
public class FirstNonRepeatedChar {
//    public static String findMaxMultiplyAdjacent (String s) {
//        Map<Character, Integer> charByOccurrence = new LinkedHashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            Integer occurrence = charByOccurrence.getOrDefault(s.charAt(i), 0);
//            charByOccurrence.put(s.charAt(i), ++occurrence);
//        }
//        for (Character character : charByOccurrence.keySet()) {
//            if (charByOccurrence.get(character).intValue() == 1) return character.toString();
//        }
//
//        return null;
//    }

    public static Optional<String> find(String s) {
        Map<String, Integer> charByOccurrence = new LinkedHashMap<>();
        s.chars().forEach(i ->  {
            Integer occurrence = charByOccurrence.getOrDefault( ((char) i) + "", 0);
            charByOccurrence.put((char) i + "", ++occurrence);
        });
        return charByOccurrence.keySet().stream().filter(c -> charByOccurrence.get(c).equals(1)).findFirst();
    }

    /////

    public static void main(String[] args) {
        findFirstNonRepeatingLetter("rabbitollar", System.out::println);
    }

    private static void findFirstNonRepeatingLetter(String s, Consumer<Character> callback) {
        s.chars()
                .mapToObj(i -> Character.valueOf((char) i))
                .collect(Collectors.groupingBy(identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst().map(c -> {
            callback.accept(c);
            return c;
        });
    }
}
