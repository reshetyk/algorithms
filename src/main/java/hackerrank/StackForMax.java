package hackerrank;

import java.util.*;

import static java.util.Map.Entry;

public class StackForMax {
    private final LinkedList<Entry> stack = new LinkedList<>();
    private int max;

    public void push(int i) {
        max = Math.max(i, max);
        stack.push(new AbstractMap.SimpleEntry<>(i, max));
    }

    public Entry pop() {
        Entry pop = stack.pop();
        max = stack.isEmpty () ? Integer.MIN_VALUE : (int) stack.peek().getValue();
        return pop;
    }

    public int findMax() {
        return (int) stack.peek().getValue();
    }
}
