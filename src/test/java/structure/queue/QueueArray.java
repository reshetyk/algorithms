package structure.queue;

import java.util.Arrays;

/**
 * Created by Reshetuyk on 29.03.2017.
 */
public class QueueArray<T> implements IQueue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private T[] queue;
    private int firstIdx = 0;
    private int lastIdx = 0;

    public QueueArray() {
        this(DEFAULT_CAPACITY);
    }

    public QueueArray(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
    }

    @Override
    public void add(T object) {
        if(shouldResize(lastIdx)) {
            queue = Arrays.copyOf(queue, queue.length + capacity);
        }
        queue[lastIdx++] = object;
    }

    @Override
    public T pool() {
        if (lastIdx == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T result = queue[firstIdx];
        queue[firstIdx] = null;
        firstIdx++;

        if (shouldResize(firstIdx)) {
            queue = Arrays.copyOfRange(queue, firstIdx, queue.length);
            lastIdx = lastIdx - firstIdx;
            firstIdx = 0;
        }
        return result;
    }

    private boolean shouldResize(int idx) {
        return idx > 0 && idx % capacity == 0;
    }

}
