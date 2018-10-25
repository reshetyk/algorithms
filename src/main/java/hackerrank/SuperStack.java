package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SuperStack {
    private List<Integer> list = new ArrayList<>();

    public void push(Integer el) {
        list.add(el);
    }

    public Integer pop() {
        Integer res = getLast().orElseThrow(() -> new RuntimeException("empty stack, nothing to pop"));
        list.remove(res);
        return res;
    }

    public Optional<Integer> peek() {
        return getLast();
    }

    private Optional<Integer> getLast() {
        return list.isEmpty() ? Optional.empty() : Optional.of(list.get(list.size() - 1));
    }

    public void inc(Integer indexFrom, Integer numToSum) {
        for (int i = 0; i < indexFrom; i++) {
            list.set(i, list.get(i) + numToSum);
        }
    }

    public static void execute(String[] operations) {
        SuperStack stack = new SuperStack();

        for (String op : operations) {
            String[] commands = op.split(" ");
            switch (commands[0].toLowerCase()) {
                case "push":
                    stack.push(Integer.parseInt(commands[1]));
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "inc":
                    stack.inc(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                    break;
                default:
                    throw new RuntimeException("unknown command [" + commands[0] + "]");
            }
            System.out.println(stack.peek().isPresent() ? stack.peek().get() : "EMPTY");
        }
    }
}