package structure.queue;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by Reshetuyk on 29.03.2017.
 */
public class QueueTest {

    @Test
    public void testQueueArray() throws Exception {
        IQueue<Integer> queue = new QueueArray(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        assertThat(queue.pool()).isEqualTo(1);
        assertThat(queue.pool()).isEqualTo(2);
        assertThat(queue.pool()).isEqualTo(3);
        assertThat(queue.pool()).isEqualTo(4);
        queue.add(6);
        queue.add(7);
        assertThat(queue.pool()).isEqualTo(5);
        assertThat(queue.pool()).isEqualTo(6);
        assertThat(queue.pool()).isEqualTo(7);
    }

    @Test
    public void testQueueLinkedList() throws Exception {
        IQueue<Integer> queue = new QueueLinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertThat(queue.pool()).isEqualTo(1);
        assertThat(queue.pool()).isEqualTo(2);
        queue.add(4);
        queue.add(5);
        assertThat(queue.pool()).isEqualTo(3);
        assertThat(queue.pool()).isEqualTo(4);
        assertThat(queue.pool()).isEqualTo(5);
    }
}
