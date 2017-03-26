package structure.stack;

import java.util.Arrays;

/**
 * Created by Reshetuyk on 26.03.2017.
 */
public class StackArr<T> implements Stack<T> {
    private static final int CAPACITY = 3;
    private T[] array = (T[]) new Object[CAPACITY];
    private int top = 0;

    public T pop() {
        if (top < 0) {
            throw new IllegalStateException("Cannot pop from empty stack");
        }
        T obj = array[--top];
        array[top] = null;
        if (top % CAPACITY == 0 && top < array.length) {
            array = Arrays.copyOf(array, top);
        }
        return obj;
    }

    public void push(T object) {
        if (top >= array.length) {
            array = Arrays.copyOf(array, array.length + CAPACITY);
        }
        array[top++] = object;
    }

    public T peek() {
        return array[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top <= 0;

    }

}
