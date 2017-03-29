package structure.queue;

/**
 * Created by Reshetuyk on 29.03.2017.
 */
public class QueueLinkedList<T> implements IQueue<T> {
    static class Node<T> {
        Node next;
        T data;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    @Override
    public void add(T object) {
        // 1
        // 1 -> 2
        // 1 -> 2 -> 3
        if (head == null) {
            head = new Node<T>(object);
            tail = head;
        } else {
            tail.next = new Node<T>(object);
            tail = tail.next;
        }
    }

    @Override
    public T pool() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty");
        }
        T data = head.data;
        head = head.next;
        return data;
    }
}
