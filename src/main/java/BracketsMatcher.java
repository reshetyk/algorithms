import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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

    public static boolean isBalanced(String s) {
        Map<Character, Character> closedBrackets = new HashMap<>();
        closedBrackets.put('{', '}');
        closedBrackets.put('[', ']');
        closedBrackets.put('(', ')');

        if (s.length() == 0 || s.length() % 2 != 0) {
            return false;

        }

        for (int i = 0; i < s.length() / 2; i++) {
            char leftChar = s.charAt(i);
            char rightChar = s.charAt(s.length() - i - 1);
            Character closed = closedBrackets.get(leftChar);
            if (closed == null || closed != rightChar) {
                return false;
            }
        }
        return true;
    }

}
