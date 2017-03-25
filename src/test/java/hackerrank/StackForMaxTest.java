package hackerrank;

import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StackForMaxTest {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        StackForMax stack = new StackForMax();
        for(int a0 = 0; a0 < t; a0++){
            Integer operation = in.nextInt();
            switch (operation) {
                case 1:
                    stack.push(in.nextInt());
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println(stack.findMax());
                    break;
            }
        }
    }



    @Test
    public void testFindMax() throws Exception {
        StackForMax stack = new StackForMax();
        stack.push(97);
        stack.pop();
        stack.push(20);
        stack.pop();
        stack.push(26);
        stack.push(20);
        stack.pop();
        assertThat(stack.findMax(), is(26));
        stack.push(91);
        assertThat(stack.findMax(), is(91));
        stack.push(91);
        stack.push(91);
        stack.push(324);
        stack.push(324);
        stack.push(2);
        stack.push(223);
        assertThat(stack.findMax(), is(324));
    }
}