import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author Alexey
 */
public class BracketsMatcher {
    public static boolean check(String str) {

        if (str == null || str.isEmpty()) return true;

        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('{', '}');
        brackets.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            if (brackets.containsKey(curChar)) {
                stack.push(curChar);
            } else if (brackets.containsValue(curChar) && (stack.isEmpty() || curChar != brackets.get(stack.pop()))) {
                return false;
            }
        }

        return stack.empty();
    }
}
