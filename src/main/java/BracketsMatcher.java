import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Alexey
 */
public class BracketsMatcher {
    public static boolean check(String str) {
        if (str == null || str.isEmpty()) return true;

        Map<Character, Character> brackets = new HashMap<>(3);
        brackets.put('(', ')');
        brackets.put('{', '}');
        brackets.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for (char curChar : str.toCharArray()) {
            if (brackets.containsKey(curChar)) {
                stack.push(curChar);
            } else if (brackets.containsValue(curChar) && (stack.isEmpty() || curChar != brackets.get(stack.pop()))) {
                return false;
            }
        }

        return stack.empty();
    }
}
