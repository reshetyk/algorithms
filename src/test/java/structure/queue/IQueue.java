package structure.queue;

/**
 * Created by Reshetuyk on 29.03.2017.
 */
public interface IQueue<T> {
    void add(T object);

    T pool();
}
