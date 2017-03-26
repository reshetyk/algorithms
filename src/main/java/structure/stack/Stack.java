package structure.stack;

/**
 * Created by Reshetuyk on 26.03.2017.
 */
public interface Stack<T> {
    T pop();

    void push(T obj);

    T peek();

    boolean isEmpty();
}
