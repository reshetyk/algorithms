package structure.stack;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StackArrTest {
    @Test
    public void testStackList () {
        Stack<Integer> stack = new StackList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.peek()).isEqualTo(3);
        assertThat(stack.peek()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(1);
        stack.push(4);
        assertThat(stack.pop()).isEqualTo(4);
    }

    @Test
    public void testStackArr() throws Exception {
        Stack<Integer> stack = new StackArr<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.peek()).isEqualTo(1);
        assertThat(stack.pop()).isEqualTo(1);
        stack.push(5);
        stack.push(6);
        assertThat(stack.pop()).isEqualTo(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(13);
        stack.push(14);
        stack.push(15);
        stack.push(16);
        stack.push(17);
        stack.push(18);
        assertThat(stack.peek()).isEqualTo(18);
        assertThat(stack.peek()).isEqualTo(18);
        stack.push(20);
        stack.push(21);
        assertThat(stack.pop()).isEqualTo(21);
        assertThat(stack.pop()).isEqualTo(20);
        assertThat(stack.pop()).isEqualTo(18);
        assertThat(stack.pop()).isEqualTo(17);
        assertThat(stack.pop()).isEqualTo(16);
        assertThat(stack.pop()).isEqualTo(15);
    }

}