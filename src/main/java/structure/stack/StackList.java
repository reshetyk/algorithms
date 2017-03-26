package structure.stack;

/**
 * Created by Reshetuyk on 26.03.2017.
 */
public class StackList<T> implements Stack<T> {
    static class Node<T> {
        Node<T> next;
        T data;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;

    @Override
    public T pop() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");

        T data = first.data;
        first = first.next;
        return data;
    }

    @Override
    public void push(T obj) {
        if (first == null) {
            first = new Node<>(obj);
        } else {
            Node prev = first;
            first = new Node<>(obj);
            first.next = prev;
        }
    }

    @Override
    public T peek() {
        return first.data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }
}
